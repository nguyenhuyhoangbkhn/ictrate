package hust.edu.vn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import hust.edu.vn.dao.StepScoreDao;
import hust.edu.vn.model.StepScore;

public class StepScoreDaoImpl implements StepScoreDao {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<StepScore> listStepScore() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM STEP_SCORE WHERE FLAG_DELETE = 0";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			List<StepScore> stepScore = new ArrayList<StepScore>();
			while (true) {
				if (rs.next()) {
					StepScore stepScore1 = new StepScore(rs.getInt("id"), rs.getString("name"), rs.getString("note"),
							rs.getString("detail_score"), rs.getInt("flag_delete"), rs.getString("type_score"));
					stepScore.add(stepScore1);
				} else {
					break;
				}
			}
			rs.close();
			ps.close();
			return stepScore;
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
	public void deleteStepScore(int id) {
		String sql = "UPDATE STEP_SCORE SET FLAG_DELETE = 1 WHERE ID=?";
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
	public void addStepScore(StepScore StepScore) {
		String sql = "insert into STEP_SCORE (ID,NAME,NOTE,DETAIL_SCORE,FLAG_DELETE,TYPE_SCORE) values (STEPSCOREID.nextval, ?, ?, ?, ?,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		System.out.println("torng " + StepScore);
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, StepScore.getName());
			ps.setString(2, StepScore.getNote());
			ps.setString(3, StepScore.getDetailScore());
			ps.setInt(4, 0);
			ps.setString(5, StepScore.getTypeScore());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateStepScore(StepScore stepScore) {
		
		String sql = "UPDATE STEP_SCORE SET NAME = ?, NOTE = ?,DETAIL_SCORE=?,TYPE_SCORE= ? WHERE ID=?";
		Connection conn = null;
		PreparedStatement ps = null;
		@SuppressWarnings("unused")
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,stepScore.getName());
			ps.setString(2,stepScore.getNote());
			ps.setString(3,stepScore.getDetailScore());
			ps.setString(4,stepScore.getTypeScore());
			ps.setInt(5, stepScore.getId());
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public StepScore getStepScoreById(int id) {
		String sql = "SELECT * FROM STEP_SCORE WHERE ID = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		StepScore stepScore = new StepScore();
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				stepScore = new StepScore(rs.getInt("id"), rs.getString("name"), rs.getString("note"),
						rs.getString("detail_score"), rs.getInt("flag_delete"),rs.getString("type_score"));
			}
			rs.close();
			ps.close();
			System.out.println("edit" + stepScore);
			return stepScore;
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
	public List<StepScore> searchKeyWord(String keyWord) {
		String sql = "SELECT * FROM STEP_SCORE WHERE ((NAME like  '%"+keyWord+
				"%' OR NOTE LIKE '%"+keyWord+"%') AND FLAG_DELETE = 0)";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			List<StepScore> stepScore = new ArrayList<StepScore>();
			while (true) {
				if (rs.next()) {
					StepScore stepScore1 = new StepScore(rs.getInt("id"), rs.getString("name"), rs.getString("note"),
							rs.getString("detail_score"), rs.getInt("flag_delete"), rs.getString("type_score"));
					stepScore.add(stepScore1);
				} else {
					break;
				}
			}
			rs.close();
			ps.close();
			return stepScore;
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
