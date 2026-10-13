import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();

        int max = 0;
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String input = br.readLine();

            int num = map.getOrDefault(input, 0) + 1;
            map.put(input, num);

            max = Math.max(num, max);
        }

        System.out.println(max);
    }
}