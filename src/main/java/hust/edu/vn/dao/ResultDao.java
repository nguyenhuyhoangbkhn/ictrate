package hust.edu.vn.dao;

public interface ResultDao {
	public Integer getIdByOfficeAndCriteria(String idOffice,String idCriteria);
	
	public void addResult(String idOffice,String idCriteria,String Mark);
	
	public void updateResult(Integer id,String Mark);
	
	public Double getMarkOffice(String idOffice); 
}
