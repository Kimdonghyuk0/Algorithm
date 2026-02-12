import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()  );
        long N = Integer.parseInt(st.nextToken());
        long K = Integer.parseInt(st.nextToken());
        // K == N인 경우 합이랑 K+1랑 나눠지는지만
        if(K==N){
            if(((1+N)*N/2)%(K+1)==0)System.out.println("YES");
            else System.out.println("NO");
        }
        else System.out.println("YES");


    }
}
