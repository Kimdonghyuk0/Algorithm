class Solution {
    public int solution(int n, int m, int[] section) {
        boolean[] check = new boolean[n+1];
        for(int i = 0; i<section.length; i++){
            check[section[i]] = true;
        }
        
        int count = 0;
        
        for(int i = 1; i<=n; i++){
            if(check[i]){
                count++;
                for(int k = i; k<i+m; k++){
                    if(k<=n)check[k] = false;
                }
            }
        }
        
        return count;
    }
}