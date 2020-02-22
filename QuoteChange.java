import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import java.util.*;
//import java.lang.*;
public class QuoteChange {
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
         in = new FileReader("CleanedTranslateLines");
         
         BufferedReader br = new BufferedReader(in);
         out = new FileWriter("chrChanged.txt");
         BufferedWriter output = new BufferedWriter(out);
         
         while ((line = br.readLine()) != null) {
        	 
        	 outputLine = line.replace("\"", "\" + chr(34) + \"");
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
