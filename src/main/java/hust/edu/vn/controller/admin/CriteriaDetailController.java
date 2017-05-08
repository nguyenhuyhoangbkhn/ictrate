package hust.edu.vn.controller.admin;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import hust.edu.vn.dao.CriteriaDao;
import hust.edu.vn.dao.OfficeDao;
import hust.edu.vn.dao.StepScoreDao;
import hust.edu.vn.dao.TypeCriteriaDao;
import hust.edu.vn.model.Criteria;
import hust.edu.vn.model.Office;
import hust.edu.vn.model.StepScore;
import hust.edu.vn.model.TypeCriteria;

import java.util.List;

@SuppressWarnings("unused")
@Controller
public class CriteriaDetailController {

	private ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
	private CriteriaDao cireriaDao = ctx.getBean("criteriaDao", CriteriaDao.class);

	@RequestMapping("/criteria")
	public String typeCriteriaIndex(Model model) {
		List<Criteria> criterialist = cireriaDao.getAllCriteria();
		model.addAttribute("criterialist", criterialist);
		return "criteria/index";
	}

	@RequestMapping("criteria/delete")
	public String deleteTypeCriteriaById(Model model, @RequestParam("criteriaid") int id) {
		cireriaDao.deleteCriteria(id);
		return "redirect:/criteria";
	}

	@RequestMapping("criteria/add")
	public ModelAndView addCriteria(Model model) {
		//add type score in view
		StepScoreDao stepScoreDao = ctx.getBean("stepScoreDao", StepScoreDao.class);
		List <StepScore> stepScoreList = stepScoreDao.listStepScore();
		model.addAttribute("stepScoreList",stepScoreList);
		//add type criteria in view
		TypeCriteriaDao typeCireriaDao = ctx.getBean("typeCriteriaDao", TypeCriteriaDao.class);
		List<TypeCriteria> typeCriteriaList = typeCireriaDao.getAllTypeCriteria();
		model.addAttribute("typeCriteriaList",typeCriteriaList);
		return new ModelAndView("criteria/add", "command", new Criteria());
	}

	@RequestMapping("criteria/addCriteria")
	public String addOffice(@ModelAttribute("Criteria") Criteria criteria) {
		cireriaDao.AddCriteria(criteria);
		return "redirect:/criteria";
	}
}
