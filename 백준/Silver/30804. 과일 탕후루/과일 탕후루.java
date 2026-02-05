import java.io.*;
import java.util.*;

public class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] tangs = new int[N];
            int[] freq = new int[10];
            for(int i = 0; i<N; i++){
                tangs[i] = Integer.parseInt(st.nextToken());
            }
            int right = 0;
            int left = 0;
            int max = 0;
            int v = 0;
            while(right<N){
                int vc = 0;
                if(v<=2)freq[tangs[right]]++;

                for(int i = 1; i<=9; i++){
                    if(freq[i]>0)vc++;
                }
                v = vc;
                if(vc<=2){
                    if(max<right-left+1)max = right-left+1;

                    right++;
                }
                else {
                    freq[tangs[left]]--;
                    left++;
                }
            }
            System.out.println(max);


        }

}
