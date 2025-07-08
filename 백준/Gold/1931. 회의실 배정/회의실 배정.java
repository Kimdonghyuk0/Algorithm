
import java.io.*;
import java.util.*;



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] rooms = new int[N][2];
        int start,end;
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            rooms[i][0] = start;
            rooms[i][1] = end;
        }
        Arrays.sort(rooms,(a,b)->{
            if(a[1]==b[1])return a[0]-b[0];
            return a[1]-b[1];
        });
        int ans = 1;
        int now = 0;
        int next = 1;
        while(true){
            if(rooms[now][1]<=rooms[next][0]){
                now = next;
                ans++;
            }
            next++;
            if(next>= rooms.length)break;

        }
        System.out.println(ans);
    }
}