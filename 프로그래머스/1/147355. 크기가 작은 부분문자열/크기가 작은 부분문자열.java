class Solution {
    public int solution(String t, String p) {
        Long pNum = Long.parseLong(p);
        int plen = p.length();
        int count = 0;
        for(int i = 0; i<t.length()-plen+1; i++){
            Long tsNum = Long.parseLong(t.substring(i,i+plen));
            if(tsNum<=pNum)count++;
            System.out.println(tsNum);
        }
        return count;
    }
}