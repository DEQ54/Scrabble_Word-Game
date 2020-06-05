package application;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;

public class LevelTwoImplementation {
	static Button Button1;
	static Button Button2;
	static Button Button3;
	static Button Button4;
	static TextField TextField1 =new TextField();
	static TextField TextField2 =new TextField();
	static TextField TextField3 =new TextField();
	static TextField TextField4 =new TextField();
	public static void GetLevelTwoBoxes(ObservableList<Node> buttons, ObservableList<Node> fields) {
		TextField1 =(TextField) fields.get(0);
		TextField2 =(TextField) fields.get(1);
		TextField3 =(TextField) fields.get(2);
		TextField4 =(TextField) fields.get(3);
		Button1 =(Button) buttons.get(0);
		Button2 =(Button) buttons.get(1);
		Button3 =(Button) buttons.get(2);
		Button4 =(Button) buttons.get(3);

		Button1.setOnDragDetected(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Button1.startFullDrag();

			}
			
		});
		
		TextField1.setOnMouseDragReleased(new EventHandler<MouseDragEvent>() {

			@Override
			public void handle(MouseDragEvent event) {
				Button value=(Button) event.getGestureSource();
				TextField1.setText(value.getText());

			}
			
		});
		
		
		Button2.setOnDragDetected(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Button2.startFullDrag();

			}
			
		});
		
		TextField2.setOnMouseDragReleased(new EventHandler<MouseDragEvent>() {

			@Override
			public void handle(MouseDragEvent event) {
				Button value=(Button) event.getGestureSource();
				TextField2.setText(value.getText());

			}
			
		});
		
		
		Button3.setOnDragDetected(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Button3.startFullDrag();

			}
			
		});
		
		TextField3.setOnMouseDragReleased(new EventHandler<MouseDragEvent>() {

			@Override
			public void handle(MouseDragEvent event) {
				Button value=(Button) event.getGestureSource();
				TextField3.setText(value.getText());

			}
			
		});
		Button4.setOnDragDetected(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				Button4.startFullDrag();

				
			}
			
		});
		
		TextField4.setOnMouseDragReleased(new EventHandler<MouseDragEvent>() {

			@Override
			public void handle(MouseDragEvent event) {
				Button value=(Button) event.getGestureSource();
				TextField4.setText(value.getText());

			}
			
		});
		
	}
	
	public static void ShuffledLetters(String word) {
		char[] letters= ShuffleWordsAlgorithm.shuffle(word);
		String one=""+letters[0];
		Button1.setText(one);
		String two=""+letters[1];
		Button2.setText(two);
		String three=""+letters[2];
		Button3.setText(three);
		String four=""+letters[3];
		Button4.setText(four);
	}
		public static String GetLettersOnBoxes() {
			String word= TextField1.getText()+ TextField2.getText()+ TextField3.getText()+ TextField4.getText();
			return word;
		}
		public static void EmptyFields() {
			TextField1.setText("");
			TextField2.setText("");
			TextField3.setText("");
			TextField4.setText("");
		}
	

}
