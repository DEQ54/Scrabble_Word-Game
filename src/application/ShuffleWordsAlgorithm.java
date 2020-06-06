package application;

import java.util.Date;

public class ShuffleWordsAlgorithm {
	static char[] Letters = {' ',' ',' ',' ',' '};
	public static char[] shuffle(String word) {
   ConvertToCharacter(word);
	Date date=new Date();
	int time=1+date.getSeconds()%3;
	switch(time) {
	case 1:
		FirstAlgorithm(word);
		break;
	case 2:
		SecondAlgorithm(word);
		break;
	case 3:
		ThirdAlgorithm(word);
		break;
		default:
			break;
	}
 return Letters;
	}
	public static char[] ConvertToCharacter(String word) {
		for(int i=0;i<word.length();i++) {
			Letters[i]=word.charAt(i);
		}
		return Letters;
	}
	private static void ThirdAlgorithm(String word) {
		if(word.length()==3) {
			char middle=Letters[1];
			Letters[1]=Letters[2];
			Letters[2]=middle;
		 }else if(word.length()==4) {
			 char middle=Letters[3];
				Letters[3]=Letters[0];
				Letters[0]=middle;
				char Semimiddle=Letters[1];
				Letters[1]=Letters[2];
				Letters[2]=Semimiddle;
		 }else if(word.length()==5) {
			 char middle=Letters[4];
				Letters[4]=Letters[0];
				Letters[0]=middle;
				char Semimiddle=Letters[2];
				Letters[2]=Letters[3];
				Letters[3]=Semimiddle;
		 }
	}
	private static void SecondAlgorithm(String word) {
		if(word.length()==3) {
			char middle=Letters[2];
			Letters[2]=Letters[0];
			Letters[0]=middle;
		 }else if(word.length()==4) {
			 char middle=Letters[3];
				Letters[3]=Letters[0];
				Letters[0]=middle;
				char Semimiddle=Letters[2];
				Letters[2]=Letters[1];
				Letters[1]=Semimiddle;
		 }else if(word.length()==5) {
			 char middle=Letters[4];
				Letters[4]=Letters[0];
				Letters[0]=middle;
				char Semimiddle=Letters[1];
				Letters[1]=Letters[3];
				Letters[3]=Semimiddle;
		 }
	}
	private static void FirstAlgorithm(String word) {
		if(word.length()==3) {
			char middle=Letters[1];
			Letters[1]=Letters[0];
			Letters[0]=middle;
		 }else if(word.length()==4) {
			 char middle=Letters[1];
				Letters[1]=Letters[0];
				Letters[0]=middle;
				char Semimiddle=Letters[2];
				Letters[2]=Letters[3];
				Letters[3]=Semimiddle;
		 }else if(word.length()==5) {
			 char middle=Letters[4];
				Letters[4]=Letters[0];
				Letters[0]=middle;
				char Semimiddle=Letters[1];
				Letters[1]=Letters[2];
				Letters[2]=Semimiddle;
		 }
	}
}

