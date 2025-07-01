import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String except[] = {"i", "pa", "te", "ni", "niti", "a", "ali", "nego", "no", "ili"};
        String str[] = br.readLine().split(" ");
        for (int i = 0; i < str.length; i++) {
            boolean flag = true;
            // 예외 단어인지 검사
            for (int j = 0; j < except.length; j++) {
                if (str[i].equals(except[j])) {
                    flag = false;
                    break;
                }
            }
            // 첫 번째 단어라면 예외 단어여도 반드시 포함
            if (i == 0) {
                flag = true;
            }
            if (flag) {
                System.out.print(str[i].substring(0, 1).toUpperCase());
            }
        }
    }

}
