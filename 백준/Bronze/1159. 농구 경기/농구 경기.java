import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<Character, Integer> map = new TreeMap<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (!map.containsKey(str.charAt(0))) {
                map.put(str.charAt(0), 1);
            } else map.put(str.charAt(0), map.get(str.charAt(0)) + 1);
        }
        boolean flag = false;
        for (Character key : map.keySet()) {
            if (map.get(key) >= 5) {
                flag = true;
                System.out.print(key);
            }
        }
        if (!flag) System.out.print("PREDAJA");
    }
}

