package hust.edu.vn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
					UserInfo alocation = new UserInfo(rs.getString("userName"), rs.getString("mail"),
							rs.getString("imgprofile"));
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
	public void updateImgaeProfile(UserInfo userInfo) {
		String sql = "UPDATE USERS SET IMGPROFILE=? WHERE USERNAME=?";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			// Parameters start with 1
			ps.setString(1, userInfo.getImgprofile()); // get data from database
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
			ps.setString(1, userName);
			rs = ps.executeQuery();
			if (rs.next()) {
				userInfo = new UserInfo(rs.getString("userName"), rs.getString("mail"), rs.getString("imgprofile"),
						rs.getString("role"));
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

	@Override
	public void signUpUser(UserInfo userInfo) {
		String sql = "insert into USERS (USERNAME,PASSWORD,ENABLED,MAIL,ROLE, TELEPHONE,IMGPROFILE) values (?, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userInfo.getUserName());
			ps.setString(2, userInfo.getPassword());
			ps.setString(3, "1");
			ps.setString(4, userInfo.getMail());
			ps.setString(5, "USER");
			ps.setString(6, userInfo.getTelephone());
			ps.setString(7, userInfo.getImgprofile());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String checkExist(UserInfo userInfo) {
		String sql = "SELECT * FROM USERS WHERE USERNAME ='" + userInfo.getUserName() + "'";
		Connection conn = null;
		Statement ps = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.createStatement();
			ResultSet rs = ps.executeQuery(sql);
			if (rs.next()) {
				return "true";

			} else {
				return "false";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ERROR");
		}
		return null;
	}

	@Override
	public void signUpRole(UserInfo userInfo) {
		String sql = "insert into USER_ROLES (ROLE_ID,USERNAME,USER_ROLE,ID_OFFICE) values (ROLEID.nextval, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userInfo.getUserName());
			ps.setString(2, "USER");
			ps.setString(3, null);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<UserInfo> getUserExpect() {
		String sql = "SELECT * FROM USERS WHERE ROLE = 'EXPERT' AND ROWNUM<=7";
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
					UserInfo alocation = new UserInfo(rs.getString("userName"), rs.getString("mail"),
							rs.getString("imgprofile"));
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
	public UserInfo getUserInfoByName(String userName) {
		String sql = "SELECT * FROM USERS WHERE USERNAME = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserInfo userInfo = new UserInfo();

		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			rs = ps.executeQuery();
			if (rs.next()) {
				userInfo = new UserInfo(rs.getString("userName"), rs.getString("password"), rs.getString("mail"),
						rs.getString("imgprofile"), rs.getString("role"), rs.getString("telephone"),
						rs.getString("dob"), rs.getString("gender"), rs.getString("address"));
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
