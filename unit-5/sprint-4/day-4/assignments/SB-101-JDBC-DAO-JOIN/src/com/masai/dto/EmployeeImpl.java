package com.masai.dto;

public class EmployeeImpl implements Employee {

	private String empId;
	private String ename;
	private String address;
	private String mobile;
	private String deptId;
	
	public EmployeeImpl(String empId, String ename, String address, String mobile, String deptId) {
		super();
		this.empId = empId;
		this.ename = ename;
		this.address = address;
		this.mobile = mobile;
		this.deptId = deptId;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	@Override
	public String toString() {
		return "EmployeeImpl [empId=" + empId + ", ename=" + ename + ", address=" + address + ", mobile=" + mobile
				+ ", deptId=" + deptId + "]";
	}
	
}