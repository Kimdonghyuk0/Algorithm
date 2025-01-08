import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N, M;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int t = 0; t < M; t++) {
            st = new StringTokenizer(br.readLine());
            int i, j, k;
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            for (int q = i - 1; q < j; q++) {
                arr[q] = k;
            }
        }
        for (int i : arr) {
            bw.write(Integer.toString(i));
            bw.write(" ");
        }
        bw.flush();

    }


}
