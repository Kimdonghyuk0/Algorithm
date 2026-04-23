import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->{ //값만 넣는다.
            return b-a;
        });
        Queue<int[]> q = new ArrayDeque<>(); // 위치,가중치
        for(int i = 0; i<priorities.length; i++){
            pq.add(priorities[i]);
            q.add(new int[]{i,priorities[i]});
        }
        for(int i = 0; i<priorities.length; i++){
            int target = pq.poll();
            while(true){
                int[] now = q.poll();
                if(now[1]==target){
                    if(now[0]==location)return i+1;
                    break;
                }
                else q.add(new int[]{now[0],now[1]});
            }
        }
        return 0;
    }
}
//우선순위큐에서 꺼낸 값이랑 같을때까지 넣고 빼고