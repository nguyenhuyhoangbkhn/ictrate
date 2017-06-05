package hust.edu.vn.dao;

import java.util.List;

import hust.edu.vn.model.StepScore;

public interface StepScoreDao {
	
	public List<StepScore> listStepScore();

	public void deleteStepScore(int id);
	
	public void addStepScore(StepScore StepScore);

	public void updateStepScore(StepScore stepScore);

	public StepScore getStepScoreById(int id);
	
	public List<StepScore> searchKeyWord(String keyWord);
}
