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

import hust.edu.vn.dao.CriteriaDao;
import hust.edu.vn.dao.OfficeDao;
import hust.edu.vn.model.Criteria;
import hust.edu.vn.model.Office;
import hust.edu.vn.model.StepScore;



@SuppressWarnings("unused")
@Controller
public class experterControlller {
	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
	OfficeDao officeDao = ctx.getBean("officeDao", OfficeDao.class);
	CriteriaDao criteriaDao = ctx.getBean("criteriaDao",CriteriaDao.class);
	private int idOffice = 0;
	
	@RequestMapping("/scoreOffice")
	public String scoreOffice(Model model) {
//		UserInfo expert = new UserInfo();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("tesstasdasdasd" + auth.getName());
		
		List<Office> officeList = officeDao.getAllOffice();
		model.addAttribute("officeList", officeList);
		System.out.println("test" + officeList);
		
		return "expert/index";
	}
	
	@RequestMapping(value = "scoreOffice/rate", method = RequestMethod.GET)
	public String rateCriteriaQualitative(Model model,@RequestParam("office") int officeID){
		//load information office
		Office office = new Office();
		office = officeDao.getOfficeById(officeID);
		
		this.idOffice = officeID;
	
		//load criteria
		
		List<Criteria> criteriaList = criteriaDao.criteriaQualitative();
		System.out.println("criteria " + criteriaList);
		
		model.addAttribute("office",office);
		model.addAttribute("criteriaList",criteriaList);
		return "expert/rate";
		
	}
	
	@RequestMapping(value = "/scoreOffice/expectRate", method = RequestMethod.POST)
	public String addTypeCriteria(@ModelAttribute("StepScore") StepScore stepScore) {
		System.out.println("id office" + this.idOffice);
		return "redirect:/scoreOffice";
	}
	
}
