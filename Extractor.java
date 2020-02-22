import java.io.*;
//import java.util.*;
//import java.lang.*;
public class Extractor {
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
      String NUMBERS = "0123456789";
      // the \ and ^ may need to be skipped ahead for ease
      String FORBIDDEN_CHARACTERS = "%/";
      
      try {
         in = new FileReader("EnglishNames.txt");
         
         BufferedReader br = new BufferedReader(in);
         out = new FileWriter("outputLines.txt");
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
        			 if(FORBIDDEN_CHARACTERS.contains(line.charAt(i) + "")) {
        				 //do nothing with the forbidden fruit
        			 }
        			 else if(line.charAt(i) == '\\'){
        				 //encodes special formatting based on type
        				 //checks the next character(s) to see what to do
        				 //NOTE: 600 is added to all encoding in order to avoid confusion with in game values like it
        				 if(line.charAt(i+1) == 'E') {
        					 if(NUMBERS.contains(line.charAt(i+2) + "")) {
            					 //Found an E(number)
        						 //encodes into 0(number)
        						 outputLine += " 60" + line.charAt(i+2) + " ";
        						 i += 2;
            				 } else {
            					 
            					 System.out.println("Error, E found without number after " + lineNumber );
            				 }
        				 } else if(line.charAt(i+1) == '[') {
        					 if(line.charAt(i+2) == 'C') {
        						 //character name encode
        						 outputLine += " 620 ";
        						 i += 3;
        					 }
        					 else if(line.charAt(i+2) == '1') {
        						 //variable 1 name encode
        						 outputLine += " 621 ";
        						 i += 3;
        					 }else if(line.charAt(i+2) == '2') {
        						 //variable 2 name encode
        						 outputLine += " 622 ";
        						 i += 3;
        					 }else if(line.charAt(i+2) == 'I') {
        						 //item name encode
        						 outputLine += " 623 ";
        						 i += 3;
        					 }else if(line.charAt(i+2) == 'G') {
        						 //Gold Amount Encode
        						 outputLine += " 624 ";
        						 i += 3;
        					 } else {
        						 System.out.println("Error, [ with unknown after found " + lineNumber );
        					 } 
        				 } else if(line.charAt(i+1) == 'T') {
        					 if(NUMBERS.contains(line.charAt(i+2) + "")) {
            					 //Found an T(number)
        						 //encodes into 0(number)
        						 outputLine += " 63" + line.charAt(i+2) + " ";
        						 i += 2;
            				 }
        					 else if(line.charAt(i+2) == 'T') {
        						 //TT found
        						 outputLine += " 625 ";
        						 i += 2;
        					 } else if(line.charAt(i+2) == 'a') {
        						 //Ta found
        						 outputLine += " 626 ";
        						 i += 2;
        					 } else if(line.charAt(i+2) == 'R') {
        						 //TR found
        						 outputLine += " 627 ";
        						 i += 2;
        					 }else if(line.charAt(i+2) == 'S') {
        						 //TS found
        						 outputLine += " 628 ";
        						 i += 2;
        					 }else if(line.charAt(i+2) == 's') {
        						 //Ts found
        						 outputLine += " 629 ";
        						 i += 2;
        						 
        					 }else if(line.charAt(i+2) == 'A') {
        						 //TA found
        						 //new one found
        						 outputLine += " 680 ";
        						 i += 2;
        					 }else if(line.charAt(i+2) == 'P') {
        						 //TP found
        						 //new one found
        						 outputLine += " 681 ";
        						 i += 2;
        					 }else if(line.charAt(i+2) == 'M') {
        						 //TM found
        						 //new one found
        						 outputLine += " 682 ";
        						 i += 2;
        					 }else if(line.charAt(i+2) == 'F') {
        						 //TF found
        						 //new one found
        						 outputLine += " 683 ";
        						 i += 2;
        					 }else if(line.charAt(i+2) == 't') {
        						 //Tt found
        						 //new one found
        						 outputLine += " 684 ";
        						 i += 2;
        					 }else if(line.charAt(i+2) == 'f') {
        						 //Tt found
        						 //new one found
        						 outputLine += " 685 ";
        						 i += 2;
        					 }else {
        						 System.out.println("Error, T with unknown after found " + lineNumber );
        					 }
        				 } else if(line.charAt(i+1) == 'F') {
        					 if(NUMBERS.contains(line.charAt(i+2) + "")) {
            					 //Found an F(number)
        						 //encodes into 4(number)
        						 outputLine += " 64" + line.charAt(i+2) + " ";
        						 i += 2;
            				 } else {
            					 System.out.println("Error, F with unknown after found " + lineNumber );
            				 }
        					 
        				 }else if(line.charAt(i+1) == 'M') {
        					 if(NUMBERS.contains(line.charAt(i+2) + "")) {
            					 //Found an T(number)
        						 //encodes into 5(number)
        						 outputLine += " 65" + line.charAt(i+2) + " ";
        						 i += 2;
            				 } else {
            					 System.out.println("Error, M with unknown after found " + lineNumber );
            				 }
        					 
        				 }else if(line.charAt(i+1) == 'S') {
        					 //just ignore for now
        					 i += 2;
        					 
        				 }else if(line.charAt(i+1) == '*') {
        					 //just ignore for now
        					 if(line.charAt(i+2) == 'Z') {
        						 outputLine += " 670 ";
        						 i += 2;
        					 }else if(line.charAt(i+2) == 'X') {
        						 outputLine += " 671 ";
        						 i += 2;
        					 }else if(line.charAt(i+2) == 'C') {
        						 outputLine += " 672 ";
        						 i += 2;
        					 }else if(line.charAt(i+2) == 'A') {
        						 outputLine += " 673 ";
        						 i += 2;
        					 }else if(line.charAt(i+2) == 'D') {
        						 outputLine += " 674 ";
        						 i += 2;
        					 }else if(line.charAt(i+2) == 'W') {
        						 outputLine += " 675 ";
        						 i += 2;
        					 }else if(line.charAt(i+2) == 'S') {
        						 outputLine += " 676 ";
        						 i += 2;
        					 } else {
        						 System.out.println("Error, * with unknown after found " + lineNumber );
        					 }
        					 //color time
        				 } else if(line.charAt(i+1) == 'W') {
        					 outputLine += " 660 ";
    						 i += 1;
        				 }else if(line.charAt(i+1) == 'R') {
        					 outputLine += " 661 ";
    						 i += 1;
        				 }else if(line.charAt(i+1) == 'X') {
        					 outputLine += " 662 ";
    						 i += 1;
        				 }else if(line.charAt(i+1) == 'Y') {
        					 outputLine += " 663 ";
    						 i += 1;
        				 }else if(line.charAt(i+1) == 'B') {
        					 outputLine += " 664 ";
    						 i += 1;
        				 }else if(line.charAt(i+1) == 'G') {
        					 outputLine += " 665 ";
    						 i += 1;
        				 }else if(line.charAt(i+1) == 'O') {
        					 outputLine += " 666 ";
    						 i += 1;
        				 }else if(line.charAt(i+1) == 'L') {
        					 outputLine += " 667 ";
    						 i += 1;
        				 }else if(line.charAt(i+1) == 'P') {
        					 outputLine += " 668 ";
    						 i += 1;
        				 }else if(line.charAt(i+1) == 'p') {
        					 outputLine += " 669 ";
    						 i += 1;
        				 }else if(line.charAt(i+1) == 'z') {
        					 if(line.charAt(i+2) == '4'){
        						 outputLine += " 677 ";
        						
        					 } else {
        						 System.out.println("Error, z with unknown after found " + lineNumber );
        					 }
        					 i += 2;
        				 } else if(line.charAt(i+1) == 'C') {
        					 //Should fix in post script, decides choices
        					 i+=1;
        					 
        				 }else {
        				 
        					 System.out.println("Error, \\ with unknown after found " + lineNumber );
        				 }
        				 
        				 
        		 	 }
        			 else if(line.charAt(i) == '^'){
        				 //skips special formatting by going one ahead
        				 if(NUMBERS.contains(line.charAt(i+1) + "")) {
        					 //Found an ^(number)
    						 //encodes into 1(number)
    						 outputLine += " 61" + line.charAt(i+1) + " ";
    						 i += 1;
        				 } else if(line.charAt(i+1) == '"'){
        					 //something to fix in post, not to worry about now
        					 //shouldn't do an i+=1 since it goes to a quotation mark
        				 }else {
        				 
        					 System.out.println("Error, ^ found without number after " + lineNumber );
        				 }
        				 
        		 	 }
        			 //experimental, may no work perfectly in translation
        			 else if(line.charAt(i) == '&'){
        				 //Gives space, should help prevent corruption in translation
        				 //encodes to 98;
        				 outputLine += " 698 ";
        			
        		 	 } 
        			 else if(line.charAt(i) == '#'){
        				//Gives space, should help prevent corruption in translation
        				 //Encodes to 99
        				 outputLine += " 699 ";
        		 	 }else {
        		 		outputLine += line.charAt(i);
        		 	 }
        			 
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
