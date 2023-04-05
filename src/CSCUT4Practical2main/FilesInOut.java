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
    	File file = new File("../../" + args[0]);
    	File outFile = new File("../../"+ args[1]);
    	PrintWriter out = new PrintWriter(outFile);
    	try {
    		StringBuilder sb = new StringBuilder();
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				String tokens[] = line.split(" ");
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
						if(word.length() > 1) {
							sb.append(word.substring(1).toLowerCase());
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
