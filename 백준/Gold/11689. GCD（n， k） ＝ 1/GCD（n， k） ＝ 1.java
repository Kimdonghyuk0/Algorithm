import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long result = n;
        long temp = n;

        for (long i = 2; i * i <= temp; i++) {
            if (temp % i == 0) {
                result -= result / i;   // result = result * (1 - 1/i)

                while (temp % i == 0) {
                    temp /= i;
                }
            }
        }

        // 마지막에 남은 수가 1보다 크면 그것도 소인수
        if (temp > 1) {
            result -= result / temp;
        }

        System.out.println(result);
    }
}