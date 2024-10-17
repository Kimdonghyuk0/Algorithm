import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long x, y;

        String str[] = br.readLine().split(" ");
        x = Integer.parseInt(str[0]);
        y = Integer.parseInt(str[1]);
        long winP = (y * 100) / x;
        long low, mid, high;
        high = 1000000000;
        low = 0;

        while (low <= high) {
            mid = (low + high) / 2;
            if (((y + mid) * 100 / (x + mid)) == winP) {
                low = mid + 1;
            } else if ((y + mid) * 100 / (x + mid) > winP && ((y + mid - 1) * 100 / (x + mid - 1) == winP)) {
                System.out.println(mid);
                System.exit(0);
            } else {
                high = mid - 1;
            }
        }

        System.out.println("-1");


    }


}

