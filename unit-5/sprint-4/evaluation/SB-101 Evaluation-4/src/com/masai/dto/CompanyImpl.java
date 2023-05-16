package com.masai.dto;

import java.time.LocalDate;

public class CompanyImpl implements Company{

	private String cId;
	private String cname;
	private int turnover;
	private LocalDate reg_date;
	
	public CompanyImpl(String cId, String cname, int turnover, LocalDate reg_date) {
		super();
		this.cId = cId;
		this.cname = cname;
		this.turnover = turnover;
		this.reg_date = reg_date;
	}

	@Override
	public String getcId() {
		return cId;
	}

	@Override
	public void setcId(String cId) {
		this.cId = cId;
	}

	@Override
	public String getCname() {
		return cname;
	}

	@Override
	public void setCname(String cname) {
		this.cname = cname;
	}

	@Override
	public int getTurnover() {
		return turnover;
	}

	@Override
	public void setTurnover(int turnover) {
		this.turnover = turnover;
	}

	@Override
	public LocalDate getReg_date() {
		return reg_date;
	}

	@Override
	public void setReg_date(LocalDate reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		return "CompanyImpl [cId=" + cId + ", cname=" + cname + ", turnover=" + turnover + ", reg_date=" + reg_date
				+ "]";
	}
	
}
