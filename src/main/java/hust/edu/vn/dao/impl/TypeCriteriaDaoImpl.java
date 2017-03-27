package hust.edu.vn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import hust.edu.vn.dao.TypeCriteriaDao;
import hust.edu.vn.model.Location;
import hust.edu.vn.model.TypeCriteria;

@SuppressWarnings("unused")
public class TypeCriteriaDaoImpl implements TypeCriteriaDao{
	
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public List<TypeCriteria> getAllTypeCriteria() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM TYPE_CRITERIA";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			List<TypeCriteria> typeCriteriaList = new ArrayList<TypeCriteria>();
			while (true) {
				if (rs.next()) {
					TypeCriteria typeCriteria = new TypeCriteria(rs.getInt("id"), rs.getString("name"), rs.getString("note"),
							rs.getInt("id_parent"));
					typeCriteriaList.add(typeCriteria);
				} else {
					break;
				}
			}
			rs.close();
			ps.close();
			return typeCriteriaList;
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
	public TypeCriteria getTypeCriteriaById(int id) {
		String sql = "SELECT * FROM TYPE_CRITERIA WHERE ID=?";
		TypeCriteria typeCriteria = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				typeCriteria = new TypeCriteria();
				typeCriteria.setId(id);
				typeCriteria.setName(rs.getString(2));
				typeCriteria.setNote(rs.getString(3));
				typeCriteria.setId_parent(rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return typeCriteria;
	}

	@Override
	public void deleteTypeCriteria(int id) {
		String sql = "DELETE FROM TYPE_CRITERIA WHERE ID=?";
		Connection conn = null;
		PreparedStatement ps = null;
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
}
