import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, M;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int h = 0;
        int left = 0;
        int right = 1000000000;
        while (left < right) {
            h = (left + right) / 2;
            long sum = 0;
            for (int i = 0; i < N; i++) {
                if (h < arr[i]) sum += arr[i] - h;
            }

            if (sum < M) right = h;
            else left = h + 1;
        }
        System.out.println(left - 1);

    }


}
