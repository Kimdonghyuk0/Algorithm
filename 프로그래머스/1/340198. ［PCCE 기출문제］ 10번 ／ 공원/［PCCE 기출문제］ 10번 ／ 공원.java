import java.util.*;

class Solution {
    private String[][] park;
    
    private boolean isPossible(int size){
         
        for(int i = 0; i < park.length-size+1; i++){
           for(int k = 0; k< park[i].length-size+1; k++){
              // if(size+i>=park.length||size+k>=park[i].length)continue;
               boolean  possible = true;
               for(int j = i; j<i+size; j++){
                   for(int q = k; q<k+size; q++){
                       if(!park[j][q].equals("-1")){
                           possible = false;
                           break;
                       }
                       if(!possible)break;
                   }
               }
               if(possible)return true;
           }
        }
        return false;
    }
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);
        this.park = park;
        for(int i = 0; i<mats.length; i++){
            int size = mats[mats.length-1-i];
            if(isPossible(size)){
                return size;
            }
        }
        return -1;
    }
}