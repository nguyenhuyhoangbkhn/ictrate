package hust.edu.vn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import hust.edu.vn.dao.RateDao;
import hust.edu.vn.model.Rate;

public class RateDaoImpl implements RateDao{
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public void addRate(Rate rate) {
		String sql = "insert into RATE (ID,ID_ACCESS, ID_CRITERIA, MARK) "
				+ "values (RATEID.nextval, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, rate.getIdAccess());
			ps.setString(2, rate.getIdCriteria());
			ps.setString(3, rate.getMark());
			
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Rate getResultByUserAndCriteria(String idUser, String idCriteria) {
		// TODO Auto-generated method stub
		String s1 = "SELECT * FROM RATE WHERE ID_ACCESS = ?  AND ID_CRITERIA = ? ";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Rate rate = new Rate();
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(s1);
			ps.setString(1, idUser);
			ps.setString(2, idCriteria);
			
			rs = ps.executeQuery();
			if (rs.next()) {
				rate.setId(rs.getInt("id"));
				rate.setIdAccess(idUser);
				rate.setIdCriteria(idCriteria);
				rate.setMark(rs.getString("mark"));
			}
		}catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return rate;
	}

}
