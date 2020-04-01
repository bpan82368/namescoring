package serviceImpl;

import java.util.List;

import service.NameScoreService;
import utility.NameScoring;

public class NameScoreServiceImpl implements NameScoreService {

	
	/**
	 * This is function is used for Scoring
	 * @param ls
	 * @return final score for the i/p file
	 */
	NameScoring namescore = new NameScoring();
	public int callNameScore(List<String> ls) {
		int finalScore = namescore.scoring(ls);
		return finalScore;
	}

	
}
