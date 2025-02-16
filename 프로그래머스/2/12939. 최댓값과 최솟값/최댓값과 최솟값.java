import java.util.*;

class Solution {
    public String solution(String s) {
        int max;
        int min;
        String answer;
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(s);
        int num = Integer.parseInt(st.nextToken());
        max = num;
        min = num;
        while(st.hasMoreTokens()){
            num = Integer.parseInt(st.nextToken());
            if(num<min)min = num;
            if(max<num)max = num;
        };
        sb.append(min).append(" ").append(max);
        answer = sb.toString();
        return answer;
    }
}