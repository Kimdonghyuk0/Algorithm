import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int sum = 1;
        Map<String,Integer> map = new HashMap<>();
        for(String[] cloth:clothes){
            map.put(cloth[1],map.getOrDefault(cloth[1],0)+1);
        }
        for(String s:map.keySet()){
            sum*=map.get(s)+1;
        }
        return sum-1;
    }
}
// 해시맵에 카운팅으로 저장하고 모든 카운트 + 1 하고 전부 곱하고 1을 빼준다.
// 그리고 set에 옷 종류 저장하고 set 순회하면서 체크한다.