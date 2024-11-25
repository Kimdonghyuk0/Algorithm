import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 10000;
        while(true){
            int n = 0; //현재 인용수 넘는 논문의 수
            boolean flag = false;
            for (int i = 0; i<citations.length; i++){
                if(citations[i]>=answer)n++;
                if(n>=answer&&citations.length-n<=answer){
                    flag = true;
                    break;
                }
            }
            if(flag)break;
            answer--;
        }
        return answer;
    }
}