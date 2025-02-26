import java.util.*;

class Solution {
    private static TreeSet<Integer> result = new TreeSet<>();
    private void dfs(int start,int depth,int[] numbers,int sum){
        if(depth==2){
            result.add(sum);
            return;
        }
        for(int i = start; i<numbers.length; i++){
            dfs(i+1,depth+1,numbers,sum+numbers[i]);
            
        }
        
    }
    public int[] solution(int[] numbers) {
        dfs(0,0,numbers,0);
        //Collections.sort(result);
        return result.stream().mapToInt(i->i).toArray();
    }
}