package application;

public class TileWord {
 private String word;
 private String hint;
 private int level;
 private int id;
 
public TileWord(String word, String hint, int level, int id) {
	super();
	this.word = word;
	this.hint = hint;
	this.level = level;
	this.id = id;
}
public String getWord() {
	return word;
}
	public String getHint() {
	return hint;
}
}
