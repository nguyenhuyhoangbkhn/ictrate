package hust.edu.vn.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import hust.edu.vn.dao.LocationDao;
import hust.edu.vn.dao.OfficeDao;
import hust.edu.vn.dao.StepScoreDao;
import hust.edu.vn.dao.TypeCriteriaDao;
import hust.edu.vn.dao.UserDao;
import hust.edu.vn.model.Location;
import hust.edu.vn.model.Office;
import hust.edu.vn.model.StepScore;
import hust.edu.vn.model.TypeCriteria;
import hust.edu.vn.model.UserInfo;



@SuppressWarnings("unused")
public class Test {
	public static void main(String[] args) {
		//hien thi
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		UserDao userDao = ctx.getBean("userDao", UserDao.class);
		List <UserInfo> officeList = userDao.getUser();
		
		System.out.println("test"+ officeList);
//		StepScoreDao stepScoreDao = ctx.getBean("stepScoreDao", StepScoreDao.class);
//		OfficeDao officeDao = ctx.getBean("officeDao", OfficeDao.class);
//		List <Office> officeList = officeDao.getAllOffice();
//		
//		Office staff = new Office();
//		staff.setId(2);
//		staff.setName("hung");
//		staff.setPhone("hung");
//		staff.setProfile("20");
//		staff.setLocation("hung");
//		staff.setType_office("hung");
//		staff.setFlag_delete(0);
//	
//		officeDao.updateOffice(staff);
//		System.out.println("test"+ staff);
	}
}