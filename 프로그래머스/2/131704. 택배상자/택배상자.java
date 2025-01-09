import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> mainT = new Stack<Integer>();
        Stack<Integer> subT = new Stack<Integer>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i = order.length+1; i>=1; i--){
            mainT.push(i);
        }
        int i = 0;
       while(true){
           if(mainT.isEmpty()||i>order.length-1)break;
            int box = order[i];
            if(box==mainT.peek()){
                ans.add(box);
                mainT.pop();
                i++;
                continue;
            }
            if(!subT.isEmpty()){
                if(box==subT.peek()){
                ans.add(box);
                subT.pop();
                i++;
                continue;
            }
            
           
        }
            int temp = mainT.pop();
            subT.push(temp);
            }
            
        answer = ans.size();
        
        return answer;
        
    }
}