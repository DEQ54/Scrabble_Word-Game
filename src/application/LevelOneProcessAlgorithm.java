package application;

import java.util.ArrayList;

public class LevelOneProcessAlgorithm {
	
	public static int QuestionNumber=0;
	static int hint=0;
	public static ArrayList<TileWord> levelOneTileWords;
	public static void FirstQuestion() {
		DataBaseConfiguration.GetFirstLevelQuestions();
		levelOneTileWords = DataBaseConfiguration.FirstLevelQuestions;
		LevelOneImplementation.ShuffledLetters(levelOneTileWords.get(0).getWord());
	}
	public static void NextQuestion() {
		if(QuestionNumber== levelOneTileWords.size()-1) {
			Message note = new Message();
			note.LevelSuccessful();

		}else {
			QuestionNumber+=1;
			LevelOneImplementation.ShuffledLetters(levelOneTileWords.get(QuestionNumber).getWord());
		}
	}
	public static String getRecentWord() {
		return levelOneTileWords.get(QuestionNumber).getWord();
	}
	public static String getHint() {
		if(hint==3){
			return "HINT EXHAUSTED";
		}
		else{
			hint++;
		}
		
		return levelOneTileWords.get(QuestionNumber).getHint();
	}
}
