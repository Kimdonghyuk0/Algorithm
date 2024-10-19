import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char c[] = {'a', 'e', 'i', 'o', 'u'};
        String s = br.readLine();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (char a : c) {
                if (s.charAt(i) == a) count++;
            }

        }
        System.out.println(count);
    }


}

