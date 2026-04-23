import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n : scoville){
            pq.add(n);
        }
        int ans = 0;
        while(true){
            int min1 = pq.poll();
            if(min1>=K)break;
            if(pq.isEmpty())return -1;
            int min2 = pq.poll();
            pq.add(min1+min2*2);
            ans++;
        }
        return ans;
    }
}
// 우선순위 큐에 스코빌 넣고 작은거 꺼내서 K랑 비교 후 섞는다 무한반복