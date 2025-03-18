class Solution {
    public int[] solution(int num, int total) {
        int start =  (2* total/num-num+1)/2;
        int[] answer = new int[num];
        for(int i = 0; i<num; i++){
            answer[i] = start+i;
        }
        return answer;
    }
}