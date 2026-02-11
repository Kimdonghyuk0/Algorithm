import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        long a = 0,b = 0,c = 0;
        long bestAbs = Long.MAX_VALUE;
        for(int i = 0; i<N-2;  i++){

            int left = i+1;
            int right = N-1;
            while(left<right){
                long sum = arr[left]+arr[right]+arr[i];
                long abs = Math.abs(sum);
                if(abs<bestAbs){
                    a = arr[i];
                    b = arr[left];
                    c = arr[right];
                    bestAbs = abs;
                }
                if(sum==0){
                    System.out.println(a + " " + b + " " + c);
                    return;
                }
                else if(sum>0)right--;
                else left++;

            }

        }
        System.out.println(a + " " + b + " " + c);
    }
}