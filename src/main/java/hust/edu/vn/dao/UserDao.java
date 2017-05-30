package hust.edu.vn.dao;
import java.util.List;

import hust.edu.vn.model.UserInfo;


public interface UserDao {
	
	public List<UserInfo> getUser();
	
	public UserInfo getUserByName(String userName);
	
	public UserInfo getUserInfoByName(String userName);
	
	public void updateImgaeProfile(UserInfo userInfo);
	
	public void updateProfileInfo(UserInfo userInfo);
	
	public String checkExist(UserInfo userInfo);
	
	public void signUpUser(UserInfo userInfo);

	public void signUpRole(UserInfo userInfo);

	public List<UserInfo> getUserExpect();
}
