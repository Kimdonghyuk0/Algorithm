import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 그냥 두포인터 문제임
        int N = Integer.parseInt(br.readLine());
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int left = 0,right = 0;
        int[] ctn = new int[11];

        ctn[num[left]]++;
        int maxLen = 1;


        while(right<N){

            int min = 0,max = 0;
            for(int i = 1; i<=10; i++){
                if(ctn[i]>=1){
                    min = i;
                    break;
                }
            }
            for(int i = 10; i>=1; i--){
                if(ctn[i]>=1){
                    max = i;
                    break;
                }
            }

            if(max-min<=2){
                int nowLen = right-left+1;
                if(maxLen<nowLen)maxLen = nowLen;
                right++;
                if(right<N)ctn[num[right]]++;
            }
            else {
                ctn[num[left]]--;
                left++;

                if(left==right){
                    right++;
                    if(right<N)ctn[num[right]]++;
                }
            }

        }
        System.out.println(maxLen);

    }
}