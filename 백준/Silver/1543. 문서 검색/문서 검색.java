import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       String str = br.readLine();
       String word =  br.readLine();
       int count = 0;
       int index = str.indexOf(word);
       while(index != -1){
           str = str.substring(index+word.length());
           count++;
           index = str.indexOf(word);
       }
       System.out.println(count);
    }
}