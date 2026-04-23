import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i<bridge_length; i++){
            q.add(0);
        }
        int time = 0;
        int sum = 0;
        for(int i = 0; i<truck_weights.length; i++){
            // 앞에 있는 애 빼
            while(true){
            time++;
            sum-=q.poll();
            if(sum+truck_weights[i]<=weight){
                sum+=truck_weights[i];
                q.add(truck_weights[i]);
                break;
        
            }
            else q.add(0);
                
        }
        }
        return time+bridge_length;
    }
}