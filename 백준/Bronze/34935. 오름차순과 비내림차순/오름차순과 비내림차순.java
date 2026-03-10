import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean isOrd = true;
        long before = -1*Long.MAX_VALUE;
        for(int i = 0; i<N; i++){
            long now = Long.parseLong(st.nextToken());
            if(before>=now){
                isOrd = false;
                
            }
            before = now;
        }
        if(isOrd)System.out.println(1);
        else System.out.println(0);
    }
}