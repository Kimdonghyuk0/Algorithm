import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        long a = Integer.parseInt(input[0]);
        long b = Integer.parseInt(input[1]);
        long result = (a + b) * (a - b);
        System.out.println(result);
    }
}
