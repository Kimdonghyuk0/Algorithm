import java.io.*;
import java.util.*;



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] stuff = new int[N][2];
        int[][] dp = new int[K+1][N];
        int W,V;
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
            stuff[i][0] = W;
            stuff[i][1] = V;
        }
        for(int i =1; i< dp.length; i++){
            for(int j = 0; j<dp[i].length; j++){
                if(j==0){
                    if(stuff[j][0]<=i)dp[i][j] = stuff[j][1];
                }
                else if(i>=stuff[j][0]){
                    dp[i][j] = Math.max(dp[i-stuff[j][0]][j-1]+stuff[j][1],dp[i][j-1]);
                }
                else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        System.out.println(dp[K][N-1]);
    }
}