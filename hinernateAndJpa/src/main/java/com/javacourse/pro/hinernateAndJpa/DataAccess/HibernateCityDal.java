package com.javacourse.pro.hinernateAndJpa.DataAccess;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javacourse.pro.hinernateAndJpa.Entities.City;

import jakarta.persistence.EntityManager;
@Repository
public class HibernateCityDal implements ICityDal {
//JPA
	
	private EntityManager entityManager;
	public EntityManager getEntityManager() {
		return entityManager;
	}
	@Autowired
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	//AOP-Aspect Oriented Programming
	@Override
	@Transactional
	public List<City> getAll() {
		Session session= entityManager.unwrap(Session.class);
		List<City> cities= session.createQuery("from City",City.class).getResultList();
		return cities;
	}

	
	@SuppressWarnings("deprecation")
	@Override
	public void add(City city) {
		Session session= entityManager.unwrap(Session.class);
		session.save(city);
		
	}

	@Override
	public void update(City city) {
		Session session= entityManager.unwrap(Session.class);
		session.merge(city);
		
	}

	@Override
	public void delete(City city) {
		Session session= entityManager.unwrap(Session.class);
		City cityToDelete=session.get(City.class, city.getId());
		session.remove(cityToDelete);
	}
	@Override
	public City getbyId(int id) {
		Session session= entityManager.unwrap(Session.class);
		City city=session.get(City.class, id);
		return city;
	}

}
