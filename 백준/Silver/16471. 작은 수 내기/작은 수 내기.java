import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 주안이 먼저
        int[] ju = new int[N];
        int[] sa = new int[N];
        int count = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++ ){
            ju[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++ ){
            sa[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ju);
        Arrays.sort(sa);
        int last = N-1;
        int i = N-1;
        while(last>=0){
            if(ju[last]<sa[i]){
                count++;
                i--;
            }
            last--;
        }



        if(count>=(N+1)/2)System.out.println("YES");
        else System.out.println("NO");

    }

}
