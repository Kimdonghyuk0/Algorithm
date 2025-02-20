class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int ans = 0;
        for(int i = 0; i<schedules.length; i++){
            schedules[i]+=10;
            if(schedules[i]%100>59){
                schedules[i]+=40;
            }
        }
        int i = 0;
        for(int[]arr:timelogs){
            boolean success = true;
            int day = startday;
            for(int time : arr){
                if(day!=6&&day!=7&&schedules[i]<time){
                    success = false;
                    break;
                }
                day++;
                if(day==8)day = 1;
            }
            if(success)ans++;
            i++;
            
        }
        return ans;
    }
}