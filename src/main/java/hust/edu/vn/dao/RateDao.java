package hust.edu.vn.dao;

import hust.edu.vn.model.Rate;

public interface RateDao {
	public void addRate(Rate rate);
	
	public Rate getResultByUserAndCriteria(String idUser,String idCriteria);
}
