import java.util.*;

class Solution {
    boolean solution(String s) {
       int first = 0; //)개수
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            stack.push(s.charAt(i));
        }
        while(!stack.isEmpty()){
            char c = stack.pop();
            if(c==')')first++;
            else first--;
            if(first<0)return false;
        }
        if(first!=0)return false;
        return true;
    }
}