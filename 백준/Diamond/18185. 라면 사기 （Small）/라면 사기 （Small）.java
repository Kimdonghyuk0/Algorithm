import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 뒤에서 i+2 접근하려고 여유칸 2개 추가
        int[] ramen = new int[N+2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            ramen[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        for(int i = 0; i<N; i++){
            // i+1이 i+2보다 많으면
            // i+1의 초과분은 3개 묶음에 못들어가므로
            // (i,i+1) 2개 묶음을 먼저 처리
            if(ramen[i+1] > ramen[i+2]){
                int min = Math.min(ramen[i], ramen[i+1] - ramen[i+2]);

                ramen[i] -= min;
                ramen[i+1] -= min;

                ans += 5 * min;
            }
            // 3개 묶음 (i,i+1,i+2)
            int min = Math.min(ramen[i], Math.min(ramen[i+1], ramen[i+2]));

            ramen[i] -= min;
            ramen[i+1] -= min;
            ramen[i+2] -= min;

            ans += 7 * min;

            // 2개 묶음 (i,i+1)
            min = Math.min(ramen[i], ramen[i+1]);

            ramen[i] -= min;
            ramen[i+1] -= min;

            ans += 5 * min;
            //  남은 거 1개 구매
            ans += 3 * ramen[i];
            ramen[i] = 0;
        }
        System.out.println(ans);
    }
}
