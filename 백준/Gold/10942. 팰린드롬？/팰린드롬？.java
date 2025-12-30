import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N;

        N = Integer.parseInt(br.readLine());
        int[] sequence = new int[N+1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i<=N; i++){
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N+1][N+1];
        for(int i = 1; i<=N; i++){
            dp[1][i] = 1;
            if(i!=N)dp[2][i] = sequence[i]==sequence[i+1]?1:0;
        }
        for(int i = 3; i<N+1; i++){ //i개
            for(int j = 1; j<N+1; j++){ //j에서부터 시작
                if(j+i-1<=N&&dp[i-2][j+1]==1){
                    if(sequence[j]==sequence[j+i-1])dp[i][j]=1;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i<M; i++){
            int start,end;
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            bw.write((char) ('0' + dp[end-start+1][start]));
            bw.newLine();
        }
        bw.flush();

    }

}
