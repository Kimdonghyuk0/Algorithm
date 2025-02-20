import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
       ArrayList<Integer> ans = new ArrayList<>();
    for(String[] arr: photo ){
        int sum = 0;
        for(String str: arr){
            for(int i = 0; i<name.length; i++){
                if(name[i].equals(str)){
                    sum+=(yearning[i]);
                }
            }
        }
        ans.add(sum);
    }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}