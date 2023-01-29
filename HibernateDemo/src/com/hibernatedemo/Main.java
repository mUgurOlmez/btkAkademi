package com.hibernatedemo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//HQL
//"from City c where c.countryCode='TUR' AND  c.district='Ankara'"
//ASC-Ascending
//DESC Descenfing


public class Main {

	public static void main(String[] args) {
		SessionFactory factory =new Configuration().
				configure("hibernate.cfg.xml")
				.addAnnotatedClass(City.class)
				.buildSessionFactory();
		//Unit of Work tasarım deseninib uygulsnmıd halidir
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			/*
			 * List<String> countryCodes = session.
			 * createQuery("Select c.countryCode from City c GROUP BY  c.countryCode").
			 * getResultList();
			 * 
			 * for(String countryCode:countryCodes) { System.out.println(countryCode); }
			 */
			//City city=new City();
//			city.setName("Duzce 10");
//			city.setCountryCode("TUR");
//			city.setDistrict("Karadeniz");
//			city.setPopulation(100000);
//			session.save(city);
			
			/*
			 * City city = session.get(City.class, 4080); city.setPopulation(110000);
			 * 
			 * session.save(city);//save yapmayı unutmamalıyız
			 */			
			City city=session.get(City.class, 4080);
			session.delete(city);
			session.getTransaction().commit();
			System.out.println("Sehir silindi");
			
		}finally {
			factory.close();
		}
		
	}

}
