import java.util.Arrays;

class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        int[][] difNindex = new int[numlist.length][2];
        for(int i = 0; i<difNindex.length; i++){
            difNindex[i][0] = Math.abs(numlist[i]-n);
             difNindex[i][1] = numlist[i];
        }
        Arrays.sort(difNindex,(a,b)->{
            if(a[0]==b[0]){
                return b[1]-a[1];
            }
            return a[0] - b[0];
        });
        for(int i= 0; i<numlist.length; i++){
            answer[i] = difNindex[i][1];
        }
        return answer;
    }
}