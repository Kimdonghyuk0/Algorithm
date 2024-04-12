import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

public class Main {
    public static void main(String[] args) throws Exception { // 메인 함수에 예외를 던지는 구문 추가
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 입력 받기
        String channel;
        Vector<String> vector = new Vector<>();

        for (int i = 0; i < N; i++) {
            channel = br.readLine();
            vector.add(channel);
        }

        for (int i = 0; i < N; i++) {
            if (vector.get(i).equals("KBS1")) {
                vector.remove(i);
                vector.add(0, "KBS1");
                for (int j = 0; j < i; j++) {
                    bw.write("4");
                }
                bw.flush(); // 변경사항을 즉시 출력
                break;
            }
            bw.write("1");
        }

        for (int i = 0; i < N; i++) {
            if (vector.get(i).equals("KBS2")) {
                vector.remove(i);
                vector.add(1, "KBS2");
                for (int j = 0; j < i - 1; j++) {
                    bw.write("4");
                }
                bw.flush(); // 변경사항을 즉시 출력
                break;
            }
            bw.write("1");
        }
        bw.close(); // BufferedWriter 자원 해제
        br.close(); // BufferedReader 자원 해제
    }
}
