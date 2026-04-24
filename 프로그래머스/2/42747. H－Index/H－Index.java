import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int left = 0; 
        int right = citations.length;
        while(left<=right){
            
            int mid = (left+right)/2;
            int count = check(mid,citations);
            if(count==mid)return mid;
            if(count>mid){
                answer = mid;
                left = mid+1;
            }
            else right = mid-1;
        }
            

            
            
        return answer;
    }
    static int check(int n,int[] citations){
        int count = 0;
        for(int c:citations){
            if(c>=n)count++;
        }
        
        return count;
        
    }
}

// 정렬 후 이분탐색으로 h찾기
//0 1 3 5 6 
//0 1 2 3 4 