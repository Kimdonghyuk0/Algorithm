import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int[] square = new int[20];
    static int findNum(int n){
        for(int i = 1; i<20; i++){
            if(n<square[i])return square[i];
        }
        return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ans = new int[n];

        square[0] = 1;
        for(int i = 1; i<20; i++){
            square[i] = square[i-1]*2;
        }
        for(int i = n-1; i>=0; i--){
            if(ans[i]!=0)continue;
            int num = findNum(i+1);
            ans[i] = num-(i+1);
            ans[num-(i+1)-1] = i+1;
        }

        for(int i = 0; i<n; i++){
            System.out.println(ans[i]);
        }

    }
}
