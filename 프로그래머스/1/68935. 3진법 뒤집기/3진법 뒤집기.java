class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        int mod = 0;
         while (n > 0) {
            sb.append(n % 3);
            n /= 3;
         }
         answer = Integer.parseInt(sb.toString(), 3);
        
        System.out.println(sb.toString());
        return answer;
    }
}