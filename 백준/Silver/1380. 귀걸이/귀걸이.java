import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int phase = 1;
        while (true) {
            int N = Integer.parseInt(br.readLine());
            String name[] = new String[N];
            int count[] = new int[N + 1];
            if (N == 0) break; //0입력시 종료
            //여학생 이름 입력받기
            for (int i = 0; i < N; i++) {
                name[i] = br.readLine();
            }
            for (int i = 0; i < 2 * N - 1; i++) {
                String input[] = br.readLine().split(" ");
                count[Integer.parseInt(input[0])]++;
            }
            for (int i = 1; i < N + 1; i++) {
                if (count[i] == 1) {
                    System.out.println(phase + " " + name[i - 1]);
                    break;
                }

            }
            phase++;
        }


    }
}
