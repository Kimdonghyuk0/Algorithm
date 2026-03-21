import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {
        // 그냥 시키는 대로 하면되는 이지한 문제 ㅎ
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int R,C,T;
        int[] dy = {1,-1,0,0};
        int[] dx = {0,0,1,-1};
        int y1 = 0,y2 = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        int[][] arr = new int[R][C];
        int[][] addedDust = new int[R][C];
        boolean flag = true;
        for(int i = 0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int k = 0; k<C; k++){
              arr[i][k] = Integer.parseInt(st.nextToken());
              if(arr[i][k]==-1&&flag){
                  y1 = i;
                  y2 = i+1;
                  flag = false;
              }
            }
        }
        while(T-->0){

            // 미세먼지의 확산
            for(int i = 0; i<R; i++){
                for(int k = 0; k<C; k++){
                    if(arr[i][k]==0)continue;
                    int dust = arr[i][k]/5; //뿌려지는 먼지의 양
                    for(int j = 0; j<4; j++){
                        //상하좌우 체크
                        int ny = i+dy[j];
                        int nx = k+dx[j];
                        if(ny<0||nx<0||ny>=R||nx>=C||arr[ny][nx]==-1)continue;
                        addedDust[ny][nx]+=dust;
                        arr[i][k] -= dust;
                    }
                }

            }
            // 먼지 업데이트
            for(int i = 0; i<R; i++){
                for(int k = 0; k<C; k++){
                    arr[i][k]+=addedDust[i][k];
                }
            }
            // 배열 초기화
            for(int i = 0; i<R; i++){
                for(int k = 0; k<C; k++){
                    addedDust[i][k] = 0;
                }
            }
// ===== 위쪽 공기청정기 (반시계방향) =====
// col 0: ↓
            for (int i = y1 - 1; i >= 1; i--) {
                arr[i][0] = arr[i - 1][0];
            }
// row 0: ←
            for (int i = 0; i < C - 1; i++) {
                arr[0][i] = arr[0][i + 1];
            }
// col C-1: ↑  (C → C-1로 수정)
            for (int i = 0; i < y1; i++) {
                arr[i][C - 1] = arr[i + 1][C - 1];
            }
// row y1: →
            for (int i = C - 1; i >= 2; i--) {
                arr[y1][i] = arr[y1][i - 1];
            }
            arr[y1][1] = 0;  // 깨끗한 공기

// ===== 아래쪽 공기청정기 (시계방향) =====
// col 0: ↑  (i < R → i < R-1로 수정)
            for (int i = y2 + 1; i < R - 1; i++) {
                arr[i][0] = arr[i + 1][0];
            }
// row R-1: ←
            for (int i = 0; i < C - 1; i++) {
                arr[R - 1][i] = arr[R - 1][i + 1];
            }
// col C-1: ↓
            for (int i = R - 1; i > y2; i--) {
                arr[i][C - 1] = arr[i - 1][C - 1];
            }
// row y2: →
            for (int i = C - 1; i >= 2; i--) {
                arr[y2][i] = arr[y2][i - 1];
            }
            arr[y2][1] = 0;  // 깨끗한 공기
        }
        int ans = 0;

        for(int i = 0; i<R; i++){
            for(int k = 0; k<C; k++){
                ans+=arr[i][k];
            }
        }
        System.out.println(ans+2);
    }
}