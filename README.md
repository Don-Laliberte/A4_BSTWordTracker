# README

Authors:
 - Don Laliberte
 - Elie Kabengele
 - Jared Smith
 - Jaekyung Jeon

Date: August 9th 2021


How To Execute Program
----------------------

1.) Extract the zip folder, and find the JAR file. Take note of the directory JAR file
is located in.

2.) Insert all text documents you wish to run with wordTracker with in the /res folder (textfile.txt etc)

3.) Open PowerShell (or stay within File Explorer)

4.) Type in the absolute path where the JAR file is located. (If within File Explorer, 
press Shift + Right Mouse Click and pick "Open PowerShell Window here"). You should 
now be where the file is currently located

5.) Type this command in the command line interface while providing 3 arguments to dictate:
- What file you want to use wordTracker on
- What output file you wish to store the report (notated by -f prefix)
- Any of -pf -po or -pl to indicate what you want the report to include
        -pf - to print in alphanumeric order each word with the file it was found in beside
        -pl - to print in alphanumeric order each word with the file it was found in beside AND number of lines where the word occurs
        -po - to print in alphanumeric order each word with the file it was found in beside AND both number and frequency where each word occurs 

The command you type in should look something like this: java -jar sort.jar "textfile.txt" "-foutput.txt" -pl

WARNING: 
- Filename notated by a "-f" prefix MUST be surrounded by quotes in order for it to work correctly from command line. It should look something like this "-foutput.txt"
- The second step where you copy the shape txt files into /res MUST be done before all subsequent steps



How To Run the Associated Tests
----------------------
- Running the JUnit Tests in Eclipse

1.) Extract the zip folder

2.) In your IDE click on the File tab, then click import. The Import wizard should 
now be visible to you.

3.) Go to General > Existing Projects into Workspace. 

4.) Select root directory, then click on browse and find the location of the extracted folder. 
Click finish. The contents of the program should now show up in your package explorer. 

5.) Run the BSTReferencedBasedTests.java Testing Suite

