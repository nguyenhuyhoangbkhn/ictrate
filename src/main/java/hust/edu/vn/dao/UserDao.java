package hust.edu.vn.dao;
import java.util.List;

import hust.edu.vn.model.UserInfo;


public interface UserDao {
	
	public List<UserInfo> getUser();
	
	public UserInfo getUserByName(String userName);
	
	public void updateUser(UserInfo userInfo);

	public List<UserInfo> getUserExpect();
}
