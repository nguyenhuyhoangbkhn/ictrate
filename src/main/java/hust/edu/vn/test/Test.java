package hust.edu.vn.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import hust.edu.vn.dao.LocationDao;
import hust.edu.vn.dao.TypeCriteriaDao;
import hust.edu.vn.model.Location;
import hust.edu.vn.model.TypeCriteria;



@SuppressWarnings("unused")
public class Test {
	public static void main(String[] args) {
		//hien thi
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		TypeCriteriaDao typeCireriaDao = ctx.getBean("typeCriteriaDao", TypeCriteriaDao.class);
		LocationDao locationDao = ctx.getBean("locationDao", LocationDao.class);
		// Location alocation = new Location();
		
		List<TypeCriteria> typeCriteriaList = typeCireriaDao.getAllTypeCriteria();
		
		List<Location> locationlist = locationDao.getAllCountrysideLocation(1);
		
		TypeCriteria typeCrieteria1 = new TypeCriteria(12,"hoang","test",2,1);
		typeCireriaDao.AddTypeCriteria(typeCrieteria1);
		System.out.println("da them xong");
		System.out.println(locationlist);
	}
}