package utilities;

import java.io.Serializable;

/** Word Class which stores the string data and location of words read from a given file
 * 
 * @author Don Laliberte
 * @author Elie Kabengele
 * @author Jared Smith
 * @author Jaekyung Jeon
 * @version August 9th 2021
 *
 */
public class Word implements Comparable<Word>, Serializable {
    private String word;
    private MyDLL<Location> wordList;

    /**
     * Constructor for Word Object used to instansiate word objects without a location
     * @param wordStr string to set
     */
    public Word(String wordStr) {
        this.word = wordStr;
        wordList = new MyDLL<>();
    }

    public Word(String word, MyDLL<Location> wordList) {
        this.word = word;
        this.wordList = wordList;
    }

    /**
     * Returns the String data of a word object
     * @return String to return
     */
    public String getWord() {
        return word;
    }

    /**
     * Sets the String data of a word object
     * @param word string to set 
     */
    public void setWord(String word) {
        this.word = word;
    }

    /**
     * Gets the list of locations a word can be found
     * @return location list to return
     */
    public MyDLL<Location> getWordList() {
        return wordList;
    }

    /**
     * sets the list of locations a word can be found
     * @param wordList location list to set 
     */
    public void setWordList(MyDLL<Location> wordList) {
        this.wordList = wordList;
    }

    /**
     * Check if the location for a word string has already been logged
     * @param location location to look for
     */
    public boolean contains(Location location) {
        return wordList.contains(location);
    }

    /**
     * Adds a new location to the current list of locations
     * @param location locatation to add
     * @return the updated list of locations
     */
    public boolean addLocation(Location location) {
        return wordList.add(location);
    }

    /**
     * Overrides compareTo object and comapres two word objects by their string values 
     * @param o word to compare to
     * @return returns any of -1, 1, or 0 depending on if both objects are greater, less or equal
     */
    @Override
    public int compareTo(Word o) {
        if (word.compareTo(o.getWord()) < 0) {
            return -1;
        } else if (word.compareTo(o.getWord()) > 0) {
            return 1;
        } else return 0;
    }

    /**
     * Compares two word strings to see if theyre equal to each other
     * @param o the word to compare to 
     * @return returns true if two strings are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        return word.compareTo(((Word) o).getWord()) == 0 ? true : false;
    }
}
