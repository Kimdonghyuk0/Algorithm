import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        String input[] = br.readLine().split(" ");
        int min = Integer.MAX_VALUE;
        int max;
        int ans = 0;
        for (int i = 0; i < size; i++) {
           
            max = Integer.parseInt(input[i]);
            if (Integer.parseInt(input[i]) < min) min = Integer.parseInt(input[i]);;
            if (ans < max - min) ans = max - min;
            System.out.print(ans + " ");
        }

    }
}
