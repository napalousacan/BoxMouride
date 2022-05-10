package com.acangroup.mouride.model;

import com.google.gson.annotations.SerializedName;

public class AllItem{

	@SerializedName("des")
	private String des;

	@SerializedName("logo")
	private String logo;

	@SerializedName("hls_url")
	private String hlsUrl;

	@SerializedName("title")
	private String title;

	@SerializedName("type")
	private String type;

	@SerializedName("stream_url")
	private String streamUrl;

	public void setDes(String des){
		this.des = des;
	}

	public String getDes(){
		return des;
	}

	public void setLogo(String logo){
		this.logo = logo;
	}

	public String getLogo(){
		return logo;
	}

	public void setHlsUrl(String hlsUrl){
		this.hlsUrl = hlsUrl;
	}

	public String getHlsUrl(){
		return hlsUrl;
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