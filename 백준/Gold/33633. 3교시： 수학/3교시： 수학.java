import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 수열을 역순으로 생각
        int N = Integer.parseInt(br.readLine());
        ArrayList<Long>[] list = new ArrayList[N+1];
        for(int i = 0; i<N+1; i++){
            list[i] = new ArrayList<>();
        }
        
        if (N == 1) {
            System.out.println(1);
            System.out.println(1);
            return;
        }
        int now = 1;
        list[1].add(1L);
        while(true){
            HashSet<Long> nextSet = new HashSet<>();

            for (long n : list[now]) {
                long a = n * 2;
                if (a != 1) nextSet.add(a);
                if ((n - 1) % 3 == 0) {
                    long prev = (n - 1) / 3;
                    if (prev >= 1 && (prev % 2 == 1) && prev != 1) {
                        nextSet.add(prev);
                    }
                }
            }
            
            list[now + 1].addAll(nextSet);

            now++;
            if (N == now) break;
        }
        //정렬
        Collections.sort(list[N]);
        System.out.println(list[N].size());
        for(long n:list[N])System.out.println(n);


    }
}
