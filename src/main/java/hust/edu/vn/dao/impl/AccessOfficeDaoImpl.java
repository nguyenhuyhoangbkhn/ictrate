package hust.edu.vn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import hust.edu.vn.dao.AccessOfficeDao;
import hust.edu.vn.model.AccessOffice;

public class AccessOfficeDaoImpl implements AccessOfficeDao {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void addAccessOffice(AccessOffice accessOffice) {
		String sql = "insert into ACCESSOFFICE (ID, ID_USER, ID_OFFICE, NOTE) values (ACCESSOFFICEID.nextval, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, accessOffice.getId_user());
			ps.setString(2, accessOffice.getId_office());
			ps.setString(3, accessOffice.getNote());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Integer getIdByNameAndOffice(String UserID, String OfficeId) {
		String s1 = "SELECT ID FROM ACCESSOFFICE WHERE ID_OFFICE = ? and ID_USER = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		Integer a = 0;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(s1);
			
			ps.setString(1, OfficeId);
			ps.setString(2, UserID);
			
			rs = ps.executeQuery();
			if (rs.next()) {
				a = rs.getInt(1);
			}

			ps.close();
			return a;
			
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		return a;
		
		
	}

	@Override
	public void updateNote(String Note, Integer Id) {
		String sql = "UPDATE ACCESSOFFICE SET NOTE = ? WHERE ID = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		@SuppressWarnings("unused")
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, Note);
			ps.setLong(2, Id);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
