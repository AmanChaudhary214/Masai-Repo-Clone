package com.masai.dto;

import java.time.LocalDate;

public interface Company {
	
	public String getcId();

	public void setcId(String cId);

	public String getCname();

	public void setCname(String cname);

	public int getTurnover();

	public void setTurnover(int turnover);

	public LocalDate getReg_date();

	public void setReg_date(LocalDate reg_date) ;
}
