package com.acangroup.mouride.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponseDirect {

	@SerializedName("allitems")
	private List<AllDirect> allitems;

	public void setAllitems(List<AllDirect> allitems){
		this.allitems = allitems;
	}

	public List<AllDirect> getAllitems(){
		return allitems;
	}
}