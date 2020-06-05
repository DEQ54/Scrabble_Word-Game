package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MyConnections {
private static Connection connection;
private static String user;
private static String  password;
private static String SCRAMBLE="SCRAMBLE";
	
public MyConnections(String username, String pword) {
	user=username;
	password=pword;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	 connection=DriverManager.getConnection("jdbc:mysql://localhost/?useTimezone=true&serverTimezone=UTC",user,password);
	}catch(Exception e) {
		e.printStackTrace();
	}
	CreateDataBase();
	CreateUserTable();
	CreateWordTable();
	InsertWords();
}

private void InsertWords() {
	connection=getConnection();
	Statement statement;
	try {
		statement = connection.createStatement();
		String sql="INSERT INTO word (word,hint ,level)"
				+ "VALUES('ABUSE','TO USE IMPROPERLY OR EXCESSIVELY',3),('ASSET','A USEFUL OR VALUABLE QUALITY,PERSON OR THING',3),"
				+ "('CRASH','TO BREAK VIOLENTLY OR DESTRUCTION ON IMPACT',3),"
				+ "('GREEN','PORTION OF THE VISIBLE SPECTRUM LYING BETWEEN YELLOW AND BLUE',3),"
				+ "('MEDIA','MEANS OF COMMUNICATION THAT REACH LARGE NUMBERS OF PEOPLE',3),"
				+ "('BANK','A BUSINESS ESTABLISHMENT IN WHICH MONEY IS KEPT',2),"
				+ "('DARK','LACKING OR HAVING VERY LITTLE LIGHT',2),"
				+ "('DOOR','SLIDING PANEL FOR CLOSING THE ENTRANCE TO A ROOM',2),"
				+ "('FILM','A LONG NARRATIVE MOVIE',2),"
				+ "('FUND','A SUM OF MONEY SET ASIDE FOR A SPECIFIC PURPOSE',2),"
				+ "('AIL','TO BE INDISPOSED',1),"
				+ "('NET','TO CATCH FISH IN A MESH DEVICE',1),"
				+ "('PEN','TO WRITE DOWN ON PAPER',1),"
				+ "('EWE','A FEMALE SHEEP',1),"
				+ "('GUN','TO DISCHARGE BULLETS',1)";
		statement.execute(sql);	
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

private void CreateWordTable() {
	connection=getConnection();
	Statement statement;
	try {
		statement = connection.createStatement();
		String sql="CREATE TABLE WORD("
				+ "word varchar(20),"
				+ "hint varchar(200),"
				+ "level int,"
				+ "word_id int PRIMARY KEY AUTO_INCREMENT)";
		statement.execute(sql);	
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

private void CreateUserTable() {
	connection=getConnection();
	Statement statement;
	try {
		statement = connection.createStatement();
		String sql="CREATE TABLE USER("
				+ "fname varchar(20),"
				+ "lname varchar(20),"
				+ "uname varchar(20),"
				+ "pass varchar(20),"
				+ "current_level int,"
				+ "user_id int PRIMARY KEY AUTO_INCREMENT)";
		statement.execute(sql);	
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

private void CreateDataBase() {
	Statement statement;
	try {
		statement = connection.createStatement();
		String sql="CREATE DATABASE SCRAMBLE";
		statement.execute(sql);	
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
public static Connection getConnection() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	 connection=DriverManager.getConnection("jdbc:mysql://localhost/"+SCRAMBLE+"?useTimezone=true&serverTimezone=UTC","root","");
	}catch(Exception e) {
		e.printStackTrace();
	}
	return connection;
}
}


