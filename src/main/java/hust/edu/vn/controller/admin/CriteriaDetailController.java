package hust.edu.vn.controller.admin;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
import hust.edu.vn.dao.UserDao;
import hust.edu.vn.model.Criteria;
import hust.edu.vn.model.Office;
import hust.edu.vn.model.StepScore;
import hust.edu.vn.model.TypeCriteria;
import hust.edu.vn.model.UserInfo;

import java.util.List;

@SuppressWarnings("unused")
@Controller
public class CriteriaDetailController {

	private ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
	private CriteriaDao cireriaDao = ctx.getBean("criteriaDao", CriteriaDao.class);
	UserDao userDao = ctx.getBean("userDao", UserDao.class);

	@RequestMapping("/criteria")
	public String typeCriteriaIndex(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo userInfo = userDao.getUserByName(auth.getName());
		model.addAttribute("userInfo", userInfo);
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
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo userInfo = userDao.getUserByName(auth.getName());
		model.addAttribute("userInfo", userInfo);
		// add type score in view
		StepScoreDao stepScoreDao = ctx.getBean("stepScoreDao", StepScoreDao.class);
		List<StepScore> stepScoreList = stepScoreDao.listStepScore();
		model.addAttribute("stepScoreList", stepScoreList);
		// add type criteria in view
		TypeCriteriaDao typeCireriaDao = ctx.getBean("typeCriteriaDao", TypeCriteriaDao.class);
		List<TypeCriteria> typeCriteriaList = typeCireriaDao.getAllTypeCriteria();
		model.addAttribute("typeCriteriaList", typeCriteriaList);
		return new ModelAndView("criteria/add", "command", new Criteria());
	}

	@RequestMapping("criteria/addCriteria")
	public String addOffice(@ModelAttribute("Criteria") Criteria criteria) {
		cireriaDao.AddCriteria(criteria);
		return "redirect:/criteria";
	}

	@RequestMapping("criteria/edit")
	public String editOfficeById(Model model, @RequestParam("criteriaid") int id) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo userInfo = userDao.getUserByName(auth.getName());
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("criteriaDao", cireriaDao.getCriteriaById(id));
		
		// add type score in view
		StepScoreDao stepScoreDao = ctx.getBean("stepScoreDao", StepScoreDao.class);
		List<StepScore> stepScoreList = stepScoreDao.listStepScore();
		model.addAttribute("stepScoreList", stepScoreList);
		// add type criteria in view
		TypeCriteriaDao typeCireriaDao = ctx.getBean("typeCriteriaDao", TypeCriteriaDao.class);
		List<TypeCriteria> typeCriteriaList = typeCireriaDao.getFullTypeCriteria();
		model.addAttribute("typeCriteriaList", typeCriteriaList);

		System.out.println(cireriaDao.getCriteriaById(id));

		return "criteria/edit";
	}

	@RequestMapping("criteria/updateCriteria")
	public String updateOffice(@ModelAttribute("Criteria") Criteria criteria) {

		cireriaDao.updateCriteria(criteria);
		return "redirect:/criteria";
	}
}
