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
		// Location alocation = new Location();
		List<TypeCriteria> typeCriteriaList = typeCireriaDao.getAllTypeCriteria();
		for (TypeCriteria typeCriteria : typeCriteriaList) {
			System.out.println("danh sach loai tieu chi" + typeCriteria);
			if (typeCriteria.getId_parent() != 0) {
				//can giai quyet no thanh kieu cau truc ????
				
			}
		}
		TypeCriteria typeCrieteria = new TypeCriteria();
		typeCrieteria = typeCireriaDao.getTypeCriteriaById(3);
		System.out.println("in ra tim kiem theo id"+typeCrieteria);
		typeCireriaDao.deleteTypeCriteria(10);
	}
}