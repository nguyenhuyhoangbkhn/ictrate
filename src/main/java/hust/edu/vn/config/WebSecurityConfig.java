package hust.edu.vn.config;

import hust.edu.vn.authentication.MyDBAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
// @EnableWebSecurity = @EnableWebMVCSecurity + Extra features
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	// private String roleAccess[] = { "USER", "ADMIN" };
	@Autowired
	MyDBAuthenticationService myDBAauthenticationService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// Các User trong Database
		auth.userDetailsService(myDBAauthenticationService);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();
		System.out.println("test" + http.authorizeRequests());

		// Các trang không yêu cầu login trang danh cho tat ca moi nguoi
		http.authorizeRequests()
				.antMatchers("/stepscore", "/location", "location/detail", "/typecriteria", "typecriteria/detail",
						"/office",
						"/", "/welcome", "/login", "/logout", "/criteria", "/userInfo")
				.permitAll();

		// trang chi danh cho admin
		http.authorizeRequests()
				.antMatchers("stepscore/add", "/stepscore/delete", "/stepscore/edit", 
						"location/addWard","location/delete", "location/addDistrict", 
						"location/addProvince", "location/delete","location/add", 
						"typecriteria/add", "typecriteria/delete", "typecriteria/edit",
						"/typecriteria/updateTypeCriteria", 
						"/accessOffice", 
						"office/rate", "criteria/add",
						"criteria/delete", "criteria/addCriteria", "/admin")
				.access("hasAnyRole('roleAccess', 'ROLE_ADMIN')");

		// Trang danh cho chuyen gia
		http.authorizeRequests().antMatchers("/scoreOffice", "scoreOffice/expectRate")
				.access("hasAnyRole('roleAccess', 'ROLE_EXPERT')");

		// Trang chi danh cho office
		http.authorizeRequests().antMatchers("officeuserrate").access("hasAnyRole('roleAccess', 'ROLE_OFFICE')");

		// Ngoại lệ AccessDeniedException sẽ ném ra.
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

		// Cấu hình cho Login Form.
		http.authorizeRequests().and().formLogin()
				// Submit URL của trang login
				.loginProcessingUrl("/j_spring_security_check") // Submit URL
				.loginPage("/login")//
				.defaultSuccessUrl("/userInfo")//
				.failureUrl("/login?error=true")//
				.usernameParameter("username")//
				.passwordParameter("password")

				// Cấu hình cho Logout Page.
				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");
	}
}