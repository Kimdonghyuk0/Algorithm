import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] colors = new int[2];
    static int[][] square;
    static void findSquare(int startY, int startX, int endY, int endX){
        //전체를 탐색하면서 정사각형인지 무슨색인지 체크
        int color = square[startY][startX];
        boolean isSquare = true;
        for(int i = startY; i<=endY; i++){
            for(int k = startX; k<=endX; k++){
                if(square[i][k]!=color){
                    isSquare = false;
                    break;
                }

            }
            if(!isSquare)break;
        }
        // 정사각형일 경우
        if(isSquare)colors[color]++;
        else{
            findSquare(startY,startX,(startY+endY)/2,(startX+endX)/2);
            findSquare(startY,(endX+startX)/2+1,(startY+endY)/2,endX);
            findSquare((startY+endY)/2+1,startX,endY,(startX+endX)/2);
            findSquare((startY+endY)/2+1,(endX+startX)/2+1,endY,endX);
        }


    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // start,end 넣고 정사각형 아니면 2로 나눠서 재귀
        int N = Integer.parseInt(br.readLine());
        square = new int[N][N];
        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int k = 0; k<N; k++){
                square[i][k] = Integer.parseInt(st.nextToken());

            }

        }
        findSquare(0,0,N-1,N-1);
        System.out.println(colors[0]);
        System.out.println(colors[1]);
    }
}
