import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());;

        // 뒤에서 i+2 접근하려고 여유칸 2개 추가
        long[] ramen = new long[N+2];
        st = new StringTokenizer(br.readLine());
        long sum = 0;
        for(int i=0;i<N;i++){
            ramen[i] = Long.parseLong(st.nextToken());
            sum+=ramen[i];
        }
        if (B <= C) {
            System.out.println(sum * B);
            return;
        }
        long ans = 0;
        for(int i = 0; i<N; i++){
            // i+1이 i+2보다 많으면
            // i+1의 초과분은 3개 묶음에 못들어가므로
            // (i,i+1) 2개 묶음을 먼저 처리
            if(ramen[i+1] > ramen[i+2]){
                long min = Math.min(ramen[i], ramen[i+1] - ramen[i+2]);

                ramen[i] -= min;
                ramen[i+1] -= min;

                ans += (B+C) * min;
            }
            // 3개 묶음 (i,i+1,i+2)
            long min = Math.min(ramen[i], Math.min(ramen[i+1], ramen[i+2]));

            ramen[i] -= min;
            ramen[i+1] -= min;
            ramen[i+2] -= min;

            ans += (B+C* 2L) * min;

            // 2개 묶음 (i,i+1)
            min = Math.min(ramen[i], ramen[i+1]);

            ramen[i] -= min;
            ramen[i+1] -= min;

            ans += (B+C) * min;
            //  남은 거 1개 구매
            ans += B * ramen[i];
            ramen[i] = 0L;
        }
        System.out.println(ans);
    }
}
