package application;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import static application.GameComponents.*;


public class GameLevelOne extends Application {
    static HBox top;
    static HBox middle;
    static String  word;
    Button submit=new Button("SUBMIT");
    ObservableList<Node> BUTTON;
    ObservableList<Node> FIELD;
    public static Label hint;
    StackPane DP;
    Scene scene;
    BorderPane root;
    public static int GameLevel;
    public static Stage stage;
    @Override
    public void start(Stage primaryStage) {
        int level=1;
        stage = new Stage();
        GameLevel = level;
        root = new BorderPane();
        ImageView iv = new ImageView();
        iv.setImage(image);
        iv.setX(0);
        iv.setY(210);
        iv.setFitWidth(430);
        iv.setFitHeight(390);
        root.getChildren().add(iv);
        root.setTop(GameComponents.SelectLevel(level));
        LevelSelection(level);
        VBox center = new VBox();
        VBox bottom = new VBox();
        bottom.getStyleClass().add("bottom");
        bottom.getChildren().addAll(top, submit);
        submit.getStyleClass().add("btn");
        DP = new StackPane();
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                switch (level) {
                    case 1:
                        GameOneProcess();
                        break;
                    default:
                        break;
                }
            }
            private void GameOneProcess() {
                word = LevelOneImplementation.GetLettersOnBoxes();
                String answer = LevelOneProcessAlgorithm.getRecentWord();
                if (word.isEmpty()) {
                    EmptyHint();
                } else {
                    if (Compare(word, answer)) {
                        LevelOneImplementation.EmptyFields();
                        LevelOneProcessAlgorithm.NextQuestion();
                        PointsAssignmentAlgorithm.IncreasePoints();
                        EmptyHint();
                    } else {
                        LevelOneProcessAlgorithm.NextQuestion();
                        LevelOneImplementation.EmptyFields();
                        EmptyHint();
                    }
                }
            }
            private void EmptyHint() {
                hint.setText("");
            }
            private boolean Compare(String word, String answer) {
                boolean state = false;
                if (word.equals(answer)) {
                    state = true;
                }
                return state;
            }
        });
        hint = new Label();
        hint.getStyleClass().add("hint");
        DP = GameComponents.GameBoard();
        center.getChildren().addAll(DP, hint, middle);
        root.setCenter(center);
        root.setBottom(bottom);
        scene = new Scene(root, 410, 600);
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent arg0) {
                stage.close();
                GameWelcomeInterface page = new GameWelcomeInterface();
                try {
                    page.start(primaryStage);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        Hint.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(GameLevelOne.hint.getText()=="") {
                    GameLevelOne.hint.setText(LevelOneProcessAlgorithm.getHint().toUpperCase());
                }else {
                    GameLevelOne.hint.setText("");
                }
            }
        });
        Home.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                GameWelcomeInterface db = new GameWelcomeInterface();
                try {
                    db.start(primaryStage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                stage.close();
            }
        });
        scene.getStylesheets().add(getClass().getResource("GameDesign.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
        private void LevelSelection(int i) {
            switch(i) {
                case 1:
                    top = GameComponents.Tiles(1);
                    BUTTON =(ObservableList<Node>) top.getChildren();
                    middle = GameComponents.AnswerTiles(1);
                    FIELD =(ObservableList<Node>) middle.getChildren();
                    LevelOneImplementation.GetLevelOneBoxes(BUTTON, FIELD);
                    LevelOneProcessAlgorithm.FirstQuestion();
                    break;
                default:
                    break;
            }
        }
    Image image=new Image("application/Images/backs.jpg");
    public static void main(String[] args) {
        launch(args);
    }
}
