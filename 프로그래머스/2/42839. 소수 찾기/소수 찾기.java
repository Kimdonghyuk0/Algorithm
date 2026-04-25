import java.util.*;

class Solution {
    public int solution(String numbers) {
        boolean[] sosu = new boolean[10_000_000]; //거짓이면 소수임
        int[] nums = new int[numbers.length()];
       
        for(int i = 0; i<numbers.length(); i++){
            nums[i] = numbers.charAt(i) - '0';
        }
         Arrays.sort(nums);
        int answer = 0;
        sosu[0] = true;
        sosu[1] = true;
        for(int i = 2; i<=Math.sqrt(sosu.length); i++){
            for(int j = 2; j<=(sosu.length)/2; j++){
                if(j*i>=sosu.length)break;
                sosu[j*i] = true;
            }
        }
        for(int i = 2; i<sosu.length; i++){
            if(!sosu[i]){
                //numbers 로 만들수 있으면 answer++
                //각 자리수를 배열에 추가
                String n = i+"";
                int[] nums2 = new int[n.length()];
       
        for(int j = 0; j<n.length(); j++){
            nums2[j] = n.charAt(j) - '0';
        }
         Arrays.sort(nums2);
                int nums2P = 0;
                int numsP = 0;
                while(numsP<nums.length&&nums2P<nums2.length){
                    if(nums[numsP]==nums2[nums2P]){
                        numsP++;
                        nums2P++;
                    }
                    else numsP++;
                }
                if(nums2P>=nums2.length)answer++;
                
                    
            }
        }
        return answer;
    }
}

//9999999 이 최댓값
//소수 배열만들고
// 9999999 까지 가면서 조각으로 만들 수 있는지 체크 