package hust.edu.vn.dao;

import java.util.List;

import hust.edu.vn.model.AccessOffice;


public interface AccessOfficeDao {
	public void addAccessOffice(AccessOffice accessOffice);
	
	public Integer getIdByNameAndOffice(String UserID,String OfficeId);
	
	public void updateNote(String Note,Integer Id);
	//get id access user rate office
	public List <AccessOffice> getAccessOfficeById(String idOffice);
	
}
