import java.util.*;

class Solution {
    public String[] solution(String[] names) {
        
        ArrayList<String> list = new ArrayList<>();
        int i = 0;
        while(true){
            if(i>=names.length)break;
            list.add(names[i]);
            i+=5;
        }
        
        return list.toArray(new String[0]);
    }
}