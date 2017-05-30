package hust.edu.vn.config;

import javax.sql.DataSource;

import hust.edu.vn.dao.AccessOfficeDao;
import hust.edu.vn.dao.CriteriaDao;
import hust.edu.vn.dao.LocationDao;
import hust.edu.vn.dao.OfficeDao;
import hust.edu.vn.dao.RateDao;
import hust.edu.vn.dao.ResultDao;
import hust.edu.vn.dao.StepScoreDao;
import hust.edu.vn.dao.TypeCriteriaDao;
import hust.edu.vn.dao.UserDao;
import hust.edu.vn.dao.UserInfoDAO;
import hust.edu.vn.dao.impl.AccessOfficeDaoImpl;
import hust.edu.vn.dao.impl.CriteriaDaoImpl;
import hust.edu.vn.dao.impl.LocationDaoImpl;
import hust.edu.vn.dao.impl.OfficeDaoImpl;
import hust.edu.vn.dao.impl.RateDaoImpl;
import hust.edu.vn.dao.impl.ResultDaoImpl;
import hust.edu.vn.dao.impl.StepScoreDaoImpl;
import hust.edu.vn.dao.impl.TypeCriteriaDaoImpl;
import hust.edu.vn.dao.impl.UserDaoImpl;
import hust.edu.vn.dao.impl.UserInfoDAOImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
 
@SuppressWarnings("unused")
@Configuration
@ComponentScan("hust.edu.vn.*")
@EnableTransactionManagement
// Load to Environment.
@PropertySource("classpath:datasource-cfg.properties")
public class ApplicationContextConfig {
 
  
 
   // Lưu trữ các giá thuộc tính load bởi @PropertySource.
   @Autowired
   private Environment env;
 
   @Autowired
   private UserInfoDAO userInfoDAO;
 
   @Bean
   public ResourceBundleMessageSource messageSource() {
       ResourceBundleMessageSource rb = new ResourceBundleMessageSource();
       // Load property in message/validator.properties
       rb.setBasenames(new String[] { "messages/validator" });
       return rb;
   }
 
   @Bean(name = "viewResolver")
   public InternalResourceViewResolver getViewResolver() {
       InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
       viewResolver.setPrefix("/WEB-INF/pages/");
       viewResolver.setSuffix(".jsp");
       return viewResolver;
   }
   
// Cấu hình để Upload.
   @Bean(name = "multipartResolver")
   public CommonsMultipartResolver multipartResolver() {
       CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        
       // Set Max Size...
       // commonsMultipartResolver.setMaxUploadSize(...);
        
       return commonsMultipartResolver;
   }
 
   @Bean(name = "dataSource")
   public DataSource getDataSource() {
       DriverManagerDataSource dataSource = new DriverManagerDataSource();
  
       // Xem: datasouce-cfg.properties
       dataSource.setDriverClassName(env.getProperty("ds.database-driver"));
       dataSource.setUrl(env.getProperty("ds.url"));
       dataSource.setUsername(env.getProperty("ds.username"));
       dataSource.setPassword(env.getProperty("ds.password"));
 
       System.out.println("## getDataSource: " + dataSource);
 
       return dataSource;
   }
 
   // Transaction Manager
   @Autowired
   @Bean(name = "transactionManager")
   public DataSourceTransactionManager getTransactionManager(DataSource dataSource) {
       DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
 
       return transactionManager;
   }
  
   @Bean(name = "locationDao")
	public LocationDao locationDao() {
		return new LocationDaoImpl();
	}
   
   @Bean(name = "officeDao")
	public OfficeDao offciceDao() {
		return new OfficeDaoImpl();
	}
   
   @Bean(name = "typeCriteriaDao")
	public TypeCriteriaDao typeCriteriaDao() {
		return new TypeCriteriaDaoImpl();
	}
   
   @Bean(name = "stepScoreDao")
  	public StepScoreDao stepScoreDao() {
  		return new StepScoreDaoImpl();
  	}
   
   @Bean(name = "criteriaDao")
 	public CriteriaDao criteriaDao() {
 		return new CriteriaDaoImpl();
 	}
 
   @Bean(name = "userDao")
	public UserDao userDao() {
		return new UserDaoImpl();
	}
   
   @Bean(name = "accessOfficeDao")
  	public AccessOfficeDao accesOfficeDao() {
  		return new AccessOfficeDaoImpl();
  	}
   @Bean(name = "rateDao")
 	public RateDao rateDao() {
 		return new RateDaoImpl();
 	}
   @Bean(name = "resultDao")
	public ResultDao resultDao() {
		return new ResultDaoImpl();
	}
   
}