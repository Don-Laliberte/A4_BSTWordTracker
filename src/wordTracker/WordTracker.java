package wordTracker;

import adts.Iterator;
import exceptions.TreeException;
import utilities.BSTReferencedBased;
import utilities.Location;
import utilities.Word;

import java.io.*;
import java.util.StringTokenizer;

public class WordTracker {
    private final String REPO = "./res/repository.ser";
    private String filename;
    private char option;
    private String output;
    private BSTReferencedBased<Word> bst = new BSTReferencedBased<>();
    private String report;

    public WordTracker(String filename, char option, String output) {
        this.filename = filename;
        this.option = option;
        this.output = output;

        readRepository();
        readFile();
        saveRepository();

        report = makeReport();
        System.out.println(report);

        if (output != null) {
            saveOutput();
        }
    }

    private void readRepository() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(REPO)))) {
            System.out.println("System: Found a repository. Loading that one.");
            bst = (BSTReferencedBased<Word>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("System: No existing repository. Creating new one.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void readFile() {
        String line;
        int lineNumber = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("./res/" + filename))) {
            while ((line = br.readLine()) != null) {
                lineNumber++;
                StringTokenizer st = new StringTokenizer(line);
                while (st.hasMoreTokens()) {
                    String wordStr = st.nextToken();
                    Word word = new Word(wordStr);
                    Location location = new Location(filename, lineNumber);

                    if (bst.contains(word)) {
                        word = bst.getEntry(word);

                        if (!word.contains(location)) {
                            word.addLocation(location);
                        }
                    } else {
                        word.addLocation(location);
                        bst.add(word);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TreeException e) {
            e.printStackTrace();
        }
    }

    private void saveRepository() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(REPO)))) {
            System.out.println("System: Saved the tree to a repository file.");
            oos.writeObject(bst);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String makeReport() {
        StringBuilder sb = new StringBuilder();
        Iterator inorder = bst.inorderIterator();

        switch (option) {
            case 'f':
                // @todo print in alphabetic order all words along with the corresponding list of files in which the words occur
                while(inorder.hasNext()) {
                    Word word = (Word) inorder.next();
                    sb.append( word.getWord() + " : " + System.lineSeparator());
                }

                break;
            case 'l':
                // @todo print in alphabetic order all words along with the corresponding list of files and numbers
                // of the lines in which the word occur
                break;
            case 'o':
                // @todo print in alphabetic order all words along with the corresponding list of files, numbers of
                // the lines in which the word occur and the frequency of occurrence of the words.
                break;
            default:
                System.out.println("ERROR: This should not be called.");
                break;
        }

        return sb.toString();
    }

    private void saveOutput() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(output))) {
            bw.write(report);
            System.out.println("System: A report has been created as " + output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}