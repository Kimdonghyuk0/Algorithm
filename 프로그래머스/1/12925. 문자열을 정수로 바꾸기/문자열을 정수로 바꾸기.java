class Solution {
    public int solution(String s) {
        int answer;
        if(s.charAt(0)=='-')answer = Integer.parseInt(s.substring(1,s.length()))*-1;
        else answer = Integer.parseInt(s);
        return answer;
    }
}