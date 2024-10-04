import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        String input[] = br.readLine().split(" ");
        int min = Integer.MAX_VALUE;
        int max;
        int ans = 0;
        for (int i = 0; i < size; i++) {
            int n = Integer.parseInt(input[i]);
            max = n;
            if (n < min) min = n;
            if (ans < max - min) ans = max - min;
            bw.write(ans+" ");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
