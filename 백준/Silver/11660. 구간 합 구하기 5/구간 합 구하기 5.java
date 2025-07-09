
import java.io.*;
import java.util.*;



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[1025][1025];
        int[][] dp = new int[1025][1025];
        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=N; j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = matrix[i][j]+dp[i][j-1]+dp[i-1][j]-dp[i-1][j-1];
            }
        }

        int y1,y2,x1,x2;
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            y1 = Integer.parseInt(st.nextToken());
            x1 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            bw.write(dp[y2][x2]+dp[y1-1][x1-1]-dp[y2][x1-1]-dp[y1-1][x2]+"\n");
        }
        bw.flush();
    }
}