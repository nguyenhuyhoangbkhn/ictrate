package hust.edu.vn.controller.admin;

import java.util.List;

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

import hust.edu.vn.dao.StepScoreDao;
import hust.edu.vn.dao.UserDao;
import hust.edu.vn.model.StepScore;
import hust.edu.vn.model.UserInfo;

@Controller
public class StepScoreController {
	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
	StepScoreDao stepScoreDao = ctx.getBean("stepScoreDao", StepScoreDao.class);
	UserDao userDao = ctx.getBean("userDao", UserDao.class);

	@RequestMapping("/stepscore")
	public String homePage(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo userInfo = userDao.getUserByName(auth.getName());
		model.addAttribute("userInfo",userInfo);
		
		List<StepScore> stepScoreList = stepScoreDao.listStepScore();
		model.addAttribute("stepScoreList", stepScoreList);
		return "stepscore/index";
	}

	@RequestMapping("stepscore/delete")
	public String deleteTypeCriteriaById(Model model, @RequestParam("id") int id) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo userInfo = userDao.getUserByName(auth.getName());
		model.addAttribute("userInfo",userInfo);
		
		stepScoreDao.deleteStepScore(id);
		return "redirect:/stepscore";
	}

	@RequestMapping("stepscore/edit")
	public String editTypeCriteriaById(Model model, @RequestParam("id") int id) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo userInfo = userDao.getUserByName(auth.getName());
		model.addAttribute("userInfo",userInfo);
		System.out.println("id" + stepScoreDao.getStepScoreById(id));
		return "redirect:/stepscore";
	}

	@RequestMapping("stepscore/add")
	public ModelAndView addStepScore(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo userInfo = userDao.getUserByName(auth.getName());
		model.addAttribute("userInfo",userInfo);
		return new ModelAndView("stepscore/add", "command", new StepScore());
	}

	@RequestMapping(value = "/stepscore/addStepScore", method = RequestMethod.POST)
	public String addTypeCriteria(@ModelAttribute("StepScore") StepScore stepScore) {
		stepScoreDao.addStepScore(stepScore);
		return "redirect:/stepscore";
	}

}
