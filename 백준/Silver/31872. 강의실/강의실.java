import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N,K;
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int[] dif = new int[N];
        dif[0] = arr[0];
        for(int i = 1; i<N; i++){
            dif[i] = arr[i]-arr[i-1];
        }
        int ans = 0;
        Arrays.sort(dif);
        for(int i = 0; i<N-K; i++){
            ans+=dif[i];
        }
System.out.println(ans);
    }
}
