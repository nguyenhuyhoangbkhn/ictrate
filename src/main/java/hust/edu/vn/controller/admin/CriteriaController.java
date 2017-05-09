package hust.edu.vn.controller.admin;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import hust.edu.vn.dao.TypeCriteriaDao;
import hust.edu.vn.dao.UserDao;
import hust.edu.vn.model.TypeCriteria;
import hust.edu.vn.model.UserInfo;

import java.util.List;

@Controller
public class CriteriaController {

	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

	TypeCriteriaDao typeCireriaDao = ctx.getBean("typeCriteriaDao", TypeCriteriaDao.class);
	UserDao userDao = ctx.getBean("userDao", UserDao.class);

	@RequestMapping("/typecriteria")
	public String typeCriteriaIndex(Model model) {
		List<UserInfo> userList = userDao.getUser();

		model.addAttribute("userList", userList);

		List<TypeCriteria> typeCriteriaList = typeCireriaDao.getAllTypeCriteria();
		System.out.println("danh sach loai tieu chi" + typeCriteriaList);
		model.addAttribute("typeCriteriaList", typeCriteriaList);
		return "typecriteria/index";
	}

	@RequestMapping("typecriteria/detail")
	public String DetailListTypecriteriaDetail(Model model, @RequestParam("tyecriteriaid") int id) {
		List<UserInfo> userList = userDao.getUser();

		model.addAttribute("userList", userList);

		List<TypeCriteria> typeCriteriaList = typeCireriaDao.getListTypeCriteriaById(id);
		model.addAttribute("typeCriteriaList", typeCriteriaList);
		return "typecriteria/index";
	}

	@RequestMapping("typecriteria/delete")
	public String deleteTypeCriteriaById(Model model, @RequestParam("tyecriteriaid") int id) {

		typeCireriaDao.deleteTypeCriteria(id);
		return "redirect:/typecriteria";
	}

	@RequestMapping("typecriteria/add")
	public ModelAndView addTypeCriteria(Model model) {
		List<UserInfo> userList = userDao.getUser();

		model.addAttribute("userList", userList);

		List<TypeCriteria> typeCriteriaList = typeCireriaDao.getAllTypeCriteria();

		model.addAttribute("typeCriteriaList", typeCriteriaList);
		return new ModelAndView("typecriteria/add", "command", new TypeCriteria());
	}

	// direct edit form
	@RequestMapping("typecriteria/edit")
	public String updateTypeCriteriaById(Model model, @RequestParam("tyecriteriaid") int id) {
		List<UserInfo> userList = userDao.getUser();

		model.addAttribute("userList", userList);
		model.addAttribute("typeCireriaDao", typeCireriaDao.getTypeCriteriaById(id));
		List<TypeCriteria> typeCriteriaList = typeCireriaDao.getAllTypeCriteria();
		model.addAttribute("typeCriteriaList", typeCriteriaList);
		return "typecriteria/edit";
	}

	@RequestMapping(value = "/typecriteria/updateTypeCriteria", method = RequestMethod.POST)
	public String updateTypeCriteria(@ModelAttribute("TypeCriteria") TypeCriteria typeCriteria) {

		System.out.println("test" + typeCriteria);
		typeCireriaDao.updateTypeCriteria(typeCriteria);
		return "redirect:/typecriteria";
	}

	@RequestMapping(value = "/typecriteria/addTypeCriteria", method = RequestMethod.POST)
	public String addTypeCriteria(@ModelAttribute("TypeCriteria") TypeCriteria typeCriteria) {

		typeCriteria.setId(13);
		typeCriteria.setFlag_delede(1);
		System.out.println("typecriteria" + typeCriteria);
		typeCireriaDao.AddTypeCriteria(typeCriteria);
		return "redirect:/typecriteria";
	}
}
