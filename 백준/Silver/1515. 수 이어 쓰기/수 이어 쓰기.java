import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Collections.reverseOrder;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        Deque<Character> q = new ArrayDeque<>();
        for (int i = 0; i < N.length(); i++) {
            q.add(N.charAt(i));
        }
        int ans = 0;
        while (!q.isEmpty()) {
            ans++;
            String number = Integer.toString(ans);
            for (int i = 0; i < number.length(); i++) {
                char n = number.charAt(i);
                if (q.isEmpty()) break;
                if (q.peek() == n) {
                    q.poll();
                }

            }
        }
        System.out.print(ans);
        br.close();

    }
}
