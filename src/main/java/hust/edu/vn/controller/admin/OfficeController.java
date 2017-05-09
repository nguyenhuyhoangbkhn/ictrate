package hust.edu.vn.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import hust.edu.vn.dao.OfficeDao;
import hust.edu.vn.model.Office;


@Controller
public class OfficeController {
	
	@SuppressWarnings("unused")
	@Autowired
	private OfficeDao officeDao;
	
	@RequestMapping("/office")
	public String homePage(Model model) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		OfficeDao officeDao = ctx.getBean("officeDao", OfficeDao.class);

		List<Office> officeList = officeDao.getAllOffice();
		model.addAttribute("officeList", officeList);
		return "office/index";
	}
	
	@RequestMapping("office/add")
	public ModelAndView showAddForm() {
		
		return new ModelAndView("office/add", "command", new Office());
	}
	
	@RequestMapping("office/addOffice")
	public String addOffice(@ModelAttribute("Office") Office office) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		OfficeDao officeDao = ctx.getBean("officeDao", OfficeDao.class);
		
		officeDao.addOffice(office);
		return "redirect:/office";
	}
	
	@RequestMapping("office/edit")
	public String editOfficeById(Model model, @RequestParam("officeid") int id) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		OfficeDao officeDao = ctx.getBean("officeDao", OfficeDao.class);
	
		model.addAttribute("officeDao", officeDao.getOfficeById(id));
		return "office/edit";	
	}
	
	@RequestMapping("office/updateOffice")
	public String updateOffice(@ModelAttribute("Office") Office office) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		OfficeDao officeDao = ctx.getBean("officeDao", OfficeDao.class);
		
		officeDao.updateOffice(office);
		return "redirect:/office";
	}
	
	@RequestMapping("office/delete")
	public String deleteOfficeById(Model model, @RequestParam("officeid") int id) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		OfficeDao officeDao = ctx.getBean("officeDao", OfficeDao.class);
		
		officeDao.deleteOffice(id);
		return "redirect:/office";
	}
	
	
	
	@RequestMapping("/accessOffice")
	public String accessOffice(Model model) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		OfficeDao officeDao = ctx.getBean("officeDao", OfficeDao.class);

		List<Office> officeList = officeDao.getAllOffice();
		model.addAttribute("officeList", officeList);
		return "office/index";
	}
}
