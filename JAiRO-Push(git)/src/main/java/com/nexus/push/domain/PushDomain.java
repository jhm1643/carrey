package com.nexus.push.domain;

import org.json.JSONObject;

import lombok.Data;

@Data
public class PushDomain {
	
	//fcm domain
	private String fcm_start_url;
	private String fcm_end_url;
	private int fcm_port;
	private String fcm_full_url;
	
	//apns domain
	private String apns_topic;
	private String team_id;
	private String key_id;	
	private String apns_start_url;
	//private String apns_start_url2;
	private String apns_end_url;
	private int apns_port;
	private String apns_full_url;
	
	//common domain
	private String title;
	private String server_token;
	private String message;
	private String device;  // ios or android
	private String device_token;	// device token
	private String post_data;
	private String request_type;
	private String key_path;
	private String keyFile_name;
	private JSONObject fcm_data;
}