import java.util.*;


class Solution{
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i<commands.length; i++  ){
            int s = commands[i][0];
            int n = commands[i][1];
            int k = commands[i][2];
            ArrayList<Integer> list = new ArrayList<>();
            for(int j = s; j<n+1; j++){
                list.add(array[j-1]);
            }
            Collections.sort(list);
            answer[i] = list.get(k-1);
        }
        return answer;
    }
}