import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str[] = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        int cur = 1;
        int dis = 0;
        int j = Integer.parseInt(br.readLine());
        for (int i = 0; i < j; i++) {
            int apple = Integer.parseInt(br.readLine());
            if (cur <= apple && apple <= cur + M - 1) continue; //움직일 필요가 없음
            if (cur < apple) {
                dis += apple - cur - (M - 1);
                cur = apple - (M - 1);
            } else {
                dis += cur - apple;
                cur = apple;
            }
        }
        bw.write(dis + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}

