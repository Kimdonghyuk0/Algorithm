import java.io.*;
import java.util.*;


public class Main {
    static int[][] canReach;
    static int ans;
    static int N;
    static void dfs(int row, int depth){
        if(depth==N){
            ans++;
            return;
        }

        for(int col = 0; col < N; col++){
            if(canReach[row][col] == 0){
                onQueen(row, col);
                dfs(row + 1, depth + 1);  // 다음 행으로만 이동
                offQueen(row, col);
            }
        }

    }
    static void onQueen(int y,int x){
        //퀸을 올렸을때 canReach
        canReach[y][x]+=1;
        //세로
        for(int i = 0; i<N; i++){
            if(i==y)continue;
            canReach[i][x]+=1;
        }
        //가로
        for(int i = 0; i<N; i++){
            if(i==x)continue;
            canReach[y][i]+=1;
        }
        // /대각선
        for(int i = 1; i<N; i++){
            int ny,nx;
            ny = y-i;
            nx = x+i;
            if(ny>=N||nx>=N||ny<0||nx<0)continue;
            canReach[ny][nx]+=1;
        }
        for(int i = 1; i<N; i++){
            int ny,nx;
            ny = y+i;
            nx = x-i;
            if(ny>=N||nx>=N||ny<0||nx<0)continue;
            canReach[ny][nx]+=1;
        }

        // \대각선
        for(int i = 1; i<N; i++){
            int ny,nx;
            ny = y-i;
            nx = x-i;
            if(ny>=N||nx>=N||ny<0||nx<0)continue;
            canReach[ny][nx]+=1;
        }
        for(int i = 1; i<N; i++){
            int ny,nx;
            ny = y+i;
            nx = x+i;
            if(ny>=N||nx>=N||ny<0||nx<0)continue;
            canReach[ny][nx]+=1;
        }
    }


    static void offQueen(int y,int x){
        //퀸을 내렸을때 canReach
        canReach[y][x]-=1;
        //세로
        for(int i = 0; i<N; i++){
            if(i==y)continue;
            canReach[i][x]-=1;
        }
        //가로
        for(int i = 0; i<N; i++){
            if(i==x)continue;
            canReach[y][i]-=1;
        }
        // /대각선
        for(int i = 1; i<N; i++){
            int ny,nx;
            ny = y-i;
            nx = x+i;
            if(ny>=N||nx>=N||ny<0||nx<0)continue;
            canReach[ny][nx]-=1;
        }
        for(int i = 1; i<N; i++){
            int ny,nx;
            ny = y+i;
            nx = x-i;
            if(ny>=N||nx>=N||ny<0||nx<0)continue;
            canReach[ny][nx]-=1;
        }

        // \대각선
        for(int i = 1; i<N; i++){
            int ny,nx;
            ny = y-i;
            nx = x-i;
            if(ny>=N||nx>=N||ny<0||nx<0)continue;
            canReach[ny][nx]-=1;
        }
        for(int i = 1; i<N; i++){
            int ny,nx;
            ny = y+i;
            nx = x+i;
            if(ny>=N||nx>=N||ny<0||nx<0)continue;
            canReach[ny][nx]-=1;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //백트래킹
        N = Integer.parseInt(br.readLine());
        ans = 0;
        canReach = new int[N][N]; // 해당 인덱스의 값이 0이면 퀸을 둘 수 있음
        dfs(0,0);


        System.out.println(ans);

    }
}