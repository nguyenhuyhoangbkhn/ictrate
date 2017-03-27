package hust.edu.vn.controller;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import hust.edu.vn.dao.TypeCriteriaDao;
import hust.edu.vn.model.TypeCriteria;

import java.util.List;
@Controller
public class AdminController {
	
	@RequestMapping("/typecriteria")
	public String typeCriteriaIndex(Model model) {
	@SuppressWarnings("resource")
	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

	TypeCriteriaDao typeCireriaDao = ctx.getBean("typeCriteriaDao", TypeCriteriaDao.class);

	// Location alocation = new Location();

	List<TypeCriteria> typeCriteriaList = typeCireriaDao.getAllTypeCriteria();
	System.out.println("danh sach loai tieu chi" + typeCriteriaList);
	model.addAttribute("typeCriteriaList", typeCriteriaList);
	return "typecriteria/index";
	}
}
