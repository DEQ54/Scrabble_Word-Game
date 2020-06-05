package application;

import java.util.ArrayList;

public class LevelTwoProcessAlgorithm {
	public static int QuestionNumber=0;
	static int hint=0;
	public static ArrayList<TileWord> levelTwoTileWords;
	public static void FirstQuestion() {
		DataBaseConfiguration.GetSecondLevelQuestions();
		levelTwoTileWords = DataBaseConfiguration.SecondLevelQuestions;
		LevelTwoImplementation.ShuffledLetters(levelTwoTileWords.get(0).getWord().toUpperCase());
	}
	public static void NextQuestion() {
		if(QuestionNumber== levelTwoTileWords.size()-1) {
			Message note = new Message();
			note.LevelSuccessful();
		}else {
			QuestionNumber+=1;
			LevelTwoImplementation.ShuffledLetters(levelTwoTileWords.get(QuestionNumber).getWord().toUpperCase());
		}
	}

	public static String getRecentWord() {
		return levelTwoTileWords.get(QuestionNumber).getWord();
	}
	public static String getHint()
	{
		if(hint==3){
			return "HINT EXHAUSTED";
		}
		else{
			hint++;
		}
		return levelTwoTileWords.get(QuestionNumber).getHint().toUpperCase();
	}
	

}
