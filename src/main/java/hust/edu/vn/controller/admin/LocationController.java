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
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.servlet.ModelAndView;

import hust.edu.vn.dao.LocationDao;
import hust.edu.vn.dao.UserDao;
import hust.edu.vn.model.Location;
import hust.edu.vn.model.UserInfo;

@Controller
public class LocationController {

	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
	LocationDao locationDao = ctx.getBean("locationDao", LocationDao.class);
	UserDao userDao = ctx.getBean("userDao", UserDao.class);

	@RequestMapping("/location")
	public String homePage(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo userInfo = userDao.getUserByName(auth.getName());
		System.out.println(userInfo);
		model.addAttribute("userInfo",userInfo);
		List<Location> locationList = locationDao.getAllCityLocation();
		model.addAttribute("locationlist", locationList);
		return "location/index";
	}

	@RequestMapping("location/add")
	public ModelAndView showAddForm(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo userInfo = userDao.getUserByName(auth.getName());
		model.addAttribute("userInfo",userInfo);
		List<Location> locationList = locationDao.getAllCityLocation();
		model.addAttribute("locationList", locationList);
		return new ModelAndView("location/add", "command", new Location());
	}

	@RequestMapping(value = "location/addById", method = RequestMethod.GET)
	public @ResponseBody ModelAndView getProvince(Model model, @RequestParam("id") int id) {

		List<Location> locationList1 = locationDao.getAllCountrysideLocation(id);
		model.addAttribute("DistrictList", locationList1);
		return new ModelAndView("location/selectWard", "command", new Location());
	}

	@RequestMapping("location/addProvince")
	public String addProvince(@ModelAttribute("Location") Location location) {

		locationDao.AddCity(location);
		return "redirect:/location";
	}

	@RequestMapping("location/addDistrict")
	public String addDistrict(@ModelAttribute("Location") Location location) {

		locationDao.AddDistrictWard(location);
		return "redirect:/location";
	}

	@RequestMapping("location/addWard")
	public String addWard(@ModelAttribute("Location") Location location) {

		locationDao.AddDistrictWard(location);
		System.out.println(location);
		return "redirect:/location";
	}

	@RequestMapping("location/detail")
	public String DetailListLocationDetail(Model model, @RequestParam("locationid") int id) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo userInfo = userDao.getUserByName(auth.getName());
		model.addAttribute("userInfo",userInfo);
		LocationDao locationDao = ctx.getBean("locationDao", LocationDao.class);

		List<Location> locationList = locationDao.getAllCountrysideLocation(id);
		model.addAttribute("locationlist", locationList);
		return "location/index";
	}

	@RequestMapping("location/delete")
	public String deleteLocationById(Model model, @RequestParam("locationid") int id) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo userInfo = userDao.getUserByName(auth.getName());
		model.addAttribute("userInfo",userInfo);
		locationDao.deleteLocation(id);
		return "redirect:/location";
	}

	@RequestMapping("location/edit")
	public String editLocationById(Model model, @RequestParam("locationid") int id) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo userInfo = userDao.getUserByName(auth.getName());
		model.addAttribute("userInfo",userInfo);
		model.addAttribute("locationDao", locationDao.getLocationById(id));
		return "location/edit";
	}

	@RequestMapping("location/updateLocation")
	public String updateLocation(@ModelAttribute("Location") Location location) {
		locationDao.updateLocation(location);
		return "redirect:/location";
	}
}
