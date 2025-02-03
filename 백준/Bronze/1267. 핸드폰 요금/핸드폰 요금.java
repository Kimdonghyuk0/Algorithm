import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int y = 0; //원
        int m = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            y += (input / 30 + 1) * 10;
            m += (input / 60 + 1) * 15;
        }
        if (y > m) System.out.println("M " + m);
        if (y < m) System.out.println("Y " + y);
        if (y == m) System.out.println("Y M " + m);

    }


}
