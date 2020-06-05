package application;

import java.util.ArrayList;

public class LevelThreeProcessAlgorithm {
	public static int QuestionNumber=0;
	static int hint=0;
	public static ArrayList<TileWord> levelThreeTileWords;
	public static void FirstQuestion() {
		DataBaseConfiguration.GetThirdLevelQuestions();
		levelThreeTileWords = DataBaseConfiguration.ThirdLevelQuestions;
		LevelThreeImplementation.ShuffledLetters(levelThreeTileWords.get(0).getWord());
	}
	public static void NextQuestion() {
		if(QuestionNumber== levelThreeTileWords.size()-1) {
			Message note = new Message();
			note.LevelSuccessful();
		}else {
			QuestionNumber+=1;
			LevelThreeImplementation.ShuffledLetters(levelThreeTileWords.get(QuestionNumber).getWord());
		}
	}

	public static String getRecentWord() {
		return levelThreeTileWords.get(QuestionNumber).getWord();
	}
	public static String getHint()
	{
		if(hint==3){
			return "HINT EXHAUSTED";
		}
		else{
			hint++;
		}
		return levelThreeTileWords.get(QuestionNumber).getHint().toUpperCase();
	}
	
	

}
