
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
       String n;
       n=bf.readLine(); 
     
       
       
       int N, F;
       N = Integer.parseInt(n);
       F = Integer.parseInt(bf.readLine());
       N -= N%100; // 맨 뒤 두자리를 00으로 만듧
       for(int i = 0; i<99; i++) {
    	   if(((N+i)%F)==0) {
    		   System.out.printf("%02d",i);
    		   break;
    	   }
    	 
       }
     
       
       
    }
}
