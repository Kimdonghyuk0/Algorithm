import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;


public class Main {
    public static int check(String s) {
        int count = 0;
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '.') n++;
            if (s.charAt(i) == 'X' || i == s.length() - 1) {
                if (n >= 2) count++;
                n = 0;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int xCount = 0;
        int yCount = 0;
        char room[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            xCount += check(s);

            for (int j = 0; j < n; j++) {
                room[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            String s = "";
            for (int j = 0; j < n; j++) {
                s += room[j][i];
            }
            yCount += check(s);
        }

        System.out.println(xCount + " " + yCount);

    }


}

