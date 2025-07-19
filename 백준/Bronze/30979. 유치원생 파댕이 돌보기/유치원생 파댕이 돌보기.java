import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N =  Integer.parseInt(br.readLine());
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            sum+=Integer.parseInt(st.nextToken());

        }
        if(sum>=T)System.out.println("Padaeng_i Happy");
        else System.out.println("Padaeng_i Cry");
    }



}