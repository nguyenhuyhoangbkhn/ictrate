package hust.edu.vn.dao;

import java.util.List;

import hust.edu.vn.model.Criteria;

public interface CriteriaDao {
	public List<Criteria> getAllCriteria();
	
	public List<Criteria> getCriteriaAndScore();

	public Criteria getCriteriaById(int id);

	public void deleteCriteria(int id);

	public void AddCriteria(Criteria Criteria);

	public void updateCriteria(Criteria Criteria);
	
	//list dinh tinh
	public List<Criteria> criteriaQualitative();
	
	// list dinh luong
	public List<Criteria> criteriaQuantitative();
}
