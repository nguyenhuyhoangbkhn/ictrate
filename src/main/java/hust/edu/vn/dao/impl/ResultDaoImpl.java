package hust.edu.vn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import hust.edu.vn.dao.ResultDao;

public class ResultDaoImpl implements ResultDao {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public Integer getIdByOfficeAndCriteria(String idOffice, String idCriteria) {
		String s1 = "SELECT * FROM RESULT WHERE ID_OFFICE = ?  AND ID_CRITERIA= ? ";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Integer a = -1;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(s1);
			ps.setString(1, idOffice);
			ps.setString(2, idCriteria);

			rs = ps.executeQuery();
			if (rs.next()) {
				a = rs.getInt("id");
				return a;
			}
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
		return a;

	}

	@Override
	public void addResult(String idOffice, String idCriteria, String Mark) {
		String sql = "insert into RESULT (ID,ID_OFFICE, ID_CRITERIA, MARK) " + "values (RESULTID.nextval, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, idOffice);
			ps.setString(2, idCriteria);
			ps.setString(3, Mark);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateResult(Integer id, String Mark) {
		// String sql = "UPDATE RESULT SET MARK = ? WHERE ID = ? ";
		String sql = "UPDATE RESULT SET MARK=? WHERE ID=?";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			// Parameters start with 1
			ps.setString(1, Mark); // get data from database
			ps.setInt(2, id);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Double getMarkOffice(String idOffice) {
		Double sum = (double) 0;
		String s1 = "SELECT MARK FROM RESULT WHERE ID_OFFICE = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String a;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(s1);
			ps.setString(1, idOffice);

			rs = ps.executeQuery();
			while (true) {
				if (rs.next()) {
					a = rs.getString("mark");
					
					if(!a.equals("NaN")) sum = sum + Double.parseDouble(a);
				} else {
					break;
				}
			}
			
			return sum;
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
