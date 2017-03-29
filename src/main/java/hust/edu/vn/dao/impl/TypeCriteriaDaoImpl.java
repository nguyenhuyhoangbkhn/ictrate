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
public class TypeCriteriaDaoImpl implements TypeCriteriaDao {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<TypeCriteria> getAllTypeCriteria() { //Lấy các tiêu chí lớn
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM TYPE_CRITERIA WHERE ID_PARENT = 0 AND FLAG_DELETE = 0";
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
					TypeCriteria typeCriteria = new TypeCriteria(rs.getInt("id"), rs.getString("name"),
							rs.getString("note"), rs.getInt("id_parent"),rs.getInt("flag_delete"));
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
		System.out.println("test");
		String sql = "SELECT * FROM TYPE_CRITERIA WHERE FLAG_DELETE = 0 AND ID=?";
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
		String sql = "UPDATE TYPE_CRITERIA SET FLAG_DELETE = 1 WHERE ID=?";
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

	@Override
	public List<TypeCriteria> getListTypeCriteriaById(int id) { //Lấy tiêu chí con theo tiêu chí lớn
		String sql = "SELECT * FROM TYPE_CRITERIA WHERE FLAG_DELETE = 0 AND ID_PARENT = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			List<TypeCriteria> typeCriteriaList = new ArrayList<TypeCriteria>();
			while (true) {
				if (rs.next()) {
					TypeCriteria typeCriteria = new TypeCriteria(rs.getInt("id"), rs.getString("name"),
							rs.getString("note"), rs.getInt("id_parent"),rs.getInt("flag_delete"));
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
	public void AddTypeCriteria(TypeCriteria TypeCriteria) {
		// TODO Auto-generated method stub
		String sql = "insert into TYPE_CRITERIA (ID,NAME,NOTE,ID_PARENT,FLAG_DELETE) values (TYPECRITERIAID.nextval, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, TypeCriteria.getName());	
			ps.setString(2, TypeCriteria.getNote());
			ps.setInt(3, TypeCriteria.getId_parent());
			ps.setInt(4, TypeCriteria.getFlag_delede());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
