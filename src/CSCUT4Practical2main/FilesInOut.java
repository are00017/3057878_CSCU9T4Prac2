package CSCUT4Practical2main;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

/**
 * 
 * CSCU9T4 Java strings and files exercise.
 *
 */
public class FilesInOut {

    public static void main(String[] args) throws FileNotFoundException {
    	// determined if the formatted file should be UpperCase
    	boolean capital = args[0].equalsIgnoreCase("-u");
    	
    	// gets the file names with arguments
    	File file = new File("../../" + args[0]);
    	File outFile = new File("../../"+ args[1]);
    	
    	// updates the arguments if it is UpperCase
    	if (capital){
    		file = new File("../../" + args[1]);
        	outFile = new File("../../"+ args[2]);
    	}
    	
    	PrintWriter out = new PrintWriter(outFile);
    	
    	try {
    		StringBuilder sb = new StringBuilder();
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()) {
				// the line will be read and split,
				String line = sc.nextLine();
				String tokens[] = line.split(" ");
				
				// for every word, if it starts with a letter, the title format will be applied to the word
				// if a number is found, the dd/mm/yyyy format will be applied
				for (int i = 0; i < tokens.length; i++) {
					String word = tokens[i];
					if (word.length() == 0) {
						continue;
					}
					char firstChar = word.charAt(0);;
					if (Character.isAlphabetic(firstChar)) {
						if (Character.isLowerCase(firstChar))
						firstChar = Character.toUpperCase(firstChar);
						sb.append(firstChar);

						// will format the rest of the word
						// depending on the capital condition
						if(word.length() > 1) {
							if (capital) {
								sb.append(word.substring(1).toUpperCase());
							}else {
								sb.append(word.substring(1).toLowerCase());
							}
						}
						else {
							// will append if the token has only one letter (middle name)
							sb.append(".");
						}
						sb.append(" ");
					} else if (Character.isDigit(firstChar)) {
						sb.append("    ");
						String day = word.substring(0,2);
						String month = word.substring(2,4);
						String year = word.substring(4,8);
						sb.append(day + "/");
						sb.append(month + "/");
						sb.append(year);
					}
				}
				sb.append("\n");
			}
			out.print(sb.toString().trim());
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    } // main

} // FilesInOut
