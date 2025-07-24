import java.util.*;

class Solution {
   static class Level{
        int level;
        int now;
        double fail;
        Level(int level, int now, double fail){
            this.level = level;
            this.now = now;
            this.fail = fail;
        }
    }
    public int[] solution(int N, int[] stages) {
        Level[] levels = new Level[N+2];
        for(int i = 0; i<stages.length; i++){
            if(levels[stages[i]]==null)levels[stages[i]]=new Level(stages[i],0,0);
            levels[stages[i]].now++;                                              
        }
        int sum = 0;
        for(int i = N+1; i>=1; i--){
            if (levels[i] == null)levels[i] = new Level(i, 0, 0.0);
            sum+=levels[i].now;
            if (sum == 0) {
     levels[i].fail = 0.0;
} else {
    levels[i].fail = (double) levels[i].now / sum;
}
        }
        Arrays.sort(levels, 1, N + 1,(a,b)->{
            if(a.fail==b.fail)return a.level-b.level;
             return Double.compare(b.fail, a.fail);
        });
        int[] ans = new int[N];
        for(int i = 0; i<N; i++){
            ans[i] = levels[i+1].level;
        }
        return ans;
        
    }
}