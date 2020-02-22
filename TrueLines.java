import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import java.util.*;
//import java.lang.*;
public class TrueLines {
	public static void main(String args[]) throws IOException {  
      FileReader in = null;
      FileWriter out = null;
      //List<String> extractedLines = new ArrayList<String>();
      String line = null;
      String outputLine = null;
      int quotationCount;
      //The input is formatted in such a way that at the 3rd quotation mark is the start of the string value
      int QUOTATION_PASS = 3;
      int i;
      int lineNumber = 0;
      boolean copyInput = false;
      boolean pastSet= false;
      //String NUMBERS = "0123456789";
      // the \ and ^ may need to be skipped ahead for ease
      //String FORBIDDEN_CHARACTERS = "%/";
      
      try {
         in = new FileReader("EnglishNames.txt");
         
         BufferedReader br = new BufferedReader(in);
         out = new FileWriter("TrueLines.txt");
         BufferedWriter output = new BufferedWriter(out);
         quotationCount = 0;
         while ((line = br.readLine()) != null) {
        	 outputLine = "";
        	 quotationCount = 0;
        	 copyInput = false;
        	 pastSet = false;
        	 // goes to next line
        	 lineNumber++;
        	 
        	 for(i=0;i<line.length();i++) {
        		 
        		 
        		 if(line.charAt(i) == '"') {
        			 quotationCount++;
        			 if(quotationCount >= QUOTATION_PASS && copyInput == false){
        				 copyInput = true;
        				 //adds a quotation mark to supplement chr(34)
        				 if(pastSet) {
        					 outputLine += '"';
        				 }
        			 } else if(quotationCount >= QUOTATION_PASS && copyInput){
        				 copyInput = false;
        				 pastSet= true;
        			 }
        		 }
        		 
        		 else if(copyInput) {
        			
        		 	 
        		 	outputLine += line.charAt(i);
        		 	 
        			 
        		 }
        		 
        	 }
             //line is processed, add it to the list
        	 output.write(outputLine);
             output.newLine();
             //extractedLines.add(outputLine);
             
         }
         
         
         /*
         for(String s : extractedLines) {
              output.write(s);
              output.newLine();
         }
         */
         output.flush();
         output.close();
         //out.flush();
         //out.close();
         //output.flush();
         
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
