import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i<N; i++){
            String[] input  = br.readLine().split(" ");
            sb.append(Integer.parseInt(input[0])+Integer.parseInt(input[1])).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

}
