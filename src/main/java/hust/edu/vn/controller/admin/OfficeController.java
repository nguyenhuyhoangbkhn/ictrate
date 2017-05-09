package hust.edu.vn.controller.admin;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import hust.edu.vn.dao.OfficeDao;
import hust.edu.vn.dao.UserDao;
import hust.edu.vn.model.Office;
import hust.edu.vn.model.UserInfo;

@Controller
public class OfficeController {

	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
	OfficeDao officeDao = ctx.getBean("officeDao", OfficeDao.class);
	UserDao userDao = ctx.getBean("userDao", UserDao.class);

	@RequestMapping("/office")
	public String homePage(Model model) {
		List<UserInfo> userList = userDao.getUser();

		model.addAttribute("userList", userList);
		List<Office> officeList = officeDao.getAllOffice();
		model.addAttribute("officeList", officeList);
		return "office/index";
	}

	@RequestMapping("office/add")
	public ModelAndView showAddForm(Model model) {
		List<UserInfo> userList = userDao.getUser();

		model.addAttribute("userList", userList);
		return new ModelAndView("office/add", "command", new Office());
	}

	@RequestMapping("office/addOffice")
	public String addOffice(@ModelAttribute("Office") Office office) {

		officeDao.addOffice(office);
		return "redirect:/office";
	}

	@RequestMapping("office/edit")
	public String editOfficeById(Model model, @RequestParam("officeid") int id) {
		List<UserInfo> userList = userDao.getUser();

		model.addAttribute("userList", userList);
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
}
