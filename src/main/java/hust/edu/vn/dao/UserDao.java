package hust.edu.vn.dao;
import java.util.List;

import hust.edu.vn.model.UserInfo;


public interface UserDao {
	
	public List<UserInfo> getUser();
	
	public void updateUser(UserInfo userInfo);

}
