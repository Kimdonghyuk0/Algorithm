class Solution {
    public String solution(String[] str_list, String ex) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<str_list.length; i++){
            String str = str_list[i];
            if(str.contains(ex))continue;
            sb.append(str);
        }
        answer = sb.toString();
        return answer;
    }
}