import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import java.util.*;
//import java.lang.*;
public class NumberRemover {
	public static void main(String args[]) throws IOException {  
      FileReader in = null;
      FileWriter out = null;
      //List<String> extractedLines = new ArrayList<String>();
      String line = null;
      //String outputLine = null;
      //String nextNum = "";
      int i;
      //int dotValue = 0;
      int lineNumber = 0;
      //boolean firstPassed = false;
      //boolean inValid = false;
      //String NUMBERS = "0123456789";
      
      try {
         in = new FileReader("TranslatedLinesText.txt");
         
         BufferedReader br = new BufferedReader(in);
         out = new FileWriter("NumbersRemoved.txt");
         BufferedWriter output = new BufferedWriter(out);
         
         while ((line = br.readLine()) != null) {
        	 //reset some values
        	 //outputLine = "";
        	 //nextNum = "";
        	 //dotValue = 0;
        	 //firstPassed = false;
        	 //inValid = false;
        	 // goes to next line
        	 lineNumber++;
        	 System.out.println(lineNumber);
        	 for(i=0;i<line.length();i++) {
        		 if(line.charAt(i) == '.') {
        			 if(line.length() > i+2) {
        			 output.write(line.substring(i+2));
                     output.newLine();
                     break;
        			 } else {
        				 
        				 output.newLine();
                         break;
        			 }
                     //System.out.println("You shouldn't be seeing this");
        		 }
        	 }
        	 
             //line is processed, add it to the list
        	 
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
