import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long max = 0;
        for(int nn:times)if(max<nn)max = nn;
        long left = 0;
        long right = max*n;
        long answer = 0;
        while(left<=right){
            long mid = (left+right)/2;
            long timeSum = 0;
            for(int time:times){
                timeSum+=mid/time;
            }
            if(timeSum>=n){
                answer = mid;
                right = mid-1;
            }
            else left = mid+1;
        }
        return answer;
    }
}

// 끝날때마다 바로 들어갈 지, 기다렸다가 다른 사람한테 받을지
// 다음 사람 예상 끝나는 시간을 배열에 추가한다. 그리고 그게 가장 작은 곳부터 넣는다.
// 우선순위 큐를 쓰자
