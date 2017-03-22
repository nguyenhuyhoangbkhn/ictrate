package hust.edu.vn.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import hust.edu.vn.dao.LocationDao;
import hust.edu.vn.model.Location;

public class Test {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

		LocationDao locationDao = ctx.getBean("locationDao", LocationDao.class);

		// Location alocation = new Location();

		List<Location> locationList = locationDao.getAllLocation();
		System.out.println(locationList);
	}
}