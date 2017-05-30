package hust.edu.vn.controller.experter;

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

import com.sun.xml.internal.bind.v2.model.core.ID;

import hust.edu.vn.dao.AccessOfficeDao;
import hust.edu.vn.dao.CriteriaDao;
import hust.edu.vn.dao.OfficeDao;
import hust.edu.vn.dao.RateDao;
import hust.edu.vn.dao.UserDao;
import hust.edu.vn.model.AccessOffice;
import hust.edu.vn.model.Criteria;
import hust.edu.vn.model.Office;
import hust.edu.vn.model.Rate;
import hust.edu.vn.model.StepScore;
import hust.edu.vn.model.UserInfo;

@SuppressWarnings("unused")
@Controller
public class experterControlller {
	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
	OfficeDao officeDao = ctx.getBean("officeDao", OfficeDao.class);
	CriteriaDao criteriaDao = ctx.getBean("criteriaDao", CriteriaDao.class);
	UserDao userDao = ctx.getBean("userDao", UserDao.class);
	private int idOffice = 0;

	@RequestMapping("/scoreOffice")
	public String scoreOffice(Model model) {
		// UserInfo expert = new UserInfo();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo userInfo = userDao.getUserByName(auth.getName());
		model.addAttribute("userInfo",userInfo);
		List<Office> officeList = officeDao.getAllOffice();
		model.addAttribute("officeList", officeList);
		System.out.println("test" + officeList);

		return "expert/index";
	}

	@RequestMapping(value = "scoreOffice/rate", method = RequestMethod.GET)
	public String rateCriteriaQualitative(Model model, @RequestParam("office") int officeID) {
		// load information office
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo userInfo = userDao.getUserByName(auth.getName());
		model.addAttribute("userInfo",userInfo);
		Office office = new Office();
		office = officeDao.getOfficeById(officeID);

		this.idOffice = officeID;

		// load criteria

		List<Criteria> criteriaList = criteriaDao.criteriaQualitative();
		System.out.println("criteria " + criteriaList);

		model.addAttribute("office", office);
		model.addAttribute("criteriaList", criteriaList);
		return "expert/rate";

	}

	@RequestMapping(value = "/scoreOffice/expectRate", method = RequestMethod.POST)
	public String addTypeCriteria(@ModelAttribute("StepScore") StepScore stepScore) {
		return "redirect:/scoreOffice";
	}
	
	
	@RequestMapping("scoreOffice/expectRate")
	public String expectRate(Model model,String[] criteria,String noteOffice) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		AccessOfficeDao accessOffice = ctx.getBean("accessOfficeDao", AccessOfficeDao.class);
		RateDao rateDao = ctx.getBean("rateDao",RateDao.class);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Integer a = accessOffice.getIdByNameAndOffice(auth.getName(), String.valueOf(this.idOffice));
		
		accessOffice.updateNote(noteOffice, a);
//		xac dinh tieu chi dinh luong
		List<Criteria> criteriaList = criteriaDao.criteriaQualitative();
		
		Integer i = 0;
//		luu danh gia vao trong ket qua
		for (Criteria criteria1 : criteriaList){
			Rate rate = new Rate(0,String.valueOf(a),String.valueOf(criteria1.getId()),criteria[i]);
			i++;
			rateDao.addRate(rate);
		}
		return "redirect:/scoreOffice";
		
	}

}
