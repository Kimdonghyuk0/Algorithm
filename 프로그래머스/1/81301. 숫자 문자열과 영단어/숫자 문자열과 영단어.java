class Solution {
    public int solution(String s) {
        String[] numbers = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)-'0'<10){
                answer.append(s.charAt(i));
            }
            else{
                sb.append(s.charAt(i));
                for(int k = 0; k<10; k++){
                    if(numbers[k].equals(sb.toString())){
                        sb.setLength(0);
                        answer.append(Integer.toString(k));
                        break;
                    }
                }
            }

        }
        return Integer.parseInt(answer.toString());
    }
}