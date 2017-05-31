package hust.edu.vn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import hust.edu.vn.dao.OfficeDao;
import hust.edu.vn.model.Office;
import hust.edu.vn.model.User;

public class OfficeDaoImpl implements OfficeDao {
	
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Office> getAllOffice() {
		String sql = "SELECT * FROM OFFICE WHERE FLAG_DELETE = 0";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			List<Office> officeList = new ArrayList<Office>();
			while (true) {
				if (rs.next()) {
					Office anoffice = new Office(rs.getInt("id"), rs.getString("name"), rs.getString("phone"),
							rs.getString("profile"), rs.getString("location"), rs.getString("type_office"), rs.getInt("flag_delete"));
					officeList.add(anoffice);
				} else {
					break;
				}
			}
			rs.close();
			ps.close();
			return officeList;
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
	public void addOffice(Office office) {
		String sql = "insert into OFFICE (ID, NAME, PHONE, PROFILE, LOCATION, TYPE_OFFICE, FLAG_DELETE) values (OFFICEID.nextval, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, office.getName());
			ps.setString(2, office.getPhone());
			ps.setString(3, office.getProfile());
			ps.setString(4, office.getLocation());
			ps.setString(5, office.getType_office());
			ps.setInt(6, 0);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteOffice(int id) {
		String sql = "UPDATE OFFICE SET FLAG_DELETE = 1 WHERE ID=?";
		Connection conn = null;
		PreparedStatement ps = null;
		@SuppressWarnings("unused")
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateOffice(Office office) {
		String sql = "UPDATE OFFICE SET NAME=?, PHONE=?, PROFILE=?, LOCATION=?, TYPE_OFFICE=?, FLAG_DELETE=? WHERE ID=?";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			// Parameters start with 1
			ps.setString(1, office.getName());
			ps.setString(2, office.getPhone());
			ps.setString(3, office.getProfile());
			ps.setString(4, office.getLocation());
			ps.setString(5, office.getType_office());
			ps.setInt(6, office.getFlag_delete());
			ps.setInt(7, office.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Office getOfficeById(int id) {
		String sql = "SELECT * FROM OFFICE WHERE ID=? AND FLAG_DELETE = 0";
		Office anoffice = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				anoffice = new Office();
				anoffice.setId(id);
				anoffice.setName(rs.getString(2));
				anoffice.setPhone(rs.getString(3));
				anoffice.setProfile(rs.getString(4));
				anoffice.setLocation(rs.getString(5));
				anoffice.setType_office(rs.getString(6));
				anoffice.setFlag_delete(rs.getInt(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return anoffice;
	}
	
	public List<User> getAllExpecter() {
		String sql = "SELECT * FROM USER_ROLES WHERE USER_ROLE =  'EXPERT'";
		
		System.out.println(sql);
		Connection conn = null;
		PreparedStatement ps = null;

		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			List<User> UserList = new ArrayList<User>();
			while (true) {
				if (rs.next()) {
					User user = new User(rs.getString("username"), rs.getString("user_role"));
					UserList.add(user);
				} else {
					break;
				}
			}
			rs.close();
			ps.close();
			return UserList;
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
	public void updateMarkOffice(int id, String mark) {
		String sql = "UPDATE OFFICE SET MARK = ? WHERE ID=?";
		Connection conn = null;
		PreparedStatement ps = null;
		@SuppressWarnings("unused")
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, mark);
			ps.setInt(2, id);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Office> getListOfficeByMark() {
		String sql = "SELECT * FROM OFFICE WHERE FLAG_DELETE = 0 ORDER BY MARK";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			List<Office> officeList = new ArrayList<Office>();
			
			while (true) {
				if (rs.next()) {
					Office anoffice = new Office(rs.getInt("id"), rs.getString("name"), rs.getString("phone"),
							rs.getString("profile"), rs.getString("location"), rs.getString("type_office"), rs.getInt("flag_delete"));
					officeList.add(anoffice);
					
				} else {
					break;
				}
			}
			rs.close();
			ps.close();
			return officeList;
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
