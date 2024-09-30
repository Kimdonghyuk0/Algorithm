import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int king = 0;
        int count;
        int maxCount = -1;

        int arr[][] = new int[n][5];
        for (int i = 0; i < n; i++) {
            String input[] = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(input[j]);


            }
        }
        br.close();

        boolean friend[] = new boolean[n + 1];
        
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n + 1; i++) {
                friend[i] = false;
            }

            count = 0;
            //초기화

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < n; j++) {
                    if (j == k) continue;
                    if (arr[j][i] == arr[k][i]) {
                        friend[j] = true;
                    }

                }

            }
            for (int m = 0; m < n + 1; m++) {
                if (friend[m]) count++;
            }

            if (maxCount < count) {
                king = k + 1;
                maxCount = count;
            }
        }

        bw.write(Integer.toString(king));
        bw.flush();
        bw.close();
    }

}