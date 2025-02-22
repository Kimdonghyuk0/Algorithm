class Solution {
    public int solution(String[][] board, int h, int w) {
        int count = 0;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,1,-1};
        String target = board[h][w];
        for(int i = 0; i<4; i++){
            int y = h+dy[i];
            int x = w+dx[i];
            if(y<0||x<0||y>=board.length||x>=board[h].length)continue;
            if(target.equals(board[y][x]))count++;
        }
        
        return count;
    }
}