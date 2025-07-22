import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] dp = new int[N+1][4]; //1:R 2:G 3:B
        for(int[] arr:dp){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        dp[0][1] = 0;
        dp[0][2] = 0;
        dp[0][3] = 0;

        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=3; j++){
                if(j==2)dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j+1])+Integer.parseInt(st.nextToken());
                else if(j==1)dp[i][j] = Math.min(dp[i-1][j+1],dp[i-1][j+2])+Integer.parseInt(st.nextToken());
                else dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j-2])+Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(Arrays.stream(dp[N]).min().getAsInt());

    }
}
