package com.fti.apipikobar.model.kasus_harian;

import com.google.gson.annotations.SerializedName;

public class Metadata{

	@SerializedName("last_update")
	private String lastUpdate;

	public void setLastUpdate(String lastUpdate){
		this.lastUpdate = lastUpdate;
	}

	public String getLastUpdate(){
		return lastUpdate;
	}

	@Override
 	public String toString(){
		return 
			"Metadata{" + 
			"last_update = '" + lastUpdate + '\'' + 
			"}";
		}
}