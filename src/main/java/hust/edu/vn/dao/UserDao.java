package hust.edu.vn.dao;
import java.util.List;

import hust.edu.vn.model.User;
import hust.edu.vn.model.UserInfo;


public interface UserDao {
	
	public List<UserInfo> getUser();
	
	public UserInfo getUserByName(String userName);
	
	public void updateImgaeProfile(UserInfo userInfo);
	
	public String checkExist(UserInfo userInfo);
	
	public void signUpUser(UserInfo userInfo);

	public void signUpRole(UserInfo userInfo);

}
