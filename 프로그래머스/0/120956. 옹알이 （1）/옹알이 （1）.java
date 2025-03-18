class Solution {
    public int solution(String[] babbling) {
        int sum = 0;
        for(String str : babbling){
            str = str.replaceAll("aya","*");
            str =str.replaceAll("ye","*");
           str = str.replaceAll("woo","*");
            str =str.replaceAll("ma","*");
            System.out.println(str);
            boolean flag = true;
            for(char c:str.toCharArray()){
                if(c!='*')flag = false;
            }
            if(flag)sum++;
        }
        return sum;
    }
}