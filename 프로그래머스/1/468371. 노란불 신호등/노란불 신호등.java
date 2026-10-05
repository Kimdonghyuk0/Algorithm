// 초록 노랑 빨강, 1초부터 시작
// 첫번째는 초록초 2번째부턴 거기에 초노빨 다 더한거
// 배열true이면 노란색 나중에 살아남는 배열중 가장 앞에 있는거하면됨
class Solution {
    public int solution(int[][] signals) {
        int answer = 0;
        int[] isYellow = new int[1500000];
        for(int i = 0; i<signals.length; i++){
            int g = signals[i][0];
            int y = signals[i][1];
            int r = signals[i][2];
            int start = g;
            int sum = g+y+r;
            // sum간격으로 노란색 색칠
            for(int k = start; k<isYellow.length; k+=sum){
                // 노란색 개수만큼
                for(int j = 0; j<y; j++){
                     if((k+j)<isYellow.length)isYellow[k+j]++;
                }
               
            }
        }
        
        for(int n:isYellow){
            answer++;
            if(n==signals.length)return answer;
        }
        
        return -1;
    }
}