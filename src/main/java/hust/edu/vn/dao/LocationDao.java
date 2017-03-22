package hust.edu.vn.dao;
import java.util.List;

import hust.edu.vn.model.Location;


public interface LocationDao {
	
	public List<Location> getAllLocation();
	
	public void updateLocation (Location location);
	
	public Location getLocationById(int id);

}
