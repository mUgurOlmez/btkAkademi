package com.javacourse.pro.hinernateAndJpa.DataAccess;
import java.util.List;

import com.javacourse.pro.hinernateAndJpa.Entities.City;//manuel ımport
public interface ICityDal {
	List<City> getAll();
	void add(City city);
	void update(City city);
	void delete(City city);
	City getbyId(int id);

}
