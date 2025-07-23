import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N,r,c;
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int line = 1; //한 줄 길이
        for(int i = 0; i<N; i++){
            line*=2;
        }
        //위치
        //1 2
        //3 4
        int ans = 0;
        while(line>=2){
            if(r<line/2&&c<line/2){//1번위치
                if((r-line/2)>=0)r-=line/2;
                if((c-line/2)>=0)r-=line/2;
                line/=2;
            }
            else if(r<line/2&&c>=line/2) {//2번위치
                ans+=(line/2*line/2);
                if((r-line/2)>=0)r-=line/2;
                if((c-line/2)>=0)c-=line/2;
                line/=2;
            }
            else if(r>=line/2&&c<line/2) {//3번위치
                ans+=(line/2*line/2)*2;
                if((r-line/2)>=0)r-=line/2;
                if((c-line/2)>=0)c-=line/2;
                line/=2;
            }
            else if(r>=line/2&&c>=line/2) {//4번위치
                ans+=(line/2*line/2)*3;
                if((r-line/2)>=0)r-=line/2;
                if((c-line/2)>=0)c-=line/2;
                line/=2;
            }
        }

        System.out.println(ans);

    }
}
