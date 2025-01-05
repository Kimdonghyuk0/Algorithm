import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, M;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int arr[] = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Integer.parseInt(st.nextToken());
            arr[i] = sum;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            //k부터 j까지의 수
            int k = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;
            if (k == 0) System.out.println(arr[j]);
            else System.out.println(arr[j] - arr[k - 1]);

        }

    }


}
