import java.io.*;
import java.nio.Buffer;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        while (st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken());
            if (n > 0) count++;
        }
        System.out.println(count);
    }


}
