import java.util.*;

class Solution {
    public int operator(int A,int B,String op){
        if(op.equals("+"))return A+B;
        else return A-B;
    }
    public String[] solution(String[] quiz) {
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i<quiz.length; i++){
            StringTokenizer st = new StringTokenizer(quiz[i]);
            int A = Integer.parseInt(st.nextToken());
            String op = st.nextToken();
            int B = Integer.parseInt(st.nextToken());
            String eq = st.nextToken();
            int result = Integer.parseInt(st.nextToken());
            if(operator(A,B,op)==result)list.add("O");
            else list.add("X");
        }
        return list.toArray(new String[0]);
    }
}