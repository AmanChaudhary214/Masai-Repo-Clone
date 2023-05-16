package com.masai.dao;

import java.util.List;

import com.masai.dto.Mobile;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public interface MobileDAO {

	public void addMobile(Mobile mob) throws SomethingWentWrongException;

	public void updateMobile(Mobile mob) throws SomethingWentWrongException;

	public void deleteMobile(String model) throws SomethingWentWrongException;

	public List<Mobile> getMobileList() throws SomethingWentWrongException, NoRecordFoundException;

	public List<Mobile> searchMobileByModelNumber(String model) throws SomethingWentWrongException, NoRecordFoundException;

	public List<Mobile> searchMobileByPriceRange(int start, int end)throws SomethingWentWrongException, NoRecordFoundException;
	
}
