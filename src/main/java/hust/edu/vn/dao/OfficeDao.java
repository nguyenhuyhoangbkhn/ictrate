package hust.edu.vn.dao;

import java.util.List;

import hust.edu.vn.model.User;
import hust.edu.vn.model.Office;

public interface OfficeDao {

	public List<Office> getAllOffice();
	
	public void addOffice(Office office);
	
	public void deleteOffice(int id);
	
	public void updateOffice(Office office);
	
	public Office getOfficeById(int id);
	
	public List<User> getAllExpecter();
	
	public void updateMarkOffice(int id,String mark);
	
	public List<Office> getListOfficeByMark();
	
	public List<Office> searchKeyWord(String keyWord);
}
