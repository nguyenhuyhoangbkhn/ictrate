package hust.edu.vn.controller.admin;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
import org.springframework.web.multipart.MultipartFile;
import hust.edu.vn.dao.AccessOfficeDao;
import hust.edu.vn.dao.CriteriaDao;
import hust.edu.vn.dao.OfficeDao;
import hust.edu.vn.dao.RateDao;
import hust.edu.vn.dao.ResultDao;
import org.springframework.web.servlet.ModelAndView;
import hust.edu.vn.dao.UserDao;
import hust.edu.vn.model.AccessOffice;
import hust.edu.vn.model.CommentJudge;
import hust.edu.vn.model.Criteria;
import hust.edu.vn.model.Office;
import hust.edu.vn.model.Rate;
import hust.edu.vn.model.UserInfo;

@Controller
public class MainController {

	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
	UserDao userDao = ctx.getBean("userDao", UserDao.class);
	OfficeDao officeDao = ctx.getBean("officeDao", OfficeDao.class);

	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String welcomePage(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo userInfo = userDao.getUserByName(auth.getName());
		model.addAttribute("userInfo", userInfo);

		OfficeDao officeDao = ctx.getBean("officeDao", OfficeDao.class);
		List<Office> officeList1 = officeDao.getListOfficeByMark();
		System.out.println("list" + officeList1);
		model.addAttribute("officeList", officeList1);

		List<UserInfo> expectList = userDao.getUserExpect();
		model.addAttribute("expectList", expectList);
		return "office/rank";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminPage(Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo userInfo = userDao.getUserByName(auth.getName());
		model.addAttribute("userInfo", userInfo);

		return "adminPage";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo userInfo = userDao.getUserByName(auth.getName());
		model.addAttribute("userInfo", userInfo);
		return "loginPage";
	}

	@RequestMapping(value = "user/signUpPage", method = RequestMethod.GET)
	// public String signUpPage(Model model) {

	// return "user/signUpPage";
	// }
	public ModelAndView signUpPage(Model model) {

		return new ModelAndView("user/signUpPage", "command", new UserInfo());
	}

	@RequestMapping(value = "user/signUp", method = RequestMethod.POST)
	public ModelAndView signUpSuccess(Model model, UserInfo userInfo) {

		String check = userDao.checkExist(userInfo);
		if (check == "true") {
			System.out.println("ĐÃ TỒN TẠI");
			return new ModelAndView("user/validateSignUp", "command", new UserInfo());
		}
		if (check == "false") {
			userDao.signUpUser(userInfo);
			userDao.signUpRole(userInfo);
			return new ModelAndView("user/signUpSucces", "command",
					new UserInfo(userInfo.getUserName(), userInfo.getPassword()));
		}
		return null;
	}

	@RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
	public String logoutSuccessfulPage(Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo userInfo = userDao.getUserByName(auth.getName());
		model.addAttribute("userInfo", userInfo);

		model.addAttribute("title", "Logout");
		return "logoutSuccessfulPage";
	}

	@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	public String userInfo(Model model, Principal principal) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo userInfo = userDao.getUserByName(auth.getName());
		UserInfo userInfo1 = userDao.getUserInfoByName(auth.getName());
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("userInfo1", userInfo1);

		// Sau khi user login thanh cong se co principal
		String userName = principal.getName();

		System.out.println("test Name: " + userName);

		return "userInfoPage";
	}

	@RequestMapping("/user/edit")
	public String editUserInfo(Model model, @RequestParam("userInfoName") String userName) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo userInfo = userDao.getUserByName(auth.getName());
		UserInfo userInfo1 = userDao.getUserInfoByName(userName);
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("userInfo1", userInfo1);
		return "/user/edit";
	}

	@RequestMapping("user/updateUserInfo")
	public String updateUserInfo(@ModelAttribute("UserInfo") UserInfo userInfo) {

		userDao.updateProfileInfo(userInfo);
		return "redirect:/userInfo";

	}

	@RequestMapping(value = "/savefiles")
	public String uploadResources(UserInfo userInfo, Model model, Principal principal)
			throws IllegalStateException, IOException {

		String saveDirectory = "C:/Users/Hoang/workspace/ictrate/src/main/webapp/WEB-INF/resources/img/";

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

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo userInfo1 = userDao.getUserByName(auth.getName());
		model.addAttribute("userInfo", userInfo1);

		return "redirect:/userInfo";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accessDenied(Model model, Principal principal) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo userInfo = userDao.getUserByName(auth.getName());
		model.addAttribute("userInfo", userInfo);

		if (principal != null) {
			model.addAttribute("message",
					"Hi " + principal.getName() + "<br> You do not have permission to access this page!");
		} else {
			model.addAttribute("msg", "You do not have permission to access this page!");
		}
		return "403Page";
	}

	@RequestMapping(value = "/rank")
	public String rankOffice(Model model) {

		// load office
		OfficeDao officeDao = ctx.getBean("officeDao", OfficeDao.class);
		List<Office> officeList = officeDao.getAllOffice();

		// load criteria
		CriteriaDao cireriaDao = ctx.getBean("criteriaDao", CriteriaDao.class);
		List<Criteria> criterialist = cireriaDao.getCriteriaAndScore();

		// result
		for (Office office : officeList) {
			// voi 1 van phong
			AccessOfficeDao accessOfficeDao = ctx.getBean("accessOfficeDao", AccessOfficeDao.class);
			ResultDao resultDao = ctx.getBean("resultDao", ResultDao.class);

			List<AccessOffice> listAccessOffice = accessOfficeDao.getAccessOfficeById(String.valueOf(office.getId()));
			Integer index = 0;
			Double a = (double) 0;
			for (Criteria criteria : criterialist) {
				// tinh diem voi 1 tieu chi

				RateDao rateDao = ctx.getBean("rateDao", RateDao.class);
				Rate rate = new Rate();
				String array1[] = criteria.getType_criteria().split("\\*/");

				for (AccessOffice accessOffice : listAccessOffice) {
					rate = rateDao.getResultByUserAndCriteria(String.valueOf(accessOffice.getId()),
							String.valueOf(criteria.getId()));
					if (rate.getMark() != null) {
						if (criteria.getNote().equals("Điểm tăng dần")) {
							a = a + (double) (Arrays.asList(array1).indexOf(rate.getMark()) * criteria.getAmong()
									/ array1.length);
						} else {
							a = a + (double) ((array1.length - Arrays.asList(array1).indexOf(rate.getMark()))
									* criteria.getAmong() / array1.length);
						}
						index++;
					}
				}

				Integer idResult = resultDao.getIdByOfficeAndCriteria(String.valueOf(office.getId()),
						String.valueOf(criteria.getId()));

				if (idResult == -1) {
					resultDao.addResult(String.valueOf(office.getId()), String.valueOf(criteria.getId()),
							String.valueOf(a / index));
				} else {
					resultDao.updateResult(idResult, String.valueOf(a / index));
				}
			}

			Double markOffice = resultDao.getMarkOffice(String.valueOf(office.getId()));
			System.out.println("van phogn" + office.getId() + "diem " + markOffice);
			officeDao.updateMarkOffice(office.getId(), String.valueOf(markOffice));
		}

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo userInfo = userDao.getUserByName(auth.getName());
		model.addAttribute("userInfo", userInfo);

		List<Office> officeList1 = officeDao.getListOfficeByMark();
		System.out.println("list" + officeList1);
		model.addAttribute("officeList", officeList1);

		List<UserInfo> expectList = userDao.getUserExpect();
		model.addAttribute("expectList", expectList);
		return "office/rank";

	}

 	@RequestMapping(value = "office/details", method = RequestMethod.GET)
	public String officeRankDetails(Model model, @RequestParam("officeid") int id, CommentJudge commentJudge) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo userInfo = userDao.getUserByName(auth.getName());
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("officeDao", officeDao.getOfficeById(id));
		
		//get comment
		List<CommentJudge> cmtList = userDao.getCommentJudge(id);
		System.out.println("cmt list" + cmtList);
		model.addAttribute("cmtList", cmtList);

		return "office/details";
	}

	@RequestMapping(value = "office/comment", method = RequestMethod.GET)
	public ModelAndView officeCommentJudge(Model model, CommentJudge commentJudge) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo userInfo = userDao.getUserByName(auth.getName());
		model.addAttribute("userInfo", userInfo);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String frmtdDate = dateFormat.format(date);
		CommentJudge commentJudge1 = new CommentJudge();
		commentJudge1.setUsernameid(auth.getName());
		commentJudge1.setOfficeid(commentJudge.getOfficeid());
		commentJudge1.setContent(commentJudge.getContent());
		commentJudge1.setTimes(frmtdDate);
		commentJudge1.setImgprofile(userInfo.getImgprofile());
		userDao.commentJudge(commentJudge1);
		model.addAttribute("comment", commentJudge1);

		return new ModelAndView("office/comment", "command", new CommentJudge());

	}
	
	@RequestMapping(value = "office/deleteCmt")
	public String deleteCmt(Model model, @RequestParam("cmtid") int id, @RequestParam("officeid") int officeid){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo userInfo = userDao.getUserByName(auth.getName());
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("officeDao", officeDao.getOfficeById(officeid));
		userDao.deleteCmt(id);
		return "office/details";
		
	}
	
	@RequestMapping(value = "searchPage", method = RequestMethod.GET)
	public String search(Model model, @RequestParam("searchPage") String searchText) {
		System.out.println("search" + searchText);
		
		return "redirect:/";

	}
	
}