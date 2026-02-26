import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] sosu = new boolean[123456*2+1];

        for(int i = 2; i<=Math.sqrt(123456*2); i++){
            int num = i*i;
            while(num<=123456*2){
                sosu[num] = true;
                num+=i;
            }
        }
        //false면 소수인거임
        while(true){
            int input = Integer.parseInt(br.readLine());
            if(input==0)return;
            int start = input+1;
            int end = input*2;
            int count = 0;
            for(int i = start; i<=end; i++){
                if(!sosu[i])count++;
            }
            System.out.println(count);
        }
    }
}
