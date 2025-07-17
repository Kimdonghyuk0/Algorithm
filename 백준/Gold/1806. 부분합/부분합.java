import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0;
        int right = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        while(true){
            if(sum>=S){
                sum-=nums[left];
                ans = Math.min(ans,right-left);
                left++;
            }
            else if (right == N)         // ← 이 시점에 sum>=S 인 경우도 무시하고 무조건 탈출
                break;
            else{
                sum+=nums[right++];
            }
        }
        if(ans==Integer.MAX_VALUE)ans = 0;
        System.out.println(ans);
    }

}