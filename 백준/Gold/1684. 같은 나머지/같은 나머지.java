import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int gcd(int a, int b){
        if(b==0)return a;
        return gcd(b,a%b);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 차이의 최대 공약수를 구하면 된다.
        int N = Integer.parseInt(br.readLine());
        if(N==1){
            System.out.println(br.readLine());
            return;
        }

        int[] dif = new int[N-1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int now = Integer.parseInt(st.nextToken());
        int ii = 0;
        while(st.hasMoreTokens()){
            int next = Integer.parseInt(st.nextToken());
            dif[ii] = Math.abs(now-next);
            now = next;
            ii++;
        }
        // dif 배열의 최대공약수가 정답
        int num = dif[0];
        for(int i = 1; i< dif.length; i++){
            num = gcd(num,dif[i]);

        }
        System.out.println(num);
    }


}
