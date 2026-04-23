import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String p: completion){
            map.put(p,map.getOrDefault(p,0)+1);
        }
        for(String c:participant){
            if(map.get(c)==null||map.get(c)<1)return c;
            map.put(c,map.get(c)-1);
        }
        return "";
    }
}