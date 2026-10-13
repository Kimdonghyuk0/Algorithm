import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();// 숫자, 몇개인지

        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int sum = 0;
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i<arr.length; i++){
            int temp = target-arr[i];
           sum += map.getOrDefault(temp, 0);
            //더한 뒤엔 맵에 추가
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }   
        System.out.println(sum);
    }
}
