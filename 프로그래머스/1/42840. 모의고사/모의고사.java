import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int p1Count = 0;
        int p2Count = 0;
        int p3Count = 0;
        for(int i = 0; i<answers.length; i++){
            if(answers[i]==p1[i%5])p1Count++;
            if(answers[i]==p2[i%8])p2Count++;
            if(answers[i]==p3[i%10])p3Count++;
        }
        int max = Math.max(Math.max(p1Count,p2Count),Math.max(p3Count,p2Count));
        ArrayList<Integer> ans = new ArrayList<>();
        if(p1Count==max)ans.add(1);
        if(p2Count==max)ans.add(2);
        if(p3Count==max)ans.add(3);
        return ans.stream().mapToInt(Integer::intValue).toArray();
        
    }
}