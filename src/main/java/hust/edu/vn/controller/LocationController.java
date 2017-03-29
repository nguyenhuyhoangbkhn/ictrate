package hust.edu.vn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
