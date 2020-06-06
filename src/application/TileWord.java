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
public String GetWord() {
	return word;
}
	public String GetHint() {
	return hint;
}
}
