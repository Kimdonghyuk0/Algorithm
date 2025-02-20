import java.util.*;

class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        ArrayList<HashSet<Integer>> list = new ArrayList<>();
        int count = 0;
        for(int a = 1; a<n+1; a++){
            for(int b = a+1; b<n+1; b++){
                for(int c = b+1; c<n+1; c++){
                    for(int d = c+1; d<n+1; d++){
                        for(int e = d+1; e<n+1; e++){
                            HashSet<Integer> set = new HashSet<>();
                            set.add(a);
                            set.add(b);
                            set.add(c);
                            set.add(d);
                            set.add(e);
                            list.add(set);
                        }
            
                    }
                }
            }
        }
            for(HashSet<Integer>set : list){
                boolean flag = true;
                for(int k = 0; k<q.length; k++){
                    int c = 0;
                     for(int i = 0; i<5; i++){
                        if(set.contains(q[k][i]))c++;
                    }
                    if(c!=ans[k]){
                        flag = false;
                        break;
                    }
                }
                if(flag)count++;
               
            }
        
        return count;
        
    }
}