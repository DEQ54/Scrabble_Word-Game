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
import java.util.logging.Level;

import static javafx.scene.text.Font.font;

public class GameRegisterForm extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Register Form");
        primaryStage.setWidth(430);
        primaryStage.setHeight(479);
        Pane root = new Pane();
        ImageView iv=new ImageView();
        iv.setImage(image);
        root.getChildren().add(iv);
        Label label = new Label("REGISTER");
        Label first = new Label("FIRSTNAME:");
        Label last = new Label("LASTNAME:");
        Label User = new Label("USERNAME:");
        Label Pass = new Label("PASSWORD:");
        Label Retype=new Label("RETYPE PASS:");
        TextField fn = new TextField();
        TextField ln = new TextField();
        PasswordField Retypefield=new PasswordField();
        TextField Userfield = new TextField();
        PasswordField passfield = new PasswordField();
        Button BtnRegister = new Button("SIGNUP");
        Button BtnCancel=new Button("CANCEL");
        Label sign = new Label("HAVE AN ACCOUNT? LOGIN!");
        fn.setFont(font(12));
        ln.setFont(font(12));
        Retypefield.setFont(font(12));
        Userfield.setFont(font(12));
        passfield.setFont(font(12));
        BtnRegister.setFont(font(14));
        BtnCancel.setFont(font(14));
        label.setFont(font(28));
        User.setFont(font(14));
        Pass.setFont(font(14));
        Retype.setFont(font(14));
        first.setFont(font(14));
        last.setFont(font(14));
        fn.setPrefWidth(240);
        fn.setPrefHeight(20);
        ln.setPrefWidth(240);
        ln.setPrefHeight(20);
        Userfield.setPrefWidth(240);
        Userfield.setPrefHeight(20);
        passfield.setPrefWidth(240);
        passfield.setPrefHeight(20);
        Retypefield.setPrefWidth(240);
        Retypefield.setPrefHeight(20);
        BtnRegister.setPrefHeight(38);
        BtnRegister.setPrefWidth(91);
        BtnCancel.setPrefHeight(38);
        BtnCancel.setPrefWidth(91);
        label.setPrefHeight(70);
        label.setPrefWidth(190);
        first.setPrefWidth(92);
        first.setPrefHeight(24);
        last.setPrefWidth(92);
        last.setPrefHeight(24);
        User.setPrefHeight(24);
        User.setPrefWidth(92);
        Pass.setPrefHeight(24);
        Pass.setPrefWidth(92);
        Retype.setPrefHeight(24);
        Retype.setPrefWidth(142);
        sign.setPrefHeight(24);
        sign.setPrefWidth(190);
        fn.setLayoutX(120);
        fn.setLayoutY(130);
        ln.setLayoutX(120);
        ln.setLayoutY(170);
        Userfield.setLayoutX(120);
        Userfield.setLayoutY(210);
        passfield.setLayoutX(120);
        passfield.setLayoutY(250);
        Retypefield.setLayoutX(120);
        Retypefield.setLayoutY(290);
        BtnRegister.setLayoutX(250);
        BtnRegister.setLayoutY(350);
        BtnCancel.setLayoutX(140);
        BtnCancel.setLayoutY(350);
        label.setLayoutX(170);
        label.setLayoutY(10);
        first.setLayoutX(25);
        first.setLayoutY(130);
        last.setLayoutX(25);
        last.setLayoutY(170);
        User.setLayoutX(25);
        User.setLayoutY(210);
        Pass.setLayoutX(25);
        Pass.setLayoutY(250);
        Retype.setLayoutX(15);
        Retype.setLayoutY(290);
        sign.setLayoutX(160);
        sign.setLayoutY(400);
        BtnRegister.setStyle("-fx-background-color:#AA5042;-fx-font-family:Serif; -fx-text-fill:White; -fx-font-weight:bold;");
        label.setStyle("-fx-font-family:Segoe Script; -fx-text-fill:White; -fx-font-weight:bold italic;");
        User.setStyle("-fx-font-family:Tahoma; -fx-text-fill:white; -fx-font-weight:bold");
        Pass.setStyle("-fx-font-family:Tahoma; -fx-text-fill:white; -fx-font-weight:bold");
        first.setStyle("-fx-font-family:Tahoma; -fx-text-fill:white; -fx-font-weight:bold");
        last.setStyle("-fx-font-family:Tahoma; -fx-text-fill:white; -fx-font-weight:bold");
        sign.setStyle("-fx-font-family:Tahoma; -fx-text-fill:white; -fx-font-weight:bold");
        Retype.setStyle("-fx-font-family:Tahoma; -fx-text-fill:white; -fx-font-weight:bold");
        BtnCancel.setStyle("-fx-background-color:#AA5042;-fx-font-family:Serif; -fx-text-fill:White; -fx-font-weight:bold;");
        root.getChildren().addAll( fn,ln,Userfield,passfield,Retypefield,BtnRegister,BtnCancel,label,User,Pass,Retype,first,last,sign);
        BtnRegister.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                BtnRegister.setCursor(Cursor.HAND);
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
        sign.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                GameLoginForm lf = new GameLoginForm();
                try {
                    lf.start(primaryStage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        BtnRegister.setOnAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent actionEvent) {
                                        String fname = fn.getText();
                                        String lname = ln.getText();
                                        String uname = Userfield.getText();
                                        String pass = String.valueOf(passfield.getText());
                                        String re_pass = String.valueOf(Retypefield.getText());
                                        if (uname.equals("")) {
                                            JOptionPane.showMessageDialog(null, "Add A Username");
                                        } else if (pass.equals("")) {
                                            JOptionPane.showMessageDialog(null, "Add A Password");
                                        } else if (!pass.equals(re_pass)) {
                                            JOptionPane.showMessageDialog(null, "Retype The Password Again");
                                        } else if (checkUsername(uname)) {
                                            JOptionPane.showMessageDialog(null, "This Username Already Exist");
                                        } else {
                                            PreparedStatement ps;
                                            String query = "INSERT INTO user(`fname`,`lname`, `uname`, `pass`)VALUES (?,?,?,?)";
                                            try {
                                                ps = MyConnections.getConnection().prepareStatement(query);
                                                ps.setString(1, fname);
                                                ps.setString(2, lname);
                                                ps.setString(3, uname);
                                                ps.setString(4, pass);
                                                if (ps.executeUpdate() > 0) {
                                                    JOptionPane.showMessageDialog(null, "Successfully Registered");
                                                }
                                            } catch (SQLException ex) {
                                                java.util.logging.Logger.getLogger(GameRegisterForm.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                        fn.setText("");
                                        ln.setText("");
                                        passfield.setText("");
                                        Retypefield.setText("");
                                        Userfield.setText("");
                                    }
                                    public boolean checkUsername(String username) {
                                        PreparedStatement ps;
                                        ResultSet rs;
                                        boolean checkUser = false;
                                        String query = "SELECT * FROM `user` WHERE `uname` =?";
                                        try {
                                            ps =
                                                    MyConnections.getConnection().prepareStatement(query);
                                            ps.setString(1, username);
                                            rs = ps.executeQuery();
                                            if (rs.next()) {
                                                checkUser = true;
                                            }
                                        } catch (SQLException ex) {
                                            java.util.logging.Logger.getLogger(GameRegisterForm.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                        return checkUser;
                                    }
            });
        Scene scene=new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    Image image=new Image("application/Images/yakuzas.jpg");
    public static void main(String[] args) {
        launch(args);
    }
}
