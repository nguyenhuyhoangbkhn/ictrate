package hust.edu.vn.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import hust.edu.vn.dao.LocationDao;
import hust.edu.vn.dao.StepScoreDao;
import hust.edu.vn.dao.TypeCriteriaDao;

import hust.edu.vn.model.Location;
import hust.edu.vn.model.StepScore;
import hust.edu.vn.model.TypeCriteria;



@SuppressWarnings("unused")
public class Test {
	public static void main(String[] args) {
		//hien thi
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		StepScoreDao stepScoreDao = ctx.getBean("stepScoreDao", StepScoreDao.class);
		
		List <StepScore> stepScoreList = stepScoreDao.listStepScore();
		System.out.println("test"+ stepScoreList);
	}
}