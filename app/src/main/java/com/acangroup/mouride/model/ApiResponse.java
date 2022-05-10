package com.acangroup.mouride.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ApiResponse{

	@SerializedName("allitems")
	private List<AllItem> allitems;

	public void setAllitems(List<AllItem> allitems){
		this.allitems = allitems;
	}

	public List<AllItem> getAllitems(){
		return allitems;
	}
}