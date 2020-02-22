import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import java.util.*;
//import java.lang.*;
public class AddEnds {
	public static void main(String args[]) throws IOException {  
      FileReader in = null;
      FileReader in2 = null;
      FileWriter out = null;
      
      //List<String> extractedLines = new ArrayList<String>();
      String line = null;
      String line2 = null;
      //String outputLine = null;
      //String nextNum = "";
      int i;
      //int dotValue = 0;
      int lineNumber = 0;
      //boolean firstPassed = false;
      //boolean inValid = false;
      //String NUMBERS = "0123456789";
      
      try {
         in = new FileReader("TrueLines.txt");
         
         BufferedReader br = new BufferedReader(in);
         in2 = new FileReader("FixedCapitals.txt");
         
         BufferedReader br2 = new BufferedReader(in2);
         out = new FileWriter("EndsAdded.txt");
         BufferedWriter output = new BufferedWriter(out);
         
         
         while (true) {
        	 line = br.readLine();
        	 line2 = br2.readLine();
        	 if(line == null || line2 == null) {
        		 break;
        	 }
        	 //reset some values
        	 //outputLine = "";
        	 //nextNum = "";
        	 //dotValue = 0;
        	 //firstPassed = false;
        	 //inValid = false;
        	 // goes to next line
        	 output.write(line2);
        	 //lineNumber++;
        	 //System.out.println(lineNumber);
        	 for(i=0;i<line.length();i++) {
        		 if(line.charAt(i) == '/') {
  
        			 output.write(line.substring(i));
        			 break;
        		 } else if(line.charAt(i) == '%') {
        			 output.write(line.substring(i));
        			 break;
    				
        		}
        		 else if(line.charAt(i) == '\\') {
   				 	if(line.charAt(i+1) == 'C') {
   				 		output.write(line.substring(i));
   				 		break;
   				 	}
        		}
        	 }
        	 
             //line is processed, add it to the list
        	 
             //extractedLines.add(outputLine);
        	 output.newLine();
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