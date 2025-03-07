class Solution {
    public int solution(int[][] info, int n, int m) {
        int[][] dp = new int[40][121];
        //모든 값 -1로 초기화
        for(int i = 0; i<dp.length; i++){
            for(int k = 0; k<dp[i].length; k++){
                dp[i][k] = -1;
            }
        }
        int A = info[0][0];
        int B = info[0][1];
        if(B<m)dp[0][B] = 0;
        if(A<n)dp[0][0] = A;
        for(int i = 1; i<info.length; i++){
             A = info[i][0];
             B = info[i][1];
            for(int k = 0; k<dp[i-1].length; k++){
                if(dp[i-1][k]>=0){
                    if(k+B<m)dp[i][k+B] = dp[i-1][k];
                    if(dp[i-1][k]+A<n){
                        if(dp[i][k]!=-1&&dp[i][k]>dp[i-1][k]+A)dp[i][k] = dp[i-1][k]+A;   
                        else if(dp[i][k]==-1)dp[i][k] = dp[i-1][k]+A;
                }
                }
            }
           
        }
         int min = 121;
            for(int i = 0; i<dp[info.length-1].length; i++){
                if(dp[info.length-1][i]!=-1&&dp[info.length-1][i]<min)min = dp[info.length-1][i];
            }
            if(min == 121)return -1;
            return min;
    }
}