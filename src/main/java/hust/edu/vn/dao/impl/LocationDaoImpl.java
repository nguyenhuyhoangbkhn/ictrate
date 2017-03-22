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
	public List<Location> getAllLocation() {
		String sql = "SELECT * FROM LOCATION";
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
	public void updateLocation (Location location) {
		String sql = "UPDATE LOCATION SET NAME=?, TYPE=?, AGE=?, ID_PARENT=?, FLAG_DELETE=? WHERE ID=?";	// update staff infomation
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			// Parameters start with 1
			ps.setString(1, location.getName());	//get data from database
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
		String sql = "SELECT * FROM LOCATION WHERE ID=?";
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