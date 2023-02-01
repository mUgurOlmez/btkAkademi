package com.javacourse.pro.hinernateAndJpa.Bussiness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javacourse.pro.hinernateAndJpa.DataAccess.ICityDal;
import com.javacourse.pro.hinernateAndJpa.Entities.City;

@Service
public class ICityManager implements ICityService {
	private ICityDal cityDal;

	@Autowired
	public ICityManager(ICityDal cityDal) {
		this.cityDal = cityDal;
	}

	@Override
	@Transactional
	public List<City> getAll() {
		return this.cityDal.getAll();
	}

	@Override
	@Transactional
	public void add(City city) {
		//business
		this.cityDal.add(city);
	}

	@Override
	@Transactional
	public void update(City city) {
		this.cityDal.update(city);
	}

	@Override
	@Transactional
	public void delete(City city) {
		this.cityDal.delete(city);
	}

	@Override
	@Transactional
	public City getById(int id) {
		return this.cityDal.getbyId(id);
	}

}
