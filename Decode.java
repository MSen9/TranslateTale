import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import java.util.*;
//import java.lang.*;
public class Decode {
	public static void main(String args[]) throws IOException {  
      FileReader in = null;
      FileWriter out = null;
      //List<String> extractedLines = new ArrayList<String>();
      String line = null;
      String outputLine = null;
      //int quotationCount;
      //The input is formatted in such a way that at the 3rd quotation mark is the start of the string value
     
      int i;
    
      //String NUMBERS = "0123456789";
      // the \\ and ^ may need to be skipped ahead for ease
 
      
      try {
         in = new FileReader("EndsAdded.txt");
         
         BufferedReader br = new BufferedReader(in);
         out = new FileWriter("Decoded.txt");
         BufferedWriter output = new BufferedWriter(out);
         //quotationCount = 0;
         while ((line = br.readLine()) != null) {
        	 //outputLine = "";
        	 outputLine = line;
        	 //E values
        	 for(i=0;i<10;i++) {
        		 outputLine = NumToCode(outputLine, "60"+i , "\\E" + i);
        	 }
        	 //^ Values
        	 for(i=0;i<10;i++) {
        		 outputLine = NumToCode(outputLine, "61"+i , "^" + i);
        	 }
        	 outputLine = NumToCode(outputLine, "620" , "\\[C]");
        	 outputLine = NumToCode(outputLine, "621" , "\\[1]");
        	 outputLine = NumToCode(outputLine, "622" , "\\[2]");
        	 outputLine = NumToCode(outputLine, "623" , "\\[I]");
        	 outputLine = NumToCode(outputLine, "624" , "\\[G]");
        	 outputLine = NumToCode(outputLine, "625" , "\\TT");
        	 outputLine = NumToCode(outputLine, "626" , "\\Ta");
        	 outputLine = NumToCode(outputLine, "627" , "\\TR");
        	 outputLine = NumToCode(outputLine, "628" , "\\TS");
        	 outputLine = NumToCode(outputLine, "629" , "\\Ts");
        	 for(i=0;i<10;i++) {
        		 outputLine = NumToCode(outputLine, "63"+i , "\\T" + i);
        	 }
        	 for(i=0;i<10;i++) {
        		 outputLine = NumToCode(outputLine, "64"+i , "\\F" + i);
        	 }
        	 for(i=0;i<10;i++) {
        		 outputLine = NumToCode(outputLine, "65"+i , "\\M" + i);
        	 }
        	 outputLine = NumToCode(outputLine, "660" , "\\W");
        	 outputLine = NumToCode(outputLine, "661" , "\\R");
        	 outputLine = NumToCode(outputLine, "662" , "\\X");
        	 outputLine = NumToCode(outputLine, "663" , "\\Y");
        	 outputLine = NumToCode(outputLine, "664" , "\\B");
        	 outputLine = NumToCode(outputLine, "665" , "\\G");
        	 outputLine = NumToCode(outputLine, "666" , "\\O");
        	 outputLine = NumToCode(outputLine, "667" , "\\L");
        	 outputLine = NumToCode(outputLine, "668" , "\\P");
        	 outputLine = NumToCode(outputLine, "669" , "\\p");
        	 outputLine = NumToCode(outputLine, "670" , "\\*Z");
        	 outputLine = NumToCode(outputLine, "671" , "\\*X");
        	 outputLine = NumToCode(outputLine, "672" , "\\*C");
        	 outputLine = NumToCode(outputLine, "673" , "\\*A");
        	 outputLine = NumToCode(outputLine, "674" , "\\*D");
        	 outputLine = NumToCode(outputLine, "675" , "\\*W");
        	 outputLine = NumToCode(outputLine, "676" , "\\*W");
        	 outputLine = NumToCode(outputLine, "677" , "\\z4");
        	 outputLine = NumToCode(outputLine, "680" , "\\TA");
        	 outputLine = NumToCode(outputLine, "681" , "\\TP");
        	 outputLine = NumToCode(outputLine, "682" , "\\TM");
        	 outputLine = NumToCode(outputLine, "683" , "\\TF");
        	 outputLine = NumToCode(outputLine, "684" , "\\Tt");
        	 outputLine = NumToCode(outputLine, "685" , "\\Tf");
        	 outputLine = NumToCode(outputLine, "698" , "&");
        	 outputLine = NumToCode(outputLine, "699" , "#");
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
	
	public static String NumToCode(String line, String code, String decode) {
		line = line.replace(code, decode);
		return line;
	}
		
	
}
