import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            int[][] cows = new int[N][2];
            for(int i = 0; i<N; i++){
                int s,t;
                StringTokenizer st = new StringTokenizer(br.readLine());
                s = Integer.parseInt(st.nextToken());
                t = Integer.parseInt(st.nextToken());
                cows[i][0] = s;
                cows[i][1] = t;
            }
            Arrays.sort(cows, (a, b) -> Integer.compare(a[0], b[0]));
            int time = 0;
            for(int[] arr:cows){
                if(time<=arr[0])time = arr[0]+arr[1];
                else time+=arr[1];
            }
            System.out.println(time);

        }

}
