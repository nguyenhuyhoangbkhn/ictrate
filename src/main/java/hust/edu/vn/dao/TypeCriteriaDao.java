package hust.edu.vn.dao;

import java.util.List;

import hust.edu.vn.model.TypeCriteria;

public interface TypeCriteriaDao {
	public List<TypeCriteria> getAllTypeCriteria();

	public TypeCriteria getTypeCriteriaById(int id);

	public void deleteTypeCriteria(int id);

	public List<TypeCriteria> getListTypeCriteriaById(int id);

	public void AddTypeCriteria(TypeCriteria TypeCriteria);

	public void updateTypeCriteria(TypeCriteria TypeCriteria);
}
