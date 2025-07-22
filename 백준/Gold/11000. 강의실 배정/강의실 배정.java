import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
       int N = Integer.parseInt(br.readLine());
       int[][] arr = new int[N][2];
       StringTokenizer st;
       for(int i = 0; i<N; i++){
           st = new StringTokenizer(br.readLine());
           arr[i][0] = Integer.parseInt(st.nextToken());
           arr[i][1] = Integer.parseInt(st.nextToken());
       }
       Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(arr[0][1]);
        for(int i = 1; i<arr.length; i++){
            if(arr[i][0]>=q.peek()){
                q.poll();
                q.add(arr[i][1]);
            }
            else q.add(arr[i][1]);
        }
        System.out.println(q.size());

    }
}
