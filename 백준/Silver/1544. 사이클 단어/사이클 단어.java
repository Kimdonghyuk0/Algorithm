import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;


public class Main {
    public static boolean checkSame(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str1);

        for (int i = 0; i < str1.length(); i++) {
            if (str2.equals(sb.toString())) return true;
            char first = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(first);

        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        Vector<String> v = new Vector<String>();
        String str;

        for (int k = 0; k < N; k++) {
            str = br.readLine();
            if (v.size() == 0) {
                v.add(str);
                count++;
            } else {
                for (int i = 0; i < v.size(); i++) {
                    if (checkSame(str, v.get(i))) {
                        break;
                    } else if (i == v.size() - 1) {
                        count++;
                        v.add(str);
                    }
                }
            }
        }
        System.out.println(count);

    }
}
