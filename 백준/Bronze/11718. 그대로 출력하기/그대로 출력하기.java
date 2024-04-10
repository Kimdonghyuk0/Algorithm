
import java.io.*;
import java.util.*;	

public class Main {

    public static void main(String[] args)  throws IOException{
     BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
     while(true) {
    	
    	 String sentence = bf.readLine();
    	 if(sentence == null||sentence.isEmpty())break;
    	 bw.write(sentence+"\n");
    	 bw.flush();
    
     }
     bf.close();
     bw.close();
    }
}
