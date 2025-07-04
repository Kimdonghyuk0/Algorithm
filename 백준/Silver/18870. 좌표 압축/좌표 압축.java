import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Set<Integer> set = new TreeSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            set.add(arr[i]);
        }
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int k = 0;
        for(int i : set){
            map.put(i,k);
            k++;
        }

        int temp;
        for (int j : arr) {
            temp = map.get(j);
            bw.write(String.valueOf(temp) + " ");
        }
        bw.flush();
    }
}