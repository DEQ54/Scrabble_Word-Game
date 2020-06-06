package application;

import java.util.ArrayList;

public class LevelTwoProcessAlgorithm {
	public static int QuestionNumber=0;
	static int hint=0;
	public static ArrayList<TileWord> levelTwoTileWords;
	public static void FirstQuestion() {
		HintDataBase.GetSecondLevelQuestions();
		levelTwoTileWords = HintDataBase.SecondLevelQuestions;
		LevelTwoImplementation.ShuffledLetters(levelTwoTileWords.get(0).GetWord().toUpperCase());
	}
	public static void NextQuestion() {
		if(QuestionNumber== levelTwoTileWords.size()-1) {
			GameCompletionInterface note = new GameCompletionInterface();
			note.LevelSuccessful();
		}else {
			QuestionNumber+=1;
			LevelTwoImplementation.ShuffledLetters(levelTwoTileWords.get(QuestionNumber).GetWord().toUpperCase());
		}
	}

	public static String getRecentWord() {
		return levelTwoTileWords.get(QuestionNumber).GetWord();
	}
	public static String getHint()
	{
		if(hint==3){
			return "HINT EXHAUSTED";
		}
		else{
			hint++;
		}
		return levelTwoTileWords.get(QuestionNumber).GetHint().toUpperCase();
	}
	

}
