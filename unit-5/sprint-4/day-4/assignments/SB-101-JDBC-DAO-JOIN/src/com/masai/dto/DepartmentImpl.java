package com.masai.dto;

public class DepartmentImpl implements Department {

	private String dId;
	private String dname;
	private String location;
	
	public DepartmentImpl(String dId, String dname, String location) {
		super();
		this.dId = dId;
		this.dname = dname;
		this.location = location;
	}

	public String getdId() {
		return dId;
	}

	public void setdId(String dId) {
		this.dId = dId;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "DepartmentImpl [dId=" + dId + ", dname=" + dname + ", location=" + location + "]";
	}
	
}