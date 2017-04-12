package hust.edu.vn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.servlet.ModelAndView;

import hust.edu.vn.dao.LocationDao;
import hust.edu.vn.model.Location;

@Controller
public class LocationController {

	@SuppressWarnings("unused")
	@Autowired
	private LocationDao locationDao;

	@RequestMapping("/location")
	public String homePage(Model model) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		LocationDao locationDao = ctx.getBean("locationDao", LocationDao.class);

		List<Location> locationList = locationDao.getAllCityLocation();
		model.addAttribute("locationlist", locationList);
		return "location/index";
	}

	@RequestMapping("location/add")
	public ModelAndView showAddForm(Model model) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

		LocationDao locationDao = ctx.getBean("locationDao", LocationDao.class);

		List<Location> locationList = locationDao.getAllCityLocation();
	
		model.addAttribute("locationList", locationList);
		return new ModelAndView("location/add", "command", new Location());
	}
	
	@RequestMapping(value="location/addById", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getProvince(Model model, @RequestParam("id") int id) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

		LocationDao locationDao = ctx.getBean("locationDao", LocationDao.class);

		System.out.println(id);
		List<Location> locationList1 = locationDao.getAllCountrysideLocation(id);
		model.addAttribute("DistrictList", locationList1);
		System.out.println(locationList1);
		return new ModelAndView("location/selectWard", "command", new Location());
	}
	
	@RequestMapping("location/addProvince")
	public String addProvince(@ModelAttribute("Location") Location location) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

		LocationDao locationDao = ctx.getBean("locationDao", LocationDao.class);
		locationDao.AddCity(location);
		return "redirect:/location";
	}
	
	@RequestMapping("location/addDistrict")
	public String addDistrict(@ModelAttribute("Location") Location location) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

		LocationDao locationDao = ctx.getBean("locationDao", LocationDao.class);
		locationDao.AddDistrictWard(location);
		return "redirect:/location";
	}
	
	@RequestMapping("location/addWard")
	public String addWard(@ModelAttribute("Location") Location location) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

		LocationDao locationDao = ctx.getBean("locationDao", LocationDao.class);
		locationDao.AddDistrictWard(location);
		System.out.println(location);
		return "redirect:/location";
	}
	
	@RequestMapping("location/detail")
	public String DetailListTypecriteriaDetail(Model model, @RequestParam("locationid") int id) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		LocationDao locationDao = ctx.getBean("locationDao", LocationDao.class);

		List<Location> locationList = locationDao.getAllCountrysideLocation(id);
		model.addAttribute("locationlist", locationList);
		return "location/index";
	}

	@RequestMapping("location/delete")
	public String deleteTypeCriteriaById(Model model, @RequestParam("locationid") int id) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		LocationDao locationDao = ctx.getBean("locationDao", LocationDao.class);
		locationDao.deleteLocation(id);
		return "redirect:/location";
	}

	// direct edit form
	@RequestMapping("location/edit")
	public String updateTypeCriteriaById(Model model, @RequestParam("location") int id) {
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		LocationDao locationDao = ctx.getBean("locationDao", LocationDao.class);
		model.addAttribute("typeCireriaDao", locationDao.getLocationById(id));
		return "location/edit";
	}
}
