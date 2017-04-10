package hust.edu.vn.controller;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import hust.edu.vn.dao.StepScoreDao;
import hust.edu.vn.model.StepScore;


@Controller
public class StepScoreController {
	@RequestMapping("/stepscore")
	public String homePage(Model model) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		StepScoreDao stepScoreDao = ctx.getBean("stepScoreDao", StepScoreDao.class);
		
		List <StepScore> stepScoreList = stepScoreDao.listStepScore();
		
		model.addAttribute("stepScoreList", stepScoreList);
		return "stepscore/index";
	}
	
	@RequestMapping("stepscore/delete")
	public String deleteTypeCriteriaById(Model model, @RequestParam("id") int id) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		StepScoreDao stepScoreDao = ctx.getBean("stepScoreDao", StepScoreDao.class);
		
		stepScoreDao.deleteStepScore(id);
		return "redirect:/stepscore";
	}
	
	@RequestMapping("stepscore/add")
	public ModelAndView addStepScore(Model model) {
		return new ModelAndView("stepscore/add", "command", new StepScore());
	}
	
	@RequestMapping(value = "/stepscore/addStepScore", method = RequestMethod.POST)
	public String addTypeCriteria(@ModelAttribute("StepScore") StepScore stepScore) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		StepScoreDao stepScoreDao = ctx.getBean("stepScoreDao", StepScoreDao.class);
		System.out.println("tét"+ stepScore.getDetailScore());
//		stepScoreDao.addStepScore(stepScore);
		return "redirect:/stepscore";
	}
	
}
