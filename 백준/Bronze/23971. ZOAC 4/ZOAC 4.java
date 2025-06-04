import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H,W,N,M,width,height;
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        width = 1;
        height = 1;
        int people = 0;
        for(int i = 0; i<W; i++){
            if(people+M < i){
                people = i;
                width++;
            }
        }

        people = 0;
        for(int i = 0; i<H; i++){
            if(people+N < i){
                people = i;
                height++;
            }
        }
        System.out.println(height*width);

    }



}
