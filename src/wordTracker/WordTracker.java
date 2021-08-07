package wordTracker;

import utilities.BSTReferencedBased;
import utilities.Word;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.lang.*;

public class WordTracker {
    private String filename;
    private char option;
    private String output;
    private BSTReferencedBased<Word> bst = new BSTReferencedBased<>();

    public WordTracker(String filename, char option, String output) {
        this.filename = "./res/" + filename;
        this.option = option;
        this.output = output;

        //readFile();
    }

    private void readFile() {
        String line;
        int lineNumber = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            while ((line = br.readLine()) != null) {
                lineNumber++;
                StringTokenizer st = new StringTokenizer(line);
                while (st.hasMoreTokens()) {
                    String word = st.nextToken();

                }
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}