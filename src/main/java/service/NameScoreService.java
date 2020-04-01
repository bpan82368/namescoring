package service;

import java.util.List;

public interface NameScoreService {

	/**
	 * This is function is used for Scoring
	 * @param ls
	 * @return final score for the i/p file
	 */
	public int callNameScore(List<String> ls);
	
}
