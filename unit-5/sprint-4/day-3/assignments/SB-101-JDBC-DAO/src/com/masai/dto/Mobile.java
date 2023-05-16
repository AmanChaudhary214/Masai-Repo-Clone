package com.masai.dto;

import java.time.LocalDate;

public interface Mobile {
	
	/**
	 * return employee id for the calling object
	 * @return String the employee id for the calling object
	 */

	public String getModel();

	public void setModel(String model);

	public String getCompany();

	public void setCompany(String company);

	public int getPrice();

	public void setPrice(int price);

	public LocalDate getMfg();

	public void setMfg(LocalDate mfg);
}
