import java.util.*;

class Solution {
    
    public String solution(int[] numbers) {
        List<String> s = new ArrayList<>();
        for(int i = 0; i<numbers.length; i++){
            s.add(numbers[i]+"");
        }
        
        s.sort((a,b)->{
        
            return (b+a).compareTo((a+b));
        });
        StringBuilder sb = new StringBuilder();
        for(String str:s)sb.append(str);
        if (s.get(0).equals("0")) {
            return "0";
        }
        return sb.toString();
    }
}

