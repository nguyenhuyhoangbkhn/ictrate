package hust.edu.vn.controller.experter;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class experterControlller {
	@RequestMapping("/scoreOffice")
	public String scoreOffice(Model model) {
//		UserInfo expert = new UserInfo();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("tesstasdasdasd" + auth.getName());
		
		
		return "expert/index";
	}
}
