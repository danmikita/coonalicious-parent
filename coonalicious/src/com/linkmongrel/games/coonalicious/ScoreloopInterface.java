package com.linkmongrel.games.coonalicious;


public interface ScoreloopInterface {
	public void OpenScoreloop();

	public void DestroyScoreLoop();
	
	public void SubmitScore(double score);
	
	public void OpenScoreloopLeaderboard(double scoreResult);
}
