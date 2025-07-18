import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int[] inc = new int[N];
        int[] dec = new int[N];
        Arrays.fill(inc,1);
        Arrays.fill(dec,1);
        for(int i = 0; i<N; i++){ //i로 끝나는 증가수열
            for(int j = 0; j<i; j++){
                if(nums[j]<nums[i])inc[i] = Math.max(inc[i],inc[j]+1);
            }
        }
        for(int i = N-1; i>=0; i--){ //i로 끝나는 감소수열
            for(int j = N-1; j>=i; j--){
                if(nums[j]<nums[i])dec[i] = Math.max(dec[i],dec[j]+1);
            }
        }
        int max = 0;
        for(int i = 0; i<N; i++){
            max = Math.max(max,inc[i]+dec[i]-1);
        }
        System.out.println(max);
      }

}