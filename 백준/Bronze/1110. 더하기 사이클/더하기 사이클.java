import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int n = num;
        int count = 0;
        int result;
        while(true){
            count++;
            result = (n%10)+(n/10);

            n = (n%10)*10+(result%10);

            if(n==num)break;
        }
        System.out.println(count);
    }
}
