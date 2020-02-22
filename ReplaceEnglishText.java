import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import java.util.*;
//import java.lang.*;
public class ReplaceEnglishText {
	public static void main(String args[]) throws IOException {  
      FileReader in = null;
      FileReader in2 = null;
      FileWriter out = null;
      //List<String> extractedLines = new ArrayList<String>();
      String line = null;
      String replaceLine = null;
      String outputLine = null;
      int quotationCount = 0;
      //String nextNum = "";
      int i;
      //int dotValue = 0;
     // boolean copyInput = false;
      int lineNumber = 0;
      //boolean firstPassed = false;
      //boolean inValid = false;
      //String NUMBERS = "0123456789";
      int QUOTATION_PASS = 3;
      try {
         in = new FileReader("EnglishNames.txt");
         BufferedReader br = new BufferedReader(in);
         
         in2 = new FileReader("chrChanged.txt");
         BufferedReader br2 = new BufferedReader(in2);
         
         out = new FileWriter("ENDGAME.txt");
         BufferedWriter output = new BufferedWriter(out);
         
         while (true) {
        	 
        	 line = br.readLine();
        	 replaceLine = br2.readLine();
        	 if(line == null || replaceLine == null) {
        		 break;
        	 }
        	 outputLine = "";
        	 
        	 lineNumber++;
        	 quotationCount = 0;
        	 //copyInput = false;
        	 if(lineNumber > 2) {
        		 for(i=0;i<line.length();i++) {
        			 if(line.charAt(i) == '"') {
        				 outputLine += "\"";
        				 quotationCount++;
            			 if(quotationCount >= QUOTATION_PASS){
            				 //write out the replaced line and add end
            				 outputLine += replaceLine + "\")";
            				 break;
            			 } 
            		 } else {
            			 
            			 outputLine += line.charAt(i);
            		 }
            		 
            	 }
        	 } else {
        		 outputLine = line;
        	 }
        	 output.write(outputLine);
             output.newLine();
             
         }
         
         
        
         output.flush();
         output.close();
         
         
         br.close();
         br2.close();
         
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
