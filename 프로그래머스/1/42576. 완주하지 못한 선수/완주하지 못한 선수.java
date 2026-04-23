import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String p: completion){
            if(map.get(p)==null){
                map.put(p,1);
            }
            else map.put(p,map.get(p)+1);
        }
        for(int i = 0; i<participant.length; i++){
            if(map.get(participant[i])!=null&&map.get(participant[i])>0){
                map.put(participant[i],map.get(participant[i])-1);
            }
            else return participant[i];
        }
      return "";
    }
}

//동명이인이 있으니까 한명씩 빼는 구조로 가야할듯