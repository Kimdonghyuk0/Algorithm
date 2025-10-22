import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] twoPointer = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()) ;
        for(int i = 0; i<N; i++){
            twoPointer[i] = Integer.parseInt(st.nextToken());
        }
        int left,right,close;
        left = 0;
        right = N-1;
        close = Integer.MAX_VALUE;
        int[] ans = new int[2];
        while(left<right){
            int temp = twoPointer[left]+twoPointer[right];
            if (Math.abs(temp)<=Math.abs(close)){
                close = temp;
                ans[0] = twoPointer[left];
                ans[1] = twoPointer[right];
            }
            if(temp>0)right--;
            else if(temp<0)left++;
            else break;
        }
        System.out.println(ans[0]+" "+ans[1]);

    }
}