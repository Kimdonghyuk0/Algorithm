import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int start = 0;
        int end = n - 1;
        long count = 0;

        while (start < end) {
            int sum = arr[start] + arr[end];

            if (sum < target) {
                start++;
            } else if (sum > target) {
                end--;
            } else {
                if (arr[start] == arr[end]) {
                    long remain = end - start + 1;
                    count += remain * (remain - 1) / 2;
                    break;
                }

                int leftValue = arr[start];
                int rightValue = arr[end];

                long leftCount = 0;
                long rightCount = 0;

                while (start <= end && arr[start] == leftValue) {
                    leftCount++;
                    start++;
                }

                while (start <= end && arr[end] == rightValue) {
                    rightCount++;
                    end--;
                }

                count += leftCount * rightCount;
            }
        }

        System.out.println(count);
    }
}
