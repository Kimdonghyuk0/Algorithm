import java.util.Arrays;

class Solution {
    public String solution(int[] nums) {
        Integer[] numbers = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        String answer;
        Arrays.sort(numbers,(a,b)->{
            String ab = a.toString()+b.toString();
            String ba = b.toString()+a.toString();
            return ba.compareTo(ab);
        });
        StringBuilder sb = new StringBuilder();
        for(Integer num : numbers){
            sb.append(num.toString());
        }
       answer = new String(sb);
        if(answer.charAt(0)=='0')return "0";
        return answer;
    }
}