import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
        public static void main(String[] args) throws IOException {
            // 조합으로 접근하려다 연산이 너무 크길래 dp로 고민
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            int N = Integer.parseInt(br.readLine());
            int[] chu = new int[N];
            st = new StringTokenizer(br.readLine());
            boolean[] arr = new boolean[40001];
            for(int i = 0; i<N; i++){
                chu[i] = Integer.parseInt(st.nextToken());
            }
            arr[0] = true;
            for(int w:chu){
                boolean[] copy = arr.clone();
                for(int i = 0; i<=15000; i++){

                    if(arr[i]){
                        copy[i+w] = true;
                        copy[Math.abs(i-w)] = true;
                    }
                  
                }
                arr = copy;
            }


            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i<M; i++){
                if(arr[Integer.parseInt(st.nextToken())])System.out.print("Y ");
                else System.out.print("N ");
            }

        }

}
