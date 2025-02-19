class Solution {
    public String solution(String s, String skip, int index) {
      
        //97~122   123으로 나누기
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            int asc = c;
            int k = 0;
            while(k<index){
                asc++;
                if(asc>=123)asc = 97+asc%123;
                boolean flag = true;
                for(int j = 0; j<skip.length(); j++){
                    char change = (char)asc;
                    if(change==skip.charAt(j)){
                        flag = false;
                        break;
                    }
                    
                }  
                 if(flag)k++;
            }
             char fin;
                fin = (char)asc;
                sb.append(fin);  
        }
        
        return sb.toString();
    }
}