package com.acangroup.mouride.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponseData {

	@SerializedName("allitems")
	private List<AllItemData> allitems;

	public void setAllitems(List<AllItemData> allitems){
		this.allitems = allitems;
	}

	public List<AllItemData> getAllitems(){
		return allitems;
	}
}