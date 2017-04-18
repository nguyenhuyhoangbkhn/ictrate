package hust.edu.vn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import hust.edu.vn.dao.CriteriaDao;
import hust.edu.vn.model.Criteria;

public class CriteriaDaoImpl implements CriteriaDao{
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public List<Criteria> getAllCriteria() {
		// TODO Auto-generated method stub
				String sql = "SELECT * FROM CRITERIA WHERE FLAG_DELETE = 0";
				Connection conn = null;
				PreparedStatement ps = null;
				
				ResultSet rs = null;
				try {
					conn = dataSource.getConnection();
					ps = conn.prepareStatement(sql);
					rs = ps.executeQuery();
					List<Criteria> CriteriaList = new ArrayList<Criteria>();
					while (true) {
						if (rs.next()) {
							Criteria criteria = new Criteria(rs.getInt("id"), rs.getString("name"),	rs.getString("note"),
									rs.getString("type_criteria"), rs.getString("type_score"),rs.getInt("flag_delete"));
							CriteriaList.add(criteria);
						} else {
							break;
						}
					}
					rs.close();
					ps.close();
					return CriteriaList;
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
	public Criteria getCriteriaById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCriteria(int id) {
		String sql = "UPDATE CRITERIA SET FLAG_DELETE = 1 WHERE ID=?";
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
	public void AddCriteria(Criteria Criteria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCriteria(Criteria Criteria) {
		// TODO Auto-generated method stub
		
	}

}