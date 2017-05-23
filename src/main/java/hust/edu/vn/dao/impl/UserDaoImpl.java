package hust.edu.vn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import hust.edu.vn.dao.UserDao;
import hust.edu.vn.model.UserInfo;

public class UserDaoImpl implements UserDao {
	
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<UserInfo> getUser() {
		String sql = "SELECT * FROM USERS";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			List<UserInfo> userList = new ArrayList<UserInfo>();
			while (true) {
				if (rs.next()) {
					UserInfo alocation = new UserInfo(rs.getString("userName"), rs.getString("mail"),rs.getString("imgprofile"));
					userList.add(alocation);
				} else {
					break;
				}
			}
			rs.close();
			ps.close();
			return userList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	@Override
	public void updateUser(UserInfo userInfo) {
		String sql = "UPDATE USERS SET IMGPROFILE=? WHERE USERNAME=?";	
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			// Parameters start with 1
			ps.setString(1, userInfo.getImgprofile());	//get data from database
			ps.setString(2, userInfo.getUserName());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public UserInfo getUserByName(String userName) {
		String sql = "SELECT * FROM USERS WHERE USERNAME = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserInfo userInfo = new UserInfo();
		
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,userName);
			rs = ps.executeQuery();
			if (rs.next()) {
				userInfo = new UserInfo(rs.getString("userName"), rs.getString("mail"),
						rs.getString("imgprofile"),rs.getString("role"));
			}
			rs.close();
			ps.close();
			
			return userInfo;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

}
