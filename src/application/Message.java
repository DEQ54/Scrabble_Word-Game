package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;

public class Message {
	public void LevelSuccessful() {
		Stage stage = new Stage();
		VBox vbox = new VBox();
		Button btn = new Button("CLICK HERE");
		vbox.getStyleClass().add("BOX");
		vbox.setAlignment(Pos.TOP_CENTER);
		btn.setPadding(new Insets(20,40,-40,25));
		vbox.setSpacing(10);
		btn.setStyle("-fx-font-family:Open Sans; -fx-text-fill:#334596; -fx-font-weight:bold;-fx-font-size:15px;");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				stage.close();
				switch(GameLevelOne.GameLevel) {
					case 1:
						GameLevelOne.stage.close();
						GameWelcomeInterface db = new GameWelcomeInterface();
						try {
							db.start(stage);
						} catch (Exception e) {
							e.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "CHOOSE NEXT LEVEL TO CONTINUE", "LEVEL COMPLETED", 1);
					default:
						break;
				}
				switch(GameLevelTwo.GameLevel) {
					case 2:
						GameLevelTwo.stage.close();
						GameWelcomeInterface Db = new GameWelcomeInterface();
						try {
							Db.start(stage);
						} catch (Exception e) {
							e.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "CHOOSE NEXT LEVEL TO CONTINUE", "LEVEL COMPLETED", 2);
					default:
						break;
				}

				switch(GameLevelThree.GameLevel) {
					case 3:
						GameLevelThree.stage.close();
						GameWelcomeInterface DB = new GameWelcomeInterface();
						try {
							DB.start(stage);
						} catch (Exception e) {
							e.printStackTrace();
						}
						JOptionPane.showMessageDialog(null, "GAME COMPLETED", "YOU ARE A GENUIS", 3);
					default:
						break;
				}
			}
		});
		stage.initModality(Modality.APPLICATION_MODAL);
		StackPane pane=new StackPane();
		Label label =new Label("LEVEL COMPLETED!");
		label.setFont(Font.font(18));
		label.setAlignment(Pos.TOP_CENTER);
		label.setStyle("-fx-font-family:Open Sans; -fx-text-fill:#334596; -fx-font-weight:bold;-fx-font-size:18px;");
		label.setPadding(new Insets(10,30,30,30));
		vbox.getChildren().addAll(label,btn);
		pane.getChildren().add(vbox);
		Scene scene =new Scene(pane,300,200);
		scene.getStylesheets().add(getClass().getResource("GameDesign.css").toExternalForm());
		stage.setScene(scene);
		stage.setTitle("CONGRATULATIONS");
		stage.showAndWait();
		return;
	}
}
