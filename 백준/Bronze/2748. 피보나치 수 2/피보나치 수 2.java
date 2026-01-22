import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            long[] fibo = new long[91];
            fibo[0] = 0;
            fibo[1] = 1;
            for(int i = 2; i<fibo.length; i++){
                fibo[i] = fibo[i-1]+fibo[i-2];
            }
            int N = Integer.parseInt(br.readLine());
            System.out.println(fibo[N]);

        }

}
