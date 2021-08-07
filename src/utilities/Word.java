package utilities;

import java.io.Serializable;

public class Word implements Comparable<Word>, Serializable {
	private String word;
	private MyDLL<Location> wordList;

	public Word(String wordStr) {
		this.word = wordStr;
		wordList = new MyDLL<>();
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

	public boolean contains(Location location) {
		return wordList.contains(location);
	}

	public boolean addLocation(Location location) {
		return wordList.add(location);
	}

	@Override
	public int compareTo(Word o) {
		//@todo compare words
		return 0;
	}
}
