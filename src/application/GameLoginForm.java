package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static javafx.scene.text.Font.font;

public class GameLoginForm extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Login Form");
        primaryStage.setWidth(360);
        primaryStage.setHeight(344);
        Pane root = new Pane();
        ImageView iv=new ImageView();
        iv.setImage(image);
        root.getChildren().add(iv);
        Label label = new Label("LOGIN FORM");
        Label User = new Label("USERNAME");
        Label Pass = new Label("PASSWORD");
        TextField Userfield = new TextField();
        PasswordField passfield = new PasswordField();
        Button BtnLogin = new Button("LOGIN");
        Button BtnCancel=new Button("CANCEL");
        Label sign = new Label("New Account? SignUp Here!");
        Userfield.setFont(font(12));
        passfield.setFont(font(12));
        BtnLogin.setFont(font(14));
        BtnCancel.setFont(font(14));
        label.setFont(font(24));
        sign.setFont(font(12));
        User.setFont(font(14));
        Pass.setFont(font(14));
        Userfield.setPrefWidth(240);
        Userfield.setPrefHeight(20);
        passfield.setPrefWidth(240);
        passfield.setPrefHeight(20);
        BtnLogin.setPrefHeight(38);
        BtnLogin.setPrefWidth(91);
        BtnCancel.setPrefHeight(38);
        BtnCancel.setPrefWidth(91);
        label.setPrefHeight(70);
        label.setPrefWidth(190);
        User.setPrefHeight(24);
        User.setPrefWidth(92);
        Pass.setPrefHeight(24);
        Pass.setPrefWidth(92);
        sign.setPrefHeight(24);
        sign.setPrefWidth(172);
        Userfield.setLayoutX(45);
        Userfield.setLayoutY(120);
        passfield.setLayoutX(45);
        passfield.setLayoutY(180);
        BtnLogin.setLayoutX(170);
        BtnLogin.setLayoutY(230);
        BtnCancel.setLayoutX(65);
        BtnCancel.setLayoutY(230);
        label.setLayoutX(90);
        label.setLayoutY(0);
        User.setLayoutX(45);
        User.setLayoutY(100);
        Pass.setLayoutX(45);
        Pass.setLayoutY(160);
        sign.setLayoutX(85);
        sign.setLayoutY(280);
        BtnLogin.setStyle("-fx-background-color:#AA5042;-fx-font-family:Droid Sans; -fx-text-fill:White; -fx-font-weight:bold;");
        label.setStyle("-fx-font-family:Tahoma; -fx-text-fill:White; -fx-font-weight:bold;");
        User.setStyle("-fx-font-family:Tahoma; -fx-text-fill:white; -fx-font-weight:bold");
        Pass.setStyle("-fx-font-family:Tahoma; -fx-text-fill:white; -fx-font-weight:bold");
        sign.setStyle("-fx-font-family:Tahoma; -fx-text-fill:white; -fx-font-weight:bold");
        BtnCancel.setStyle("-fx-background-color:#AA5042;-fx-font-family:Droid Sans; -fx-text-fill:White; -fx-font-weight:bold;");
        root.getChildren().addAll(Userfield,passfield,BtnLogin,BtnCancel,label,User,Pass,sign);
        BtnLogin.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                BtnLogin.setCursor(Cursor.HAND);
            }
        });
        BtnCancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Node node=(Node) actionEvent.getSource();
                Stage stage=(Stage) node.getScene().getWindow();
                stage.close();
            }
        });
        sign.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                sign.setBorder(null);
            }
        });

        sign.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                GameRegisterForm rf = new GameRegisterForm();
                try {
                    rf.start(primaryStage);
                    primaryStage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        BtnLogin.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                PreparedStatement ps;
                ResultSet rs;

                String uname = Userfield.getText();
                String pass = passfield.getText();

                String query = "SELECT * FROM `user` WHERE `uname` =? AND `pass` =?";

                if (Userfield.getText().isEmpty() || passfield.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "FILL IN THE FORM", "WARNING", 2);
                }else{
                    try{
                        ps = MyConnections.getConnection().prepareStatement(query);
                        ps.setString(1, uname);
                        ps.setString(2, pass);
                        rs = ps.executeQuery();
                        if(rs.next()){
                            GameWelcomeInterface WU = new GameWelcomeInterface();
                            try {
                                WU.start(primaryStage);
                                primaryStage.show();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }else {
                            JOptionPane.showMessageDialog(null, "Incorrect Username Or Password", "LOGIN FAILED", 2);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Scene scene=new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    Image image=new Image("application/Images/yakuza.jpg");
    public static void main(String[] args) {
        launch(args);
    }
}
