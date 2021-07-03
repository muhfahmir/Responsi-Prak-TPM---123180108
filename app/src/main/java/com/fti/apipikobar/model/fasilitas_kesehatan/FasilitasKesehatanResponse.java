package com.fti.apipikobar.model.fasilitas_kesehatan;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class FasilitasKesehatanResponse{

	@SerializedName("status_code")
	private int statusCode;

	@SerializedName("data")
	private ArrayList<FasilitasKesehatanDataItem> data;

	public void setStatusCode(int statusCode){
		this.statusCode = statusCode;
	}

	public int getStatusCode(){
		return statusCode;
	}

	public void setData(ArrayList<FasilitasKesehatanDataItem> data){
		this.data = data;
	}

	public ArrayList<FasilitasKesehatanDataItem> getData(){
		return data;
	}

	@Override
 	public String toString(){
		return 
			"FasilitasKesehatanResponse{" + 
			"status_code = '" + statusCode + '\'' + 
			",data = '" + data + '\'' + 
			"}";
		}
}