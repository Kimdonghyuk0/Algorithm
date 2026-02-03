import java.io.*;
import java.util.*;

public class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = 0;
            //H세로 W가로
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            // 한 라인에 2개 블록 이상 있어갸 고일 수 있음 블록만나고 빈공간 카운트하고 블록 만나면 적용하는 방식으로 구현
            boolean[][] blocks = new boolean[H][W];
            st = new StringTokenizer(br.readLine() );
            for(int i = 0; i<W; i++){
                int num = Integer.parseInt(st.nextToken());
                for(int k = num-1; k>=0; k--){
                    blocks[k][i] = true;
                }
            }
            // 개수 세기
            for(boolean[]arr:blocks){
                int tempCount = 0;
                boolean prevHasBlock = false;
                for(boolean isBlock:arr){
                    if(prevHasBlock&&!isBlock){
                        tempCount++;
                    }
                    if(isBlock){
                        prevHasBlock = true;
                        count+=tempCount;
                        tempCount = 0;
                    }

                }
            }

            System.out.println(count);
        }

}
