package hust.edu.vn.controller.admin;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import hust.edu.vn.dao.AccessOfficeDao;
import hust.edu.vn.dao.OfficeDao;
import hust.edu.vn.dao.UserDao;
import hust.edu.vn.model.AccessOffice;
import hust.edu.vn.model.Office;
import hust.edu.vn.model.UserInfo;

@Controller
public class OfficeController {

	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
	OfficeDao officeDao = ctx.getBean("officeDao", OfficeDao.class);
	UserDao userDao = ctx.getBean("userDao", UserDao.class);
	private Integer idOffice;
	
	@RequestMapping("/office")
	public String homePage(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo userInfo = userDao.getUserByName(auth.getName());
		model.addAttribute("userInfo",userInfo);

		List<Office> officeList = officeDao.getAllOffice();
		model.addAttribute("officeList", officeList);
		return "office/index";
	}

	@RequestMapping("office/add")
	public ModelAndView showAddForm(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo userInfo = userDao.getUserByName(auth.getName());
		model.addAttribute("userInfo",userInfo);
		return new ModelAndView("office/add", "command", new Office());
	}

	@RequestMapping("office/addOffice")
	public String addOffice(@ModelAttribute("Office") Office office) {
		
		officeDao.addOffice(office);
		return "redirect:/office";
	}

	@RequestMapping("office/edit")
	public String editOfficeById(Model model, @RequestParam("officeid") int id) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo userInfo = userDao.getUserByName(auth.getName());
		model.addAttribute("userInfo",userInfo);
		model.addAttribute("officeDao", officeDao.getOfficeById(id));
		
		return "office/edit";
	}

	@RequestMapping("office/updateOffice")
	public String updateOffice(@ModelAttribute("Office") Office office) {
		
		officeDao.updateOffice(office);
		return "redirect:/office";
	}

	@RequestMapping("office/delete")
	public String deleteOfficeById(Model model, @RequestParam("officeid") int id) {

		officeDao.deleteOffice(id);
		return "redirect:/office";
	}
	
	
	
	@RequestMapping("/accessOffice")
	public String accessOffice(Model model) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		OfficeDao officeDao = ctx.getBean("officeDao", OfficeDao.class);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo userInfo = userDao.getUserByName(auth.getName());
		model.addAttribute("userInfo",userInfo);

		List<Office> officeList = officeDao.getAllOffice();
		model.addAttribute("officeList", officeList);
		return "office/accessOffice";
	}
	@RequestMapping("office/rate")
	public String rateOffice(Model model, @RequestParam("officeID") int officeID) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo userInfo = userDao.getUserByName(auth.getName());
		model.addAttribute("userInfo",userInfo);

		List<hust.edu.vn.model.User> userList = officeDao.getAllExpecter();
		model.addAttribute("userList1",userList);		
		this.idOffice = officeID;
		System.out.println("office id" + this.idOffice);
		return "office/acceessoffice";
	}
	@RequestMapping("office/access")
	public String officeAcces(Model model,String[] user) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		AccessOfficeDao accessOffice = ctx.getBean("accessOfficeDao", AccessOfficeDao.class);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo userInfo = userDao.getUserByName(auth.getName());
		model.addAttribute("userInfo",userInfo);
		
//		OfficeDao officeDao = ctx.getBean("officeDao", OfficeDao.class);
		for (String user1 : user) {
			AccessOffice accessOffice1 = new AccessOffice(user1,String.valueOf(this.idOffice),"");
			accessOffice.addAccessOffice(accessOffice1);
		}
		
		List<Office> officeList = officeDao.getAllOffice();
		model.addAttribute("officeList", officeList);
		

		List<hust.edu.vn.model.User> userList = officeDao.getAllExpecter();
		model.addAttribute("userList1",userList);
		
		return "office/accessOffice";
	}
}
