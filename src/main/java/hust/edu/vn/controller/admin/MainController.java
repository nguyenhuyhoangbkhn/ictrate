package hust.edu.vn.controller.admin;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import hust.edu.vn.dao.UserDao;
import hust.edu.vn.model.UserInfo;

@Controller
public class MainController {
	
	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
	UserDao userDao = ctx.getBean("userDao", UserDao.class);

	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String welcomePage(Model model) {
		model.addAttribute("title", "Welcome");
		model.addAttribute("message", "This is welcome page!");
		return "welcomePage";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(Model model) {
		return "adminPage";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo userInfo = userDao.getUserByName(auth.getName());
		model.addAttribute("userInfo",userInfo);
		return "loginPage";
	}

	@RequestMapping(value = "user/signUpPage", method = RequestMethod.GET)
	public ModelAndView signUpPage(Model model) {

		return new ModelAndView("user/signUpPage","command", new UserInfo());
	}
	
	@RequestMapping(value = "user/signUp", method = RequestMethod.POST)
	public ModelAndView signUpSuccess(Model model, UserInfo userInfo){
		
		String check = userDao.checkExist(userInfo);
		if(check == "true"){
			System.out.println("ĐÃ TỒN TẠI");
			return new ModelAndView("user/validateSignUp","command", new UserInfo());
		}
		if(check == "false"){
		userDao.signUpUser(userInfo);
		userDao.signUpRole(userInfo);
		return new ModelAndView("user/signUpSucces", "command", new UserInfo(userInfo.getUserName(), userInfo.getPassword()));
		}
		return null;
	}

	@RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
	public String logoutSuccessfulPage(Model model) {
		List <UserInfo> userList = userDao.getUser();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo userInfo = userDao.getUserByName(auth.getName());
		model.addAttribute("userInfo",userInfo);
		model.addAttribute("userList",userList);
		model.addAttribute("title", "Logout");
		return "logoutSuccessfulPage";
	}

	@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	public String userInfo(Model model, Principal principal) {
		List <UserInfo> userList = userDao.getUser();
		
		model.addAttribute("userList",userList);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo userInfo = userDao.getUserByName(auth.getName());
		model.addAttribute("userInfo",userInfo);
		// Sau khi user login thanh cong se co principal
		String userName = principal.getName();

		System.out.println("test Name: " + userName);

		return "userInfoPage";
	}
	
	@RequestMapping(value = "/savefiles")
	public String uploadResources(UserInfo userInfo, Model model, Principal principal)
			throws IllegalStateException, IOException {

		String saveDirectory = "C:/Users/Hung/Documents/ictrate/src/main/webapp/WEB-INF/resources/img/";

		List<MultipartFile> files = userInfo.getImages();

		List<String> fileNames = new ArrayList<String>();
		
		if (null != files && files.size() > 0) {
			for (MultipartFile multipartFile : files) {

				String fileName = multipartFile.getOriginalFilename();
				if (!"".equalsIgnoreCase(fileName)) {
					// Handle file content - multipartFile.getInputStream()
					multipartFile.transferTo(new File(saveDirectory + fileName));
					fileNames.add(fileName);
					
					userInfo.setUserName(principal.getName());
					userInfo.setImgprofile(fileName);
					userDao.updateImgaeProfile(userInfo);
					System.out.println(fileNames);

				}
			}
		}
		return "redirect:/userInfo";
	}
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(Model model, Principal principal) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo userInfo = userDao.getUserByName(auth.getName());
		model.addAttribute("userInfo",userInfo);
		if (principal != null) {
			model.addAttribute("message",
					"Hi " + principal.getName() + "<br> You do not have permission to access this page!");
		} else {
			model.addAttribute("msg", "You do not have permission to access this page!");
		}
		return "403Page";
	}

}