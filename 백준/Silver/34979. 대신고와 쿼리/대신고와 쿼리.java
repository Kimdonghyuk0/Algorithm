import java.io.*;
import java.util.*;

public class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] dy = {1,-1,0,0};
            int[] dx = {0,0,1,-1};
            int N = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());
            int[][] classes = new int[5][N+1];
            for(int i = 0; i<Q; i++){
                st = new StringTokenizer(br.readLine());
                int p,floor,c = 1; // 명령 층 반
                p = Integer.parseInt(st.nextToken());
                floor = Integer.parseInt(st.nextToken());
                if(st.hasMoreTokens()) c = Integer.parseInt(st.nextToken());
                if(p==1){// 공사
                    classes[floor][c]++;
                    for(int k = 0; k<4; k++){
                        int y,x;
                        y = dy[k]+floor;
                        x = dx[k]+c;
                        if(y>4||y<1||x>N||x<1)continue;
                        classes[y][x]++;
                    }
                }
                else{
                    int max = 0;
                    int cNum = 1;
                    for(int k = 1; k<=N; k++){
                        if(classes[floor][k]>max){
                            max = classes[floor][k];
                            cNum = k;
                        }
                    }
                    System.out.println(cNum);

                }
            }
            int max = 0;
            int ansF = 1;
            int ansC = 1;
            for(int i = 1; i<=4; i++){
                for(int k = 1; k<=N; k++){
                    if(classes[i][k]>max){
                        max = classes[i][k];
                        ansF = i;
                        ansC = k;
                    }
                }
            }
            System.out.println(ansF+" "+ansC);
        }

}
