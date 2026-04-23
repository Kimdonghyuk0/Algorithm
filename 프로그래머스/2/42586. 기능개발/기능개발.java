import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] days = new int[progresses.length];
        for(int i = 0; i<days.length; i++){
            int remain = 100-progresses[i];
            int day = 0;
            if(remain%speeds[i]>0)day++;
            day+=remain/speeds[i]; 
            days[i] = day;
        }
        int n = days[0]; // 남은 날짜 
        int count = 1; // 몇개를 넣을 수 있는가
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i<days.length; i++){
            if(n>=days[i])count++;
            else{
                list.add(count);
                n = days[i];
                count = 1;
            }
            
        }
        list.add(count);
        
        int[]ans = new int[list.size()];
        for(int i = 0; i<list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}
//리스트에 작업완료 시간적는다.
// 앞쪽 시간이 더 많이 걸리거나 같으면 같이 배포한다. 그 
// 7 3 9