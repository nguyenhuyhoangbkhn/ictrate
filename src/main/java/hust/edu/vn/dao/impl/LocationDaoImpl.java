package hust.edu.vn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import hust.edu.vn.dao.LocationDao;
import hust.edu.vn.model.Location;

public class LocationDaoImpl implements LocationDao {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void AddCity(Location Location) {
		String sql = "insert into LOCATION (ID,NAME,TYPE,ID_PARENT,FLAG_DELETE) values (LOCATIONID.nextval, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, Location.getName());
			ps.setString(2, Location.getType());
			ps.setInt(3, 0);
			ps.setInt(4, 0);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void AddDistrictWard(Location Location) {
		String sql = "insert into LOCATION (ID,NAME,TYPE,ID_PARENT,FLAG_DELETE) values (LOCATIONID.nextval, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, Location.getName());
			ps.setString(2, Location.getType());
			ps.setInt(3, Location.getId_parent());
			ps.setInt(4, 0);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Location> getAllCityLocation() { // Lấy Thành Phố/Tỉnh
		String sql = "SELECT * FROM LOCATION WHERE ID_PARENT = 0 AND FLAG_DELETE = 0";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			List<Location> locationList = new ArrayList<Location>();
			while (true) {
				if (rs.next()) {
					Location alocation = new Location(rs.getInt("id"), rs.getString("name"), rs.getString("type"),
							rs.getInt("id_parent"), rs.getInt("flag_delete"));
					locationList.add(alocation);
				} else {
					break;
				}
			}
			rs.close();
			ps.close();
			return locationList;
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
	public List<Location> getAllCountrysideLocation(int id) {
		String sql = "SELECT * FROM LOCATION WHERE FLAG_DELETE = 0 AND ID_PARENT = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			List<Location> locationList = new ArrayList<Location>();
			while (true) {
				if (rs.next()) {
					Location alocation = new Location(rs.getInt("id"), rs.getString("name"), rs.getString("type"),
							rs.getInt("id_parent"), rs.getInt("flag_delete"));
					locationList.add(alocation);
				} else {
					break;
				}
			}
			rs.close();
			ps.close();
			return locationList;
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
	public void deleteLocation(int id) {
		String sql = "UPDATE LOCATION SET FLAG_DELETE = 1 WHERE ID=?";
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
	public void updateLocation(Location location) {
		String sql = "UPDATE LOCATION SET NAME=?, TYPE=?, AGE=?, ID_PARENT=?, FLAG_DELETE=? WHERE ID=?"; // update
																											// staff
																											// infomation
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			// Parameters start with 1
			ps.setString(1, location.getName()); // get data from database
			ps.setString(2, location.getType());
			ps.setInt(3, location.getId_parent());
			ps.setInt(4, location.getFlag_delete());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Location getLocationById(int id) {
		String sql = "SELECT * FROM LOCATION WHERE ID=? AND FLAG_DELETE = 0";
		Location alocation = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				alocation = new Location();
				alocation.setId(id);
				alocation.setName(rs.getString(2));
				alocation.setType(rs.getString(3));
				alocation.setId_parent(rs.getInt(4));
				alocation.setFlag_delete(rs.getInt(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alocation;
	}

}