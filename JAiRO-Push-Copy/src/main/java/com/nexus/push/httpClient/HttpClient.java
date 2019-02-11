package com.nexus.push.httpClient;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http2.Http2SecurityUtil;
import io.netty.handler.ssl.OpenSsl;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.SslProvider;
import io.netty.handler.ssl.SupportedCipherSuiteFilter;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ConnectionPool;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.nexus.push.domain.HttpStatusDomain;
import com.nexus.push.domain.PushDomain;

import static io.netty.buffer.Unpooled.wrappedBuffer;
import static io.netty.handler.codec.http.HttpMethod.POST;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

/**
 * An HTTP2 client that allows you to send HTTP2 frames to a server. Inbound and outbound frames are
 * logged. When run from the command-line, sends a single HEADERS frame to the server and gets back
 * a "Hello World" response.
 */
@Slf4j
public final class HttpClient{

	@Autowired
	Environment env;
	
	//연결 실패 시 재시도 횟수
	private int tryCount=0;
	
	public HttpStatusDomain http2Start(PushDomain pushDomain) throws Exception {	
		pushDomain.setApns_full_url(
        		pushDomain.getRequest_type()+
        		pushDomain.getApns_start_url()+
        		":"+pushDomain.getApns_port()+
        		pushDomain.getApns_end_url()+
        		pushDomain.getDevice_token()
			  );
		logger.info("PUSH HTTPclient START !!!!!");
    	logger.info("PUSH HTTPclient DEVICE TYPE : {}",pushDomain.getDevice());
    	logger.info("PUSH HTTPclient DEVICE TOKEN : {}",pushDomain.getDevice_token());
    	logger.info("PUSH HTTPclient REQUEST URL : {}",pushDomain.getApns_full_url());

    	InetSocketAddress addr=getInetSocketAddress(pushDomain);
    	
    	final SslContext sslCtx;
            SslProvider provider = OpenSsl.isAlpnSupported() ? SslProvider.OPENSSL : SslProvider.JDK;
            sslCtx = SslContextBuilder.forClient()
                .sslProvider(provider)
                .ciphers(Http2SecurityUtil.CIPHERS, SupportedCipherSuiteFilter.INSTANCE)
                .build();
            
        EventLoopGroup workerGroup=null;
        Channel channel=null;
        Http2ClientInitializer initializer=null;
        Bootstrap b = null;
        Http2SettingsHandler http2SettingsHandler = null;
        try {
	        workerGroup = new NioEventLoopGroup();
	        initializer = new Http2ClientInitializer(sslCtx, Integer.MAX_VALUE);
            // Configure the client.
            b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class);
            b.option(ChannelOption.SO_KEEPALIVE, true);
            b.remoteAddress(addr);
            b.handler(initializer);
            
		    // Start the client.
		    channel = b.connect().syncUninterruptibly().channel();
		    // Wait for the HTTP/2 upgrade to occur.
            
		    http2SettingsHandler = initializer.settingsHandler();
	        http2SettingsHandler.awaitSettings(60, TimeUnit.SECONDS);
        }catch(IllegalStateException e) {	
    		//네트워크 환경으로 인해 timeout일 경우 3회 재시도
        	if(e.getMessage().contains("Timed out")) {
        		if(tryCount == 10) throw e;
        		tryCount++;
            	logger.info("Connection Fail Reason{}, TRY COUNT : {}",e.getMessage(),tryCount);
            	Thread.sleep(3000);
            	http2Start(pushDomain);
        	}  	
        }catch(UnknownHostException e){
        	//네트워크 문제로 connection fail할 경우 10회 재 시도
        	if(tryCount == 10) throw e;
        	tryCount++;
        	logger.info("Connection Fail Reason{}, TRY COUNT : {}",e.getMessage(),tryCount);
        	Thread.sleep(3000);
        	http2Start(pushDomain);
        }   
        HttpResponseHandler responseHandler = initializer.responseHandler();
        int streamId = 3;
        AsciiString hostName = new AsciiString(addr.toString());
        logger.info("PUSH HTTPClient Sending request(s)...");
            // Create a simple POST request with a body.
            FullHttpRequest request = new DefaultFullHttpRequest(HTTP_1_1, POST, pushDomain.getApns_full_url(),
                    wrappedBuffer(pushDomain.getPost_data().getBytes(CharsetUtil.UTF_8)));
            request.headers().add(HttpHeaderNames.HOST, hostName);
            request.headers().set(HttpHeaderNames.ACCEPT_ENCODING, HttpHeaderValues.GZIP);
            request.headers().set(HttpHeaderNames.ACCEPT_ENCODING, HttpHeaderValues.DEFLATE);
            request.headers().set("apns-topic", pushDomain.getApns_topic());   
            request.headers().set(HttpHeaderNames.AUTHORIZATION, "bearer "+pushDomain.getServer_token());
            responseHandler.put(streamId, channel.write(request), channel.newPromise());
        channel.flush();
        responseHandler.awaitResponses(5, TimeUnit.SECONDS);
        logger.info("PUSH HTTPClient Finished HTTP/2 request(s)");
        
        // Wait until the connection is closed.
        channel.close().syncUninterruptibly();
        workerGroup.shutdownGracefully();

        logger.info("PUSH HTTPClient END !!!!!");

        return new HttpStatusDomain(responseHandler.getResponse_status(), responseHandler.getResponse_message());
    }
	
	public HttpStatusDomain httpStart(PushDomain pushDomain) throws Exception{	
		logger.info("PUSH HTTPclient START !!!!!");
    	logger.info("PUSH HTTPclient DEVICE TYPE : {}",pushDomain.getDevice());
    	logger.info("PUSH HTTPclient DEVICE TOKEN : {}",pushDomain.getDevice_token());
    	logger.info("PUSH HTTPclient REQUEST URL : {}",pushDomain.getFcm_full_url());

			OkHttpClient client = new OkHttpClient.Builder()
					.connectTimeout(60, TimeUnit.MINUTES)
					.followRedirects(true)
					.readTimeout(20, TimeUnit.MINUTES)
					.retryOnConnectionFailure(false)
					.writeTimeout(20, TimeUnit.MINUTES)
					.connectionPool(new ConnectionPool(5, 1, TimeUnit.SECONDS))
					.build();
			Request request = null;
			Response res = null;
			try {
				request = new Request.Builder()
		        		.addHeader("Authorization", "Bearer " + pushDomain.getServer_token())
		        		.addHeader("Content-Type", "application/json; UTF-8")
		        		.url(pushDomain.getFcm_full_url())
		        		.post(RequestBody.create(MediaType.parse("application/json"), pushDomain.getPost_data()))
		        		.build();
				res = client.newCall(request).execute();
			}catch(UnknownHostException e) {
				//네트워크 문제로 connection fail할 경우 10회 재 시도
				if(tryCount == 10) throw e;
	        	tryCount++;
	        	logger.info("Connection Fail Reason{}, TRY COUNT : {}",e.getMessage(),tryCount);
	        	Thread.sleep(3000);
	        	httpStart(pushDomain);
			}
	        String response_message="";
	        if(res.code()!=200) {
	        	response_message=((JsonObject) new JsonParser()
						.parse(res.body().string()))
						.getAsJsonObject("error")
						.get("message").getAsString();
	        }
	        
    	return new HttpStatusDomain(res.code(), response_message);
	}
	
	public InetSocketAddress getInetSocketAddress(PushDomain pushDomain) {
		InetSocketAddress addr=InetSocketAddress.createUnresolved(pushDomain.getApns_start_url(), pushDomain.getApns_port());
		return addr;
	}
	
}