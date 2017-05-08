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

		// Các trang không yêu cầu login
		http.authorizeRequests()
				.antMatchers(
						"/", "/welcome", "/login", "/logout", 
						"/typecriteria", "typecriteria/detail", 
						"/stepscore",
						"/location",
						"/criteria"
				).permitAll();

		// Trang /userInfo yêu cầu phải login với vai trò USER hoặc ADMIN.
		// Nếu chưa login, nó sẽ redirect tới trang /login.

		//http.authorizeRequests().antMatchers("/userInfo").access("hasAnyRole('roleAccess', 'ROLE_ADMIN')");
		
		// trang chi danh cho admin
		http.authorizeRequests().antMatchers(
				"/userInfo",
				"/admin", "/typecriteria/delete", "/typecriteria/add",
				"typecriteria/edit", "/stepscore/add","/stepscore/edit","/stepscore/delete",
				"criteria/add","criteria/delete","criteria/addCriteria" //"criteria/edit",
				).access("hasAnyRole('roleAccess', 'ROLE_ADMIN')");
		
		http.authorizeRequests().antMatchers("/scoreOffice").access("hasAnyRole('roleAccess', 'ROLE_EXPERT')");
		
//		// Trang chỉ dành cho ADMIN
//		http.authorizeRequests().antMatchers("/admin", "/typecriteria/delete", "/typecriteria/add",
//				"typecriteria/edit", "/stepscore/add","/stepscore/edit","/stepscore/delete",
//				"criteria/add","criteria/delete","criteria/addCriteria" //"criteria/edit",
//				).access("hasRole('ROLE_ADMIN')");

		
		
		// Khi người dùng đã login, với vai trò XX.
		// Nhưng truy cập vào trang yêu cầu vai trò YY,
		// Ngoại lệ AccessDeniedException sẽ ném ra.
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

		// Cấu hình cho Login Form.
		http.authorizeRequests().and().formLogin()//

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