import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n,k;
            int ans = -1;
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            if(n==1){
                System.out.println("0");
                return;
            }
            int[] dif = new int[n-1];
            st = new StringTokenizer(br.readLine());

            int prev = Integer.parseInt(st.nextToken());
            for(int i = 0; i<n-1; i++ ){
                int next = Integer.parseInt(st.nextToken());
                int d = Math.abs(next-prev);
                prev = next;
                dif[i] = d;
            }
            int left = 0;
            int right = 1000000000;


            while(left<=right){
                int mid = (left+right)/2;
                boolean isLinked = false;
                int count = 0;
                for(int num: dif){
                    if(num>mid){
                        if(isLinked){
                            count++;
                        }
                        else {
                            count+=2;
                        }
                        isLinked = true;
                    }
                    else isLinked = false;
                }
                if(count<=k){
                    ans = mid;
                    right = mid-1;
                }
                else left = mid+1;
            }
            System.out.println(ans);


        }

}
