import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            int A = 1;
            int B = A+N;
            //B가 소수면 출력
            boolean flag = false;
            for(int i = 2; i<B/2; i++){
                if(B%i==0){
                    flag = true;
                break;
                }
            }
            if(flag)System.out.println(0);
            else {
                System.out.println(1);
                System.out.println(A+" "+B);
            }
        }

    }
}
