import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import java.util.*;
//import java.lang.*;
public class FixCaps {
	public static void main(String args[]) throws IOException {  
      FileReader in = null;
      FileReader in2 = null;
      FileWriter out = null;
      int LINE_NUMBER = 16457;
      //List<String> extractedLines = new ArrayList<String>();
      String line = null;
      String line2 = null;
      //String outputLine = null;
      //defaults to 0. 1 means upper line, 2 means lower
      int[] lineType = new int[LINE_NUMBER];
      //String nextNum = "";
      //int i;
      //int dotValue = 0;
      int lineNumber = 0;
      //boolean firstPassed = false;
      //boolean inValid = false;
      //String NUMBERS = "0123456789";
      
      try {
         in = new FileReader("outputLines.txt");
         
         BufferedReader br = new BufferedReader(in);
         in2 = new FileReader("NumbersRemoved.txt");
         
         BufferedReader br2 = new BufferedReader(in2);
         out = new FileWriter("FixedCapitals.txt");
         BufferedWriter output = new BufferedWriter(out);
         
         while ((line = br.readLine()) != null) {
        	 
        	 if(line.toUpperCase().equals(line)) {
        		System.out.println("Upper line at " + lineNumber); 
        		lineType[lineNumber] = 1;
        		//output.write(line2.toLowerCase());
                //output.newLine();
        	 } else if(line.toLowerCase().equals(line)) {
        		 System.out.println("Lower line at " + lineNumber); 
        		 lineType[lineNumber] = 2;
        		 //output.write(line2.toLowerCase());
                 //output.newLine();
        	 } 
        	 lineNumber++;
         }
         br.close();
         lineNumber = 0;
         while((line2 = br2.readLine()) != null ) {
        	 if(lineType[lineNumber] == 0) {
        		output.write(line2);
                output.newLine();
        	 } else if(lineType[lineNumber] == 1) {
        		output.write(line2.toUpperCase());
                output.newLine();
        	 } else {
        		output.write(line2.toLowerCase());
                output.newLine();
        	 }
        	 
        	 lineNumber++;
         }
         
         
        
         output.flush();
         output.close();
         
         br2.close();
      }finally {
         if (in != null) {
            in.close();
         }
         if (in2 != null) {
             in2.close();
          }
         if (out != null) {
            out.close();
         }
      }
   }
}
