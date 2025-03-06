class Solution {
    public String solution(String myString) {
        myString = myString.toLowerCase();
        System.out.println(myString);
        myString = myString.replace('a','A');
        return myString;
    }
}