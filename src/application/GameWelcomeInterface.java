package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.swing.*;


public class GameWelcomeInterface extends Application {
ComboBox<String>comboBox;
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("");
        primaryStage.setWidth(410);
        primaryStage.setHeight(550);
        Pane root = new Pane();
        comboBox = new ComboBox<>();
        comboBox.getItems().addAll(
                "LEVEL 1","LEVEL 2","LEVEL 3");
        comboBox.setPromptText("SELECT LEVEL");
        comboBox.setValue("SELECT LEVEL");
        comboBox.setPrefWidth(160);
        comboBox.setPrefHeight(40);
        comboBox.setLayoutX(225);
        comboBox.setLayoutY(300);
        Label welcomeLabel=new Label();
        welcomeLabel.setFont(Font.font(24));
        welcomeLabel.setPrefWidth(200);
        welcomeLabel.setPrefHeight(100);
        welcomeLabel.setAlignment(Pos.CENTER);
        welcomeLabel.setLayoutX(70);
        welcomeLabel.setLayoutY(110);
        Button play=new Button("PLAY");
        ImageView iv=new ImageView();
        iv.setImage(image);
        root.getChildren().add(iv);
        ImageView v=new ImageView();
        v.setImage(images);
        root.getChildren().add(v);
        v.setFitWidth(410);
        v.setFitHeight(200);
        Label level=new Label("CHOOSE YOUR DESTINY:");
        play.setFont(Font.font(14));
        level.setFont(Font.font(16));
        play.setPrefWidth(101);
        play.setPrefHeight(38);
        level.setPrefWidth(220);
        level.setPrefHeight(40);
        play.setLayoutX(150);
        play.setLayoutY(410);
        level.setLayoutX(10);
        level.setLayoutY(300);
       play.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent actionEvent) {
               if (comboBox.getValue()=="SELECT LEVEL"){
                   JOptionPane.showMessageDialog(null, "SELECT ANY LEVEL OF YOUR CHOICE", "Choose your Level", 2);
               }
               else if(comboBox.getValue()=="LEVEL 1"){
                GameLevelOne mm=new GameLevelOne();
                try {
                    mm.start(primaryStage);
                    primaryStage.show();
                }catch (Exception e){

                    e.printStackTrace();
                }

               }
               else if(comboBox.getValue()=="LEVEL 2"){
                   GameLevelTwo nn=new GameLevelTwo();
                   try {
                       nn.start(primaryStage);
                       primaryStage.show();
                   }catch (Exception e){

                       e.printStackTrace();
                   }
               }
               else if(comboBox.getValue()=="LEVEL 3"){
                   GameLevelThree ma=new GameLevelThree();
                   try {
                       ma.start(primaryStage);
                       primaryStage.show();
                   }catch (Exception e){

                       e.printStackTrace();
                   }
               }
               primaryStage.close();
           }
       });
        play.setStyle("-fx-background-color:#5a4cb0;-fx-font-family:Serif; -fx-text-fill:White; -fx-font-weight:bold;");
        comboBox.setStyle("-fx-font-family:Tahoma; -fx-text-fill:white; -fx-font-weight:bold");
        level.setStyle("-fx-font-family:Tahoma; -fx-text-fill:white; -fx-font-weight:bold");
        welcomeLabel.setStyle("-fx-font-family:Tahoma; -fx-text-fill:black; -fx-font-weight:bold");
        root.getChildren().addAll( play,level,comboBox,welcomeLabel);
        Scene scene=new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

      Image image=new Image("application/Images/backs.jpg");
    Image images=new Image("application/Images/images.png");
        public static void main(String[] args) {
            launch(args);
        }

    }