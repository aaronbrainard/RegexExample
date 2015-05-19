package com.aaronbrainard.regexexample;

import java.io.*;
import java.util.Scanner;
import java.util.regex.*;

/**
 * Created by aaronbrainard on 5/14/2015.
 */
public class RegularExpression {

    Scanner fileIn;
    PrintWriter writer;
    File outputFile;

    /**
     * Changes whitespace between words to commas and writes to a csv file.
     *
     * @param file reference to a file object
     */
    public void changeToCsv(File file) {

        String curLine;


        try {
            fileIn = new Scanner(file);

            prepareOutputFile("processedData.csv");
            //replace all whitespace with commas
            while (fileIn.hasNextLine()) {
                writer.println(fileIn.nextLine().replaceAll("\\b\\s+\\b", ","));
            }


        } catch (IOException e) {
            System.out.println("ERROR: File not found.");
            e.printStackTrace();
        } finally {
            //release resources
            fileIn.close();
            writer.close();
        }

        System.out.println("Finished processing into CSV");


    }

    public void extractNamesWithPhoneNumbers(File file) {


        try {
            fileIn = new Scanner(file);

            prepareOutputFile("nameswithphonenumbers.txt");

            //this regex finds names with phone numbers on the same line and write them to output file
            String regex = "(\\S+\\s+\\S+\\s+\\(?\\d{3}\\)?\\-?\\d{3}\\-?\\d{4})";
            Pattern p = Pattern.compile(regex);
            String curLine;

            while (fileIn.hasNextLine()) {
                curLine = fileIn.nextLine();
                Matcher m = p.matcher(curLine);
                //print matching results to output file
                while (m.find()) {
                    writer.println(m.group(0));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //release resources
            fileIn.close();
            writer.close();
        }

        System.out.println("Extracted contacts with phone numbers.");
    }

    public void findWordAtLeastThreeVowels(File file) {

        try {
            fileIn = new Scanner(file);
            prepareOutputFile("wordsatleastthreevowels.txt");

            String regex = "\\[a-zA-z]+\\s+";
            Pattern p = Pattern.compile(regex);
            String curWord;

            while (fileIn.hasNextLine()) {
                curWord = fileIn.nextLine();
                Matcher m = p.matcher(curWord);
                while (m.find()) {
                    writer.println(m.group(0));
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileIn.close();
            writer.close();
        }

        System.out.println("Finished processing words with at least 3 vowels.");
    }

    /**
     * Instantiates File object for output file, and PrintWriter to write to said file.
     *
     * @param fileName the desired name of the output file.
     * @throws IOException
     */
    public void prepareOutputFile(String fileName) throws IOException {
        outputFile = new File(fileName);
        writer = new PrintWriter(outputFile);


    }

}
