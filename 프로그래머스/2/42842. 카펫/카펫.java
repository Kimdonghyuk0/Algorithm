class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for(int h = 1; h<Integer.MAX_VALUE; h++){
            for(int w = 1; w<=h; w++){
                if((w-2)*(h-2) == yellow&&w+h == brown/2+2){
                    answer[0] = h;
                    answer[1] = w;
                    return answer;
                }
            }
        }        
    
        return answer;
    }
}

// 2w+2h-4 가 테두리 갈색 개수 w+h = 14
// (w-2)(h-2) 가 노란색 개수
// (w-2)(h-2) = yellow,w+h = brown/2+2 를 만족시키는 쌍 찾기 가로가 더 길거나 같음