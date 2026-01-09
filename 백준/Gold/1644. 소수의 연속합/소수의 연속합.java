import java.io.*;
import java.util.*;

public class Main {
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        boolean[] prime = new boolean[4000001];
        List<Integer> primesList = new LinkedList<>();
        prime[0] = true;
        prime[1] = true;
        for (int i = 2; i * i < 4000001; i++) {
                if (!prime[i]) {
                    for (int j = i * i; j < 4000001; j += i) {
                        prime[j] = true; // i의 배수 제거
                    }
                }
        }
        for(int i = 0; i<prime.length; i++){
            if(!prime[i])primesList.add(i);
        }
        int[] primes = primesList.stream().mapToInt(Integer::intValue).toArray();
        int start = 0;
        int end = 0;
        int ans = 0;
        int sum = 0;
        while(true){

            if (sum >= target) {
                if (sum == target) ans++;
                sum -= primes[end++];      // 먼저 빼고 end 증가
            } else {
                if (start == primes.length) break;
                sum += primes[start++];    // 먼저 더하고 start 증가
            }
        }
        System.out.println(ans);


    }

}
