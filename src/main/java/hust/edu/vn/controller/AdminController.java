package hust.edu.vn.controller;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping("typecriteria/detail")
	public String DetailListTypecriteriaDetail(Model model, @RequestParam("tyecriteriaid") int id) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

		TypeCriteriaDao typeCireriaDao = ctx.getBean("typeCriteriaDao", TypeCriteriaDao.class);

		// Location alocation = new Location();
		List<TypeCriteria> typeCriteriaList = typeCireriaDao.getListTypeCriteriaById(id);
		model.addAttribute("typeCriteriaList", typeCriteriaList);
		return "typecriteria/index";
	}

	@RequestMapping("typecriteria/delete")
	public String deleteTypeCriteriaById(Model model, @RequestParam("tyecriteriaid") int id) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		TypeCriteriaDao typeCireriaDao = ctx.getBean("typeCriteriaDao", TypeCriteriaDao.class);
		typeCireriaDao.deleteTypeCriteria(id);
		return "redirect:/typecriteria";
	}

	@RequestMapping("typecriteria/add")
	public ModelAndView addTypeCriteria(Model model) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

		TypeCriteriaDao typeCireriaDao = ctx.getBean("typeCriteriaDao", TypeCriteriaDao.class);

		List<TypeCriteria> typeCriteriaList = typeCireriaDao.getAllTypeCriteria();
		System.out.println("danh sach loai tieu chi" + typeCriteriaList);
		model.addAttribute("typeCriteriaList", typeCriteriaList);
		return new ModelAndView("typecriteria/add", "command", new TypeCriteria());
	}

	@RequestMapping(value = "/typecriteria/addTypeCriteria", method = RequestMethod.POST)
	public String addTypeCriteria(@ModelAttribute("TypeCriteria") TypeCriteria typeCriteria) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		TypeCriteriaDao typeCireriaDao = ctx.getBean("typeCriteriaDao", TypeCriteriaDao.class);
		typeCriteria.setId(13);
		typeCriteria.setFlag_delede(1);
		System.out.println("typecriteria"+ typeCriteria);
		typeCireriaDao.AddTypeCriteria(typeCriteria);
		return "redirect:/typecriteria";
	}
}
