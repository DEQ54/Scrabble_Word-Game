package application;



import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class GameComponents {
	static StackPane pane;
	static Label level ;
	static DropShadow shadow;
	static StackPane DashBoard;
	static HBox DashRegion;
	static StackPane PointArea;
	static StackPane Shuffle;
	static BorderPane UserInfo;
	static VBox ScoreRegion;
	static Label Scores;
	public static Label AssignedScorePoints;
	static Label Name;
	static Button Home;
	static Button Hint;
	public static StackPane SelectLevel(int number) {
		switch(number) {
		case 1:
			 level =new Label("LEVEL 1");
			 break;
		case 2:
			 level =new Label("LEVEL 2");
			 break;
		case 3:
			 level =new Label("LEVEL 3");
			 break;
			 default:
				 break;
			
		}
		 pane =new StackPane();
		pane.getStyleClass().add("main");
		level.getStyleClass().add("LevelDesign");
		pane.getChildren().add(level);
		return pane;
		
	}
	public static HBox AnswerTiles(int levelNumber) {
		HBox box=new HBox();
		switch (levelNumber) {
		case 1:
			box= LevelOneAnswerBox();
			break;
		case 2:
			box= LevelTwoAnswerBox();
			break;
		case 3:
			box= LevelThreeAnswerBox();
			break;
			default:
				break;
		}
		return box;
		
	}
	private static HBox LevelThreeAnswerBox() {
		TextField field1=new TextField();
		TextField field2=new TextField();
		TextField field3=new TextField();
		TextField field4=new TextField();
		TextField field5=new TextField();
		field1.getStyleClass().add("MasterLevelAnswer");
		field2.getStyleClass().add("MasterLevelAnswer");
		field3.getStyleClass().add("MasterLevelAnswer");
		field4.getStyleClass().add("MasterLevelAnswer");
		field5.getStyleClass().add("MasterLevelAnswer");
		HBox box=new HBox();
		box.getStyleClass().add("AnswerRegion");
		box.setEffect(shadow);
		box.getChildren().addAll(field1,field2,field3,field4,field5);
		return box;
	}
	private static HBox LevelTwoAnswerBox() {
		TextField field1=new TextField();
		TextField field2=new TextField();
		TextField field3=new TextField();
		TextField field4=new TextField();
		field1.getStyleClass().add("IntermediateLevelAnswer");
		field2.getStyleClass().add("IntermediateLevelAnswer");
		field3.getStyleClass().add("IntermediateLevelAnswer");
		field4.getStyleClass().add("IntermediateLevelAnswer");
		HBox box=new HBox();
		box.getStyleClass().add("AnswerRegion");
		box.setEffect(shadow);
		box.getChildren().addAll(field1,field2,field3,field4);
		return box;
	}
	private static HBox LevelOneAnswerBox() {
		TextField field1=new TextField();
		TextField field2=new TextField();
		TextField field3=new TextField();
		field1.getStyleClass().add("BeginnerLevelAnswer");
		field2.getStyleClass().add("BeginnerLevelAnswer");
		field3.getStyleClass().add("BeginnerLevelAnswer");
		HBox box=new HBox();
		box.getStyleClass().add("AnswerRegion");
		box.setEffect(shadow);
		box.getChildren().addAll(field1,field2,field3);
		return box;
	}
	public static HBox Tiles(int levelNumber) {
		HBox box=new HBox();
		switch (levelNumber) {
		case 1:
			box= FirstLevelBoxes();
			break;
		case 2:
			box= SecondLevelBoxes();
			break;
		case 3:
			box= ThirdLevelBoxes();
			break;
			default:
				break;
		}
		return box;
		
	}
	private static HBox ThirdLevelBoxes() {
		Button button1=new Button("A");
		Button button2=new Button("B");
		Button button3=new Button("C");
		Button button4=new Button("D");
		Button button5=new Button("E");
		button1.getStyleClass().add("ThirdLevelBox");
		button2.getStyleClass().add("ThirdLevelBox");
		button3.getStyleClass().add("ThirdLevelBox");
		button4.getStyleClass().add("ThirdLevelBox");
		button5.getStyleClass().add("ThirdLevelBox");
		HBox levelThreeBoxes = new HBox();
		levelThreeBoxes.getStyleClass().add("ThirdBox");
		levelThreeBoxes.setEffect(shadow);
		levelThreeBoxes.getChildren().addAll(button1,button2,button3,button4,button5);
		return levelThreeBoxes;
	}
	private static HBox SecondLevelBoxes() {
		Button button1=new Button("A");
		Button button2=new Button("B");
		Button button3=new Button("C");
		Button button4=new Button("D");
		button1.getStyleClass().add("SecondLevelBox");
		button2.getStyleClass().add("SecondLevelBox");
		button3.getStyleClass().add("SecondLevelBox");
		button4.getStyleClass().add("SecondLevelBox");
		HBox levelTwoBoxes = new HBox();
		levelTwoBoxes.getStyleClass().add("SecondBox");
		levelTwoBoxes.setEffect(shadow);
		levelTwoBoxes.getChildren().addAll(button1,button2,button3,button4);
		return levelTwoBoxes;
	}
	private static HBox FirstLevelBoxes() {
		Button button1=new Button("A");
		Button button2=new Button("B");
		Button button3=new Button("C");
		button1.getStyleClass().add("FirstLevelBox");
		button2.getStyleClass().add("FirstLevelBox");
		button3.getStyleClass().add("FirstLevelBox");
		HBox levelOneBoxes = new HBox();
		levelOneBoxes.getStyleClass().add("FirstBox");
		levelOneBoxes.setEffect(shadow);
		levelOneBoxes.getChildren().addAll(button1,button2,button3);
		return levelOneBoxes;
	}
	
public static StackPane GameBoard() {
	 DashBoard =new StackPane();
	 ScoreRegion =new VBox();
	 ScoreRegion.getStyleClass().add("ScoreRegion");
	 Scores =new Label("YOUR POINTS");
	 AssignedScorePoints =new Label("00");
	 Scores.getStyleClass().add("DisplayedScore");
	 AssignedScorePoints.getStyleClass().add("AssignedScorePoint");
	 Hint =new Button("HINT");
	 Hint.getStyleClass().add("HintRegion");
	ScoreRegion.getChildren().addAll(Scores, AssignedScorePoints, Hint);
	 DashRegion =new HBox();
	 PointArea =new StackPane();
	 PointArea.getChildren().add(ScoreRegion);
	 Shuffle =new StackPane();
	 UserInfo =new BorderPane();
	 Home =new Button("HOME");
	 Name =new Label();
	 UserInfo.setTop(Name);
	 UserInfo.setBottom(Home);
	 DashBoard.getChildren().add(DashRegion);
	 DashRegion.getChildren().addAll(PointArea, UserInfo);
	DashBoard.getStyleClass().add("DashBoard");
	DashRegion.getStyleClass().add("DashRegion");
	PointArea.getStyleClass().add("PointArea");
	UserInfo.getStyleClass().add("UserInfo");
	Home.getStyleClass().add("HintRegion");
	return DashBoard;
	
}
}
