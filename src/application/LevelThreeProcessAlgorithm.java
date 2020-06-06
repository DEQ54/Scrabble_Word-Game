package application;

import java.util.ArrayList;

public class LevelThreeProcessAlgorithm {
	public static int QuestionNumber=0;
	static int hint=0;
	public static ArrayList<TileWord> levelThreeTileWords;
	public static void FirstQuestion() {
		HintDataBase.GetThirdLevelQuestions();
		levelThreeTileWords = HintDataBase.ThirdLevelQuestions;
		LevelThreeImplementation.ShuffledLetters(levelThreeTileWords.get(0).GetWord());
	}
	public static void NextQuestion() {
		if(QuestionNumber== levelThreeTileWords.size()-1) {
			GameCompletionInterface note = new GameCompletionInterface();
			note.LevelSuccessful();
		}else {
			QuestionNumber+=1;
			LevelThreeImplementation.ShuffledLetters(levelThreeTileWords.get(QuestionNumber).GetWord());
		}
	}

	public static String getRecentWord() {
		return levelThreeTileWords.get(QuestionNumber).GetWord();
	}
	public static String getHint()
	{
		if(hint==3){
			return "HINT EXHAUSTED";
		}
		else{
			hint++;
		}
		return levelThreeTileWords.get(QuestionNumber).GetHint().toUpperCase();
	}
	
	

}
