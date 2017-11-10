package com.pluralsight.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Activity {

	private String id;
	private String desciption;
	private int duration;
	@XmlElement(name="desc")
	public String getDesciption() {
		return desciption;
	}
	public int getDuration() {
		return duration;
	}
	
	public String getId() {
		return id;
	}
	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
	
}
