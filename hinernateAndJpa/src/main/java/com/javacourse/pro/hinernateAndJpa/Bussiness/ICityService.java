package com.javacourse.pro.hinernateAndJpa.Bussiness;

import java.util.List;

import com.javacourse.pro.hinernateAndJpa.Entities.City;

public interface ICityService {
	List<City> getAll();
	void add(City city);
	void update(City city);
	void delete(City city);
	City getById(int id);
}
