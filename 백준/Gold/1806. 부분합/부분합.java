import org.w3c.dom.Node;

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
        int left = 1;
        int right = N;
        int ans = 0;
        while(left<=right){
            boolean flag = false;
            int mid = (left+right)/2;
            int sum = 0;
            for(int i = 0; i<mid; i++ ){
                sum+=nums[i]; // 초기 세팅
            }
            if(sum>=S){
                right = mid-1;
                ans = mid;
                continue;
            }
            for(int i = 1; i<N-mid+1; i++ ){
                sum-=nums[i-1];
                sum+=nums[i+mid-1];
                if(sum>=S){
                    flag = true;
                    right = mid-1;
                    ans = mid;
                    break;
                }
            }
            if(!flag)left = mid+1;

        }

        System.out.println(ans);
    }

}