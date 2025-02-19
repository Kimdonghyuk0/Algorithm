import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Collections.reverseOrder;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        Integer[] numbers = new Integer[Integer.parseInt(N)];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < numbers.length; i++) {

            numbers[i] = Integer.parseInt(st.nextToken());
        }

        String answer;
        Arrays.sort(numbers, (a, b) -> {
            String ab = a.toString() + b.toString();
            String ba = b.toString() + a.toString();
            return ba.compareTo(ab);
        });
        StringBuilder sb = new StringBuilder();
        for (Integer num : numbers) {
            sb.append(num.toString());
        }
        answer = new String(sb);
        if (answer.charAt(0) == '0') {
            System.out.println("0");
            return;
        }
        ;
        System.out.println(answer);
        br.close();

    }
}
