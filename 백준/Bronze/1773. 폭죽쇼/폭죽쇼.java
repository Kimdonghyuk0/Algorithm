import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] period = new int[n];
        for(int i = 0; i<n; i++){
            period[i] = Integer.parseInt(br.readLine()  );
        }
        boolean[] time = new boolean[c+1];
        for(int i = 1; i<c+1; i++){
            for(int k = 0; k<n; k++){
                if (i % period[k] == 0) {
                    time[i] = true;
                    break;
                }
            }
        }
        int ans = 0;
        for(boolean flag:time){
            if(flag)ans++;
        }
        System.out.println(ans);

    }
}