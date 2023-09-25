package com.bookapp.model;

public class Genre {
	private String type;
	private String agegroup;
	public Genre() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Genre(String type, String agegroup) {
		super();
		this.type = type;
		this.agegroup = agegroup;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAgegroup() {
		return agegroup;
	}
	public void setAgegroup(String agegroup) {
		this.agegroup = agegroup;
	}
	@Override
	public String toString() {
		return "Genre [type=" + type + ", agegroup=" + agegroup + "]";
	}
	

}
