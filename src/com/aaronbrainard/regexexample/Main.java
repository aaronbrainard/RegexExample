package com.aaronbrainard.regexexample;

import java.io.File;

/**
 * Created by aaronbrainard on 5/14/2015.
 * Master class to use the Regex functions defined in RegularExpression.java
 */
public class Main {
    /**
     *  Instantiate a RegularExpression object
     *  Instantiate input files
     *  Call Regex functions to process and output
     * @param args Main method parameter
     */
    public static void main(String[] args) {

        RegularExpression rx = new RegularExpression();

        File inFile = new File("C:\\Users\\aaronbrainard\\IdeaProjects\\RegexExample\\data.txt");
        rx.changeToCsv(inFile);

        File nameFile = new File("names.txt");
        rx.extractNamesWithPhoneNumbers(nameFile);



        File wordFile = new File("listofwords.txt");
        rx.findWordAtLeastThreeVowels(wordFile);


    }
}
