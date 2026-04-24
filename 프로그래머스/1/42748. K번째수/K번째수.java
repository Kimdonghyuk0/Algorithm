import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> ansList = new ArrayList<>();
        
        for(int[] command: commands){
            int i,j,k;
            i = command[0]-1;
            j = command[1]-1;
            k = command[2]-1;
            int size = j-i+1;
            int[] temp = new int[size];
            for(int ii = i; ii<=j; ii++){
                temp[ii-i] = array[ii];
            }
            Arrays.sort(temp);
            ansList.add(temp[k]);
            
        }
        
        int[] answer = new int[ansList.size()];
        for(int i = 0; i<answer.length; i++){
            answer[i] = ansList.get(i);
        }
        return answer;
    }
}