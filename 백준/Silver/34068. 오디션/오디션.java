import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 참가자 수 결투의 횟수
        // 경기는 최소 N-1! 번 해야함 , 점수가 같은사람이 없으면 됨

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] player = new long[N+1];
        long ans = 0;
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            player[Integer.parseInt(st.nextToken())]++;
            st.nextToken();
        }
        Arrays.sort(player);

        long min;
        for(int i = 2; i<=N; i++){
            min = player[i-1];
            if(min>=player[i]){
                ans+=min-player[i]+1;
                player[i]+=min-player[i]+1;
            }
        }
        System.out.println(ans);
    }
}