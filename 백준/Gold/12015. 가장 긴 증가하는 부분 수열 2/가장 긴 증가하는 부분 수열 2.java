import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] seq = new int[N];
        int[] temp = new int[N];
        int len = 0;
        for(int i = 0; i<N; i++){
            seq[i] = Integer.parseInt(st.nextToken());
        }
        for(int n: seq){
            int left,right;
            left = 0; right = len;
            while(left<right){
                int mid = (left+right)/2;
                if(temp[mid]<n)left = mid+1;
                else right = mid;
            }
            temp[left] = n;
            if(len == left)len++;

        }
        System.out.println(len);
    }
}