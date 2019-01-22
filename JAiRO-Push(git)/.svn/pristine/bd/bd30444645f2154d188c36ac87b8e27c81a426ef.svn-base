package com.nexus.push.service;


import javax.servlet.ServletContext;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.nexus.push.domain.HttpStatusDomain;
import com.nexus.push.domain.PushDomain;
import com.nexus.push.httpClient.HttpClient;
import com.nexus.push.util.fcmApnsTokenHandler;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Service
@PropertySource("classpath:META-INF/push.properties")
@Slf4j
public class PushServiceImpl implements PushService{

	@Autowired
	Environment env;
	
	@Autowired
	ServletContext servletContext;

	HttpClient httpclient = new HttpClient();
	fcmApnsTokenHandler tokenHandler = new fcmApnsTokenHandler();
	
	@Override
	public HttpStatusDomain fcmPush(PushDomain pushDomain) throws Exception{
		logger.info("FCM PUSH START !!!!!");
		//fcm token setting
		pushDomain.setKey_path(env.getProperty("fcm.keyPath"));
		pushDomain.setKeyFile_name(env.getProperty("fcm.key.fileName"));
		tokenHandler.fcmTokenSet(pushDomain, servletContext);
		
		//fcm POST data setting
		logger.info("FCM PUSH DATA MAKE START !!!!!");
        JSONObject messageObject = new JSONObject();
        JSONObject dataObject = new JSONObject();
        JSONObject androidObject = new JSONObject();
        JSONObject parentObject = new JSONObject();
        androidObject.put("priority", "high");
        dataObject.put("body", pushDomain.getMessage()); // Notification body
        dataObject.put("title", pushDomain.getTitle());
        messageObject.put("token", pushDomain.getDevice_token()); 
        messageObject.put("notification", dataObject);
        messageObject.put("android", androidObject);
        //notificationObject.put("data", dataObject); 추후 tony m의 앱으로 사용할 경우 data로 파싱해야함
        parentObject.put("message", messageObject); // deviceID
        logger.info("FCM PUSH DATA : {}",parentObject.toString());        
        pushDomain.setPost_data(parentObject.toString());
        logger.info("FCM PUSH DATA MAKE END !!!!!");
        
        //fcm url setting
        pushDomain.setFcm_start_url(env.getProperty("fcm.start.url"));
        pushDomain.setFcm_end_url(env.getProperty("fcm.end.url"));
        pushDomain.setFcm_port(Integer.parseInt(env.getProperty("fcm.port")));
        pushDomain.setRequest_type(env.getProperty("fcm.req.type"));
        pushDomain.setFcm_full_url(
        						pushDomain.getRequest_type()+
        						pushDomain.getFcm_start_url()+
        						pushDomain.getFcm_end_url()
        					  );
        return httpclient.httpStart(pushDomain);
	}
	
	@Override
	public HttpStatusDomain apnsPush(PushDomain pushDomain) throws Exception{
		
		logger.info("APNS PUSH START !!!!!");
		//apns token setting
		pushDomain.setKey_id(env.getProperty("apns.keyId"));
		pushDomain.setTeam_id(env.getProperty("apns.teamId"));
		pushDomain.setKey_path(env.getProperty("apns.keyPath"));
		pushDomain.setKeyFile_name(env.getProperty("apns.p8.fileName"));
		tokenHandler.apnsTokenSet(pushDomain, servletContext);
		
		//apns POST data setting
		logger.info("APNS PUSH DATA MAKE START !!!!!");
		JSONObject apsObject = new JSONObject();
		JSONObject alertObject = new JSONObject();
		JSONObject dataObject = new JSONObject();
		dataObject.put("title", pushDomain.getTitle());
		dataObject.put("body", pushDomain.getMessage());
		alertObject.put("alert", dataObject);
		apsObject.put("aps", alertObject);
		logger.info("APNS PUSH DATA : {}",apsObject.toString());
        pushDomain.setPost_data(apsObject.toString());
        logger.info("APNS PUSH DATA MAKE END !!!!!");
        
        //apns topic setting
        pushDomain.setApns_topic(env.getProperty("apns.topic"));
        
        //apns url setting
        pushDomain.setApns_start_url(env.getProperty("apns.start.url"));
        pushDomain.setApns_end_url(env.getProperty("apns.end.url"));
        pushDomain.setApns_port(Integer.parseInt(env.getProperty("apns.port")));
        pushDomain.setRequest_type(env.getProperty("apns.req.type"));
        
		return httpclient.http2Start(pushDomain);
	}
}
