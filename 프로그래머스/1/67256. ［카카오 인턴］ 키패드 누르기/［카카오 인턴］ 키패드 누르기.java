class Solution {
    public String solution(int[] numbers, String hand) {
        int left = 10;
        int right = 12;
        int leftDif = 0;
        int rightDif = 0;
        int arr[][] = {{0,0},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2},{3,0},{3,1},{3,2}};
        for(int i = 0; i<numbers.length; i++){
            if(numbers[i]==0)numbers[i]=11;
        }
        StringBuilder sb = new StringBuilder();
        for(int num:numbers){
            if(num==1||num==4||num==7){
                sb.append("L");
                left = num;
                continue;
            }
             if(num==3||num==6||num==9){
                sb.append("R");
                right = num;
                continue;
            }
            rightDif = Math.abs(arr[num][0]-arr[right][0])+Math.abs(arr[num][1]-arr[right][1]);
            leftDif =  Math.abs(arr[num][0]-arr[left][0])+Math.abs(arr[num][1]-arr[left][1]);
            if(leftDif==rightDif){
                if(hand.equals("left")){
                    sb.append("L");
                    left = num;
                }
                else {
                    sb.append("R");
                    right = num;
                }
            }
            else if(leftDif<rightDif){
                sb.append("L");
                left = num;
            }
            else{
                sb.append("R");
                right = num;
            }
        }
        return sb.toString();
    }
}