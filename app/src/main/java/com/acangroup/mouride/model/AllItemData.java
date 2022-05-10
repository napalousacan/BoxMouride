package com.acangroup.mouride.model;

import com.google.gson.annotations.SerializedName;

public class AllItemData {

	@SerializedName("desc")
	private String desc;

	@SerializedName("sdimage")
	private String sdimage;

	@SerializedName("feed_url")
	private String feed_url;

	@SerializedName("title")
	private String title;

	@SerializedName("type")
	private String type;

	@SerializedName("stream_url")
	private String stream_url;

	public void setDes(String desc){
		this.desc = desc;
	}

	public String getDes(){
		return desc;
	}

	public void setLogo(String sdimage){
		this.sdimage = sdimage;
	}

	public String getLogo(){
		return sdimage;
	}

	public void setFeed_url(String feed_url){
		this.feed_url = feed_url;
	}

	public String getFeed_url(){
		return feed_url;
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

	public void setStreamUrl(String stream_url){
		this.stream_url = stream_url;
	}

	public String getStreamUrl(){
		return stream_url;
	}
}