import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(br.readLine());
        long i = 1;
        int count = 0;
        while (true) {
            if (i * i > n) break;
            i++;
            count++;
        }
        System.out.println(count);
    }


}
