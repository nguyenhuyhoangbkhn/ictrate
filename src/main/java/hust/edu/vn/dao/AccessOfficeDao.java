package hust.edu.vn.dao;

import hust.edu.vn.model.AccessOffice;

public interface AccessOfficeDao {
	public void addAccessOffice(AccessOffice accessOffice);
	
	public Integer getIdByNameAndOffice(String UserID,String OfficeId);
	
	public void updateNote(String Note,Integer Id);
}
