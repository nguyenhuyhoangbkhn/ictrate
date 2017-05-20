package hust.edu.vn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

}
