import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N1 = Integer.parseInt(br.readLine());
        
        for(int i = 0; i<N1; i++){
            StringTokenizer st =  new StringTokenizer(br.readLine());
            int N  = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            if(N%C==0)System.out.println(N/C);
            else System.out.println(N/C+1);
        }


        

    }


}
