import java.util.*;

class Solution {
    // map 으로 알파벳,마지막으로 나온 위치 하고 현재위치-마지막으로 나온 위치 하면됨. 기본값은 -1
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            int before = map.getOrDefault(c,-1);
            if(before == -1) answer[i] = before;
            else answer[i] = i - before;
            map.put(c,i);
        }
        
        return answer;
    }
}