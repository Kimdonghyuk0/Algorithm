class Solution {
    public String solution(String my_string, String alp) {
        String answer = "";
        int a = 'a';
        int b = 'A';
         char alpC = alp.charAt(0);
        System.out.println("a:"+a+"A:"+b);//32빼기
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<my_string.length(); i++){
            char c = my_string.charAt(i);
            if(alpC==c){
                c =(char)( c-32);
            }
            sb.append(c);
        }
        return sb.toString();
    }
}