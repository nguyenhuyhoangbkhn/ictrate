package hust.edu.vn.controller;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import hust.edu.vn.dao.CriteriaDao;
import hust.edu.vn.dao.TypeCriteriaDao;
import hust.edu.vn.model.Criteria;
import hust.edu.vn.model.TypeCriteria;

import java.util.List;

@SuppressWarnings("unused")
@Controller
public class CriteriaDetailController {
	@RequestMapping("/criteria")
	public String typeCriteriaIndex(Model model) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

		CriteriaDao cireriaDao = ctx.getBean("criteriaDao",CriteriaDao.class);

		List<Criteria> criterialist = cireriaDao.getAllCriteria();
		
		model.addAttribute("criterialist", criterialist);
		return "criteria/index";
	}
	
	@RequestMapping("criteria/delete")
	public String deleteTypeCriteriaById(Model model, @RequestParam("criteriaid") int id) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

		CriteriaDao cireriaDao = ctx.getBean("criteriaDao",CriteriaDao.class);

		cireriaDao.deleteCriteria(id);
		return "redirect:/criteria";
	}
	
	@RequestMapping("criteria/add")
	public ModelAndView addCriteria(Model model) {
		
		return new ModelAndView("criteria/add", "command", new Criteria());
	}
}
