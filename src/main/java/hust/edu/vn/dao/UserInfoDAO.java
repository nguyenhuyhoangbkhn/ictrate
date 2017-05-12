package hust.edu.vn.dao;

import java.util.List;

import hust.edu.vn.model.UserInfo;
 
public interface UserInfoDAO {
     
    public UserInfo findUserInfo(String userName);
     
    // [USER,AMIN,..]
    public List<String> getUserRoles(String userName);
     
//    public List<User> getAllExpecter();
}