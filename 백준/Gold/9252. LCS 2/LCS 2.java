import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
       String word1,word2;
       word1 = br.readLine();
       word2 = br.readLine();
       int[][]dp = new int[word2.length()+1][word1.length()+1];

       for(int i = 1; i<word2.length()+1; i++){
           for(int j = 1; j<word1.length()+1; j++){
               if(word2.charAt(i-1)==word1.charAt(j-1))dp[i][j] = dp[i-1][j-1]+1;
               else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
           }
       }
       StringBuilder sb = new StringBuilder();
       int i = word2.length();
       int j = word1.length();
       while(i>0 && j>0){
           if(word2.charAt(i-1)==word1.charAt(j-1)){
               sb.append(word2.charAt(i-1));
               i--;
               j--;

           }
           else if(dp[i-1][j]>dp[i][j-1])i--;
           else j--;
       }


       System.out.println(dp[word2.length()][word1.length()]);
       System.out.println(sb.reverse());

    }
}
