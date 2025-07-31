import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String,Integer> map = new TreeMap<>();
        int sum = 0;
        while(true){
            String input = br.readLine();
            if (input == null || input.isEmpty()) break;
            if(map.containsKey(input))map.put(input,map.getOrDefault(input,0)+1);
            else map.put(input,1);
            sum++;
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int count = entry.getValue();
            double ratio = (double) count / sum * 100;
            System.out.printf("%s %.4f%n", key, ratio);
        }
    }
}
    