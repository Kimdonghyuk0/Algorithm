import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        while (true) {
            String number = Integer.toString(n);
            for (int i = 0; i < number.length(); i++) {
                if (number.charAt(i) != '7' && number.charAt(i) != '4') break;
                if (i == number.length() - 1) {
                    bw.write(number);
                    bw.flush();
                    bw.close();
                    br.close();
                    System.exit(0);
                }
            }
            n--;
        }

    }
}

