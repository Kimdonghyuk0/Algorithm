import java.io.*;
import java.util.*;

class Main {
    static StringBuilder sb = new StringBuilder();
    static int count = 0;
    static void hanoi(int n, int a, int b, int c) {
        if (n == 1) {
            sb.append(a).append(' ').append(c).append('\n');
            count++;
            return;
        }
        hanoi(n - 1, a, c, b);
        sb.append(a).append(' ').append(c).append('\n');
        count++;
        hanoi(n - 1, b, a, c);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        

        hanoi(N, 1, 2, 3);
        System.out.println(count);
        System.out.print(sb.toString());
    }
}
