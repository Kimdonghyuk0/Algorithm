import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String word = st.nextToken();
            int count = 0;
            if (word.equals("#")) break;
            while (st.hasMoreTokens()) {
                String str = st.nextToken().toLowerCase();
                for (int i = 0; i < str.length(); i++) {
                    if (word.charAt(0) == (str.charAt(i))) {
                        count++;
                    }
                }
            }
            System.out.println(word + " " + count);
        }
    }
}

