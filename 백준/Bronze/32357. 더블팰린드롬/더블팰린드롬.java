import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 팰린드롬 개수 구하고 조합으로 2개 뽑기
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i = 0; i<N; i++){
            String input = br.readLine();
            boolean isP = true;
            for (int k = 0; k < input.length() / 2; k++) {
                if (input.charAt(k) != input.charAt(input.length() - 1 - k)) {
                    isP = false;
                    break;
                }
            }

            if (isP) count++;
        }
        System.out.println(count * (count - 1));
    }
}
