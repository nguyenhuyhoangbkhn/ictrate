package hust.edu.vn.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import hust.edu.vn.model.UserInfo;
import org.springframework.jdbc.core.RowMapper;

public class UserInfoMapper implements RowMapper<UserInfo> {

	@Override
	public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {

		String userName = rs.getString("Username");
		String password = rs.getString("Password");

		return new UserInfo(userName, password);
	}
}
