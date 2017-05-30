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

public class CriteriaDaoImpl implements CriteriaDao {
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
					Criteria criteria = new Criteria(rs.getInt("id"), rs.getString("name"), rs.getString("note"),
							rs.getString("type_criteria"), rs.getString("type_score"), rs.getInt("flag_delete"),
							rs.getFloat("among"));
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
		String sql = "SELECT * FROM CRITERIA WHERE ID=? AND FLAG_DELETE = 0";
		Criteria criteria = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				criteria = new Criteria();
				criteria.setId(id);
				criteria.setName(rs.getString(2));
				criteria.setNote(rs.getString(3));
				criteria.setType_criteria(rs.getString(4));
				criteria.setType_score(rs.getString(5));
				criteria.setFlag_delete(rs.getInt(6));
				criteria.setAmong(rs.getFloat(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return criteria;
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
		System.out.println("criteria" + Criteria);
		String sql = "insert into CRITERIA (ID,NAME, NOTE, TYPE_CRITERIA,TYPE_SCORE,FLAG_DELETE, AMONG) "
				+ "values (CRITERIAID.nextval, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, Criteria.getName());
			ps.setString(2, Criteria.getNote());
			ps.setString(3, Criteria.getType_criteria());
			ps.setString(4, Criteria.getType_score());
			ps.setInt(5, 0);
			ps.setFloat(6, Criteria.getAmong());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateCriteria(Criteria Criteria) {
		String sql = "UPDATE CRITERIA SET NAME=?, NOTE=?, TYPE_CRITERIA=?, TYPE_SCORE=?, FLAG_DELETE=?, AMONG=? WHERE ID=?";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			// Parameters start with 1
			ps.setString(1, Criteria.getName());
			ps.setString(2, Criteria.getNote());
			ps.setString(3, Criteria.getType_criteria());
			ps.setString(4, Criteria.getType_score());
			ps.setInt(5, Criteria.getFlag_delete());
			ps.setFloat(6, Criteria.getAmong());
			ps.setInt(7, Criteria.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Criteria> criteriaQualitative() {
		String sql = "SELECT CRITERIA.ID,CRITERIA.NAME,CRITERIA.NOTE,STEP_SCORE.DETAIL_SCORE,CRITERIA.TYPE_SCORE,CRITERIA.FLAG_DELETE,CRITERIA.AMONG "
				+ "FROM CRITERIA  INNER JOIN STEP_SCORE "
				+ "ON CRITERIA.TYPE_SCORE = STEP_SCORE.ID AND STEP_SCORE.TYPE_SCORE = 'Định tính'";

		Connection conn = null;
		PreparedStatement ps = null;

		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			// ps1 = conn.prepareStatement(sql1);
			rs = ps.executeQuery();
			List<Criteria> CriteriaList = new ArrayList<Criteria>();
			while (true) {
				if (rs.next()) {
					Criteria criteria = new Criteria(rs.getInt("id"), rs.getString("name"), rs.getString("note"),
							rs.getString("detail_score"), rs.getString("type_score"), rs.getInt("flag_delete"),
							rs.getFloat("among"));
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
	public List<Criteria> criteriaQuantitative() {
		String sql = "SELECT CRITERIA.ID,CRITERIA.NAME,CRITERIA.NOTE,STEP_SCORE.DETAIL_SCORE,CRITERIA.TYPE_SCORE,CRITERIA.FLAG_DELETE,CRITERIA.AMONG "
				+ "FROM CRITERIA  INNER JOIN STEP_SCORE "
				+ "ON CRITERIA.TYPE_SCORE = STEP_SCORE.ID AND STEP_SCORE.TYPE_SCORE = 'Định lượng'";

		Connection conn = null;
		PreparedStatement ps = null;

		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			// ps1 = conn.prepareStatement(sql1);
			rs = ps.executeQuery();
			List<Criteria> CriteriaList = new ArrayList<Criteria>();
			while (true) {
				if (rs.next()) {
					Criteria criteria = new Criteria(rs.getInt("id"), rs.getString("name"), rs.getString("note"),
							rs.getString("detail_score"), rs.getString("type_score"), rs.getInt("flag_delete"),
							rs.getFloat("among"));
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
	public List<Criteria> getCriteriaAndScore() {
		String sql = "SELECT CRITERIA.ID,CRITERIA.NAME,STEP_SCORE.NOTE,STEP_SCORE.DETAIL_SCORE,"
				+ "CRITERIA.TYPE_SCORE,CRITERIA.FLAG_DELETE,CRITERIA.AMONG "
				+ "FROM CRITERIA  INNER JOIN STEP_SCORE "
				+ "ON CRITERIA.TYPE_SCORE = STEP_SCORE.ID AND CRITERIA.FLAG_DELETE = 0";

		Connection conn = null;
		PreparedStatement ps = null;

		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			// ps1 = conn.prepareStatement(sql1);
			rs = ps.executeQuery();
			List<Criteria> CriteriaList = new ArrayList<Criteria>();
			while (true) {
				if (rs.next()) {
					Criteria criteria = new Criteria(rs.getInt("id"), rs.getString("name"), rs.getString("note"),
							rs.getString("detail_score"), rs.getString("type_score"), rs.getInt("flag_delete"),
							rs.getFloat("among"));
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
}
