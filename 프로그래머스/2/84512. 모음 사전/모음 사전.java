import java.util.*;

class Solution {
    public int solution(String word) {
        int count = 1;
        char[] c = {'A','E','I','O','U'};
        List<String> list = new ArrayList<>();
        
        for(int i = 1; i<=5; i++){ // 길이는 i
            StringBuilder sb = new StringBuilder();
            back(c,i,list,sb);
        }
        Collections.sort(list); // 오름 차순 정렬
        
        
        return list.indexOf(word)+1;
    }  // 아에이오우, 타겟 목표, 다만들면 넣을 리스트, 만드는 중sb
    void back(char[] c,int target, List<String> list, StringBuilder sb){
        for(int i = 0; i<5; i++){
            if(sb.length()==target){
                list.add(sb.toString());
                return;
            }
            sb.append(c[i]);
            back(c,target,list,sb);
            sb.deleteCharAt(sb.length()-1);
        }
            
            
    }
    
}

// 모든 조합을 만든다 (백트래킹) 중복 가능하다.
// 오름차순 정렬을 한다.
// 몇번째인지 찾는다.