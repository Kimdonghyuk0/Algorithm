
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
       String str;
       int N;
       N = Integer.parseInt(bf.readLine());
       for(int i = 0; i<N; i++) {
    	   str = bf.readLine();
    	   System.out.println((str.charAt(0)+"").toUpperCase()+str.substring(1));
       }
       
       
    }
}