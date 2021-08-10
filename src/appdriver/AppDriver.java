package appdriver;

import wordTracker.WordTracker;

/**
 * Runner Class for our application. Decodes given arguments and begins the word tracker
 * 
 * @author Don Laliberte
 * @author Elie Kabengele
 * @author Jared Smith
 * @author Jaekyung Jeon
 * @version August 9th 2021
 *
 */
public class AppDriver {
    
    public static void main(String[] args) {
        parseArgs(args);
    }

    /**
     * Decodes Provided Command Line Arguments and gives helpful feedback for errors
     * If no errors occur it instansiates a new WordTracker and continues from there
     * @param args command line arugmnents
     */
    private static void parseArgs(String[] args) {
        String filename = null;
        String output = null;
        char option = 'a';

        if (args == null) {
            System.out.println("Please enter a filename");
            properUsage();
            return;
        } else if (args.length > 3) {
            System.out.println("ERROR: Invalid parameters!");
            properUsage();
            return;
        }

        for (String command : args) {
            if (command.charAt(0) == '-' && command.charAt(1) == 'p') {
                switch (command.charAt(2)) {
                    case 'f':
                    case 'l':
                    case 'o':
                        option = command.charAt(2);
                        break;
                    default:
                        System.out.println("ERROR: Invalid -p option! - You should give one of -pf / -po / -pl");
                        properUsage();
                        return;
                }
            } else if (command.charAt(0) == '-' && command.charAt(1) == 'f') {
                output = command.substring(2);
            } else {
                filename = command;
            }
        }

        if (filename == null) {
            System.out.println("ERROR: Specify filename to read in the first parameter.");
            properUsage();
            return;
        } else if (option == 'a') {
            System.out.println("ERROR: No -p option: You should give one of -pf / -po / -pl");
            properUsage();
            return;
        } else {
            new WordTracker(filename, option, output);
        }
    }

    private static void properUsage() {
        System.out.println("ex) BSTreeADT textfile.txt -pf -foutput.txt");
    }
}
