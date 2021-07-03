package com.fti.apipikobar.model.kasus_harian;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("metadata")
	private Metadata metadata;

	@SerializedName("content")
	private ArrayList<KasusHarianContentItem> content;

	public void setMetadata(Metadata metadata){
		this.metadata = metadata;
	}

	public Metadata getMetadata(){
		return metadata;
	}

	public void setContent(ArrayList<KasusHarianContentItem> content){
		this.content = content;
	}

	public ArrayList<KasusHarianContentItem> getContent(){
		return content;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"metadata = '" + metadata + '\'' + 
			",content = '" + content + '\'' + 
			"}";
		}
}