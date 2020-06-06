package application;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HintDataBase {
	static Connection connection= MyConnections.getConnection();
	static ArrayList<TileWord> FirstLevelQuestions;
	static ArrayList<TileWord> SecondLevelQuestions;
	static ArrayList<TileWord> ThirdLevelQuestions;
	public static void GetFirstLevelQuestions() {
		FirstLevelQuestions =new ArrayList<>();
		 try {
			 String query = "SELECT * FROM WORD WHERE level=1";
			Statement st = connection.createStatement();
			ResultSet results=st.executeQuery(query);
			while(results.next()) {
				FirstLevelQuestions.add(new TileWord(results.getString("word"),results.getString("hint"),results.getInt("level"),
						results.getInt("word_id")));
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void GetSecondLevelQuestions() {
		SecondLevelQuestions =new ArrayList<>();
		 try {
			 String query = "SELECT * FROM WORD WHERE level=2";
			Statement st = connection.createStatement();
			ResultSet results=st.executeQuery(query);
			while(results.next()) {
				SecondLevelQuestions.add(new TileWord(results.getString("word"),results.getString("hint"),results.getInt("level"),
						results.getInt("word_id")));
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void GetThirdLevelQuestions() {
		ThirdLevelQuestions =new ArrayList<>();
		 try {
			 String query = "SELECT * FROM WORD WHERE level=3";
			Statement st = connection.createStatement();
			ResultSet results=st.executeQuery(query);
			while(results.next()) {
				ThirdLevelQuestions.add(new TileWord(results.getString("word"),results.getString("hint"),results.getInt("level"),
						results.getInt("word_id")));
			}
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
