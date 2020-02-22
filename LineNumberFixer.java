import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import java.util.*;
//import java.lang.*;
public class LineNumberFixer {
	public static void main(String args[]) throws IOException {  
      FileReader in = null;
      FileWriter out = null;
      //List<String> extractedLines = new ArrayList<String>();
      String line = null;
      String outputLine = null;
      String nextNum = "";
      int i;
      int dotValue = 0;
      int lineNumber = 0;
      boolean firstPassed = false;
      boolean inValid = false;
      String NUMBERS = "0123456789";
      
      try {
         in = new FileReader("TranslatedLinesText.txt");
         
         BufferedReader br = new BufferedReader(in);
         out = new FileWriter("FixedLineNumber.txt");
         BufferedWriter output = new BufferedWriter(out);
         
         while ((line = br.readLine()) != null) {
        	 //reset some values
        	 outputLine = "";
        	 nextNum = "";
        	 dotValue = 0;
        	 firstPassed = false;
        	 inValid = false;
        	 // goes to next line
        	 lineNumber++;
        	 System.out.println(lineNumber);
        	 for(i=0;i<line.length();i++) {
        		 
        		
        		 if(firstPassed && inValid == false) {
        			 if(NUMBERS.contains(line.charAt(i)+ "" )) {
        				 nextNum += line.charAt(i);
        			 }
        			 else if(line.charAt(i) == ' ') {
    				 }
    				 
        			 
        			 else if(line.charAt(i) == '.') {
        				 if(nextNum.equals("")) { 
        				 } 
        				 else if(Integer.parseInt(nextNum) == lineNumber+1) {
        					 //error found, fixing now.
        					 //write substring first, then after
        					 output.write(line.substring(0, dotValue+2));
        		             output.newLine();
        		             output.write(line.substring(dotValue+3));
        		             output.newLine();
        		             lineNumber++;
        		             break;
        				 }
        				 
        			 }else {
    					 inValid = true; 
    					 
    				 }
        		 } else {
        			 if(line.charAt(i) == '.') {
        				 dotValue = i;
        				 firstPassed = true;
        			 }
        		 }
        		 outputLine += line.charAt(i);
        	 }
        	 
             //line is processed, add it to the list
        	 output.write(outputLine);
             output.newLine();
             //extractedLines.add(outputLine);
             
         }
         
         
        
         output.flush();
         output.close();
         
         
         br.close();
         
      }finally {
         if (in != null) {
            in.close();
         }
         if (out != null) {
            out.close();
         }
      }
   }
}
