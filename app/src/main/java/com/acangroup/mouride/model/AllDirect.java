package com.acangroup.mouride.model;

import com.google.gson.annotations.SerializedName;

public class AllDirect {

	@SerializedName("desc")
	private String desc;

	@SerializedName("logo")
	private String logo;

	@SerializedName("feed_url")
	private String feedUrl;

	@SerializedName("title")
	private String title;

	@SerializedName("type")
	private String type;

	@SerializedName("stream_url")
	private String streamUrl;

	public void setDes(String desc){
		this.desc = desc;
	}

	public String getDes(){
		return desc;
	}

	public void setLogo(String logo){
		this.logo = logo;
	}

	public String getLogo(){
		return logo;
	}

	public void setfeedUrl(String feedUrl){
		this.feedUrl = feedUrl;
	}

	public String getfeedUrl(){
		return feedUrl;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setStreamUrl(String streamUrl){
		this.streamUrl = streamUrl;
	}

	public String getStreamUrl(){
		return streamUrl;
	}
}