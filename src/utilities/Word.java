package utilities;

public class Word {
	private String word;
	private MyDLL<Location> wordList;
	
	public Word() {

	}
	
	public Word(String word, MyDLL<Location> wordList) {
		this.word = word;
		this.wordList = wordList;
	}
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public MyDLL<Location> getWordList() {
		return wordList;
	}
	public void setWordList(MyDLL<Location> wordList) {
		this.wordList = wordList;
	}
}
