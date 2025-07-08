
import java.io.*;
import java.util.*;



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        int max = 0;
        for(int i = 1; i<str1.length()+1; i++){
            for(int k = 1; k<str2.length()+1; k++){
                if(str1.charAt(i-1)==str2.charAt(k-1)){
                    dp[i][k]=dp[i-1][k-1]+1;
                }
                else dp[i][k] = Math.max(dp[i-1][k],dp[i][k-1]);
                if(max<dp[i][k])max = dp[i][k];
            }
        }
        System.out.println(max);


    }
}