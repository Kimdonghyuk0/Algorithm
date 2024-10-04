import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int arr[] = new int[size];
        String input[] = br.readLine().split(" ");
        int min = Integer.MAX_VALUE;
        int max;
        int ans = 0;
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(input[i]);
            max = arr[i];
            if (arr[i] < min) min = arr[i];
            if (ans < max - min) ans = max - min;
            System.out.print(ans + " ");
        }

    }
}
