import java.io.*;
import java.util.*;

public class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            int[][] secAndRange = new int[N][2];
            int[][] secAndAvoid = new int[N][1001];
            //피한 횟수를 넣는 dp
            StringTokenizer st;
            for(int i = 0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                secAndRange[i][0] = Integer.parseInt(st.nextToken());
                secAndRange[i][1] = Integer.parseInt(st.nextToken());
            }
            // 이전초 좌 가 우 중 가장 큰 값을 올린다. 마지막 초에 N-1이상인 값이 있으면 이긴거다.

                int s,e;
                s = secAndRange[0][0];
                e = secAndRange[0][1];
                for(int i = s; i<=e; i++){
                    secAndAvoid[0][i]++;
                }

            for(int i = 1; i<N; i++){//초
                for(int x = 1; x<=1000; x++ ){
                    int max = Math.max(secAndAvoid[i-1][x-1],secAndAvoid[i-1][x]);
                    if(x+1<=1000) max  = Math.max(max,secAndAvoid[i-1][x+1]);
                    secAndAvoid[i][x] = max;

                }
                s = secAndRange[i][0];
                e = secAndRange[i][1];
                for(int k = s; k<=e; k++){
                    secAndAvoid[i][k]++;
                }
            }
            for(int i = 0; i<=1000; i++){
                if(secAndAvoid[N-1][i]>=N-1){
                    System.out.println("World Champion");
                    return;
                }
            }

            System.out.println("Surrender");

        }

}
