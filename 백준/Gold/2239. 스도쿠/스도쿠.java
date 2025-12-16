import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr = new int[9][9];

    private static boolean isRight(int y, int x) {
        int v = arr[y][x];
        if (v == 0) return true; // 아직 안 채운 칸이면 OK

        // 1) 행 검사 (y행에서 v 중복 여부)
        for (int j = 0; j < 9; j++) {
            if (j == x) continue;
            if (arr[y][j] == v) return false;
        }

        // 2) 열 검사 (x열에서 v 중복 여부)
        for (int i = 0; i < 9; i++) {
            if (i == y) continue;
            if (arr[i][x] == v) return false;
        }

        // 3) 3x3 박스 검사
        int sy = (y / 3) * 3;
        int sx = (x / 3) * 3;
        for (int i = sy; i < sy + 3; i++) {
            for (int j = sx; j < sx + 3; j++) {
                if (i == y && j == x) continue;
                if (arr[i][j] == v) return false;
            }
        }

        return true;
    }
    private static boolean dfs(){
        //백트래킹
        // 초기값 세팅
        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                if(arr[i][j]==0){
                    for(int k = 0; k<9; k++){
                        arr[i][j] = k+1;
                        if (isRight(i,j) && dfs()) return true;
                        else arr[i][j] = 0;

                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        // 초기값 세팅
        for(int i = 0; i<9; i++){
            String[] input  = br.readLine().split("");
            for(int j = 0; j<9; j++){
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }
        dfs();
        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                System.out.print( arr[i][j]);

            }
            System.out.println();
        }

    }
}