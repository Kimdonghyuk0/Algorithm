import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Vector;


public class Main {
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       String str = br.readLine();
       Vector<String> v = new Vector<String>();

       for(int i = 1; i < str.length()-1; i++ ){
            for (int j = i+1; j < str.length(); j++){
                StringBuilder s1 = new StringBuilder(str.substring(0,i));
                StringBuilder s2 = new StringBuilder(str.substring(i,j));
                StringBuilder s3 = new StringBuilder(str.substring(j));
                String ss1 = s1.reverse().toString();
                String ss2 = s2.reverse().toString();
                String ss3 = s3.reverse().toString();
                v.add(ss1+ss2+ss3);
            }
       }
        Collections.sort(v);
       bw.write(v.get(0));
       br.close();
       bw.close();
    }
}