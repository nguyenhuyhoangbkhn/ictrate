package hust.edu.vn.dao;
import java.util.List;

import hust.edu.vn.model.Location;


public interface LocationDao {
	
	public List<Location> getAllCityLocation();
	
	public List<Location> getAllCountrysideLocation(int id);
	
	public void deleteLocation(int id);
	
	public void updateLocation (Location location);
	
	public Location getLocationById(int id);
	
	public void AddCity(Location Location);
	
	public void AddDistrictWard(Location Location); 

}
