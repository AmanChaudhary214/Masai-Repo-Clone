package com.masai.dao;

import java.util.List;

import com.masai.dto.Car;
import com.masai.exception.NoRecordFoundException;
import com.masai.exception.SomethingWentWrongException;

public interface CarDAO {

	void addCar(Car car) throws SomethingWentWrongException;

	List<String> displayCar() throws SomethingWentWrongException, NoRecordFoundException;

	void updateCar(Car car) throws SomethingWentWrongException;

	void deleteCar(String carId)throws SomethingWentWrongException;

}
