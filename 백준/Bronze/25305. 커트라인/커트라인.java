import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arr[] = new int[1001];
        int N, k;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int i = 0;
        while (st.hasMoreTokens()) {

            arr[i] = Integer.parseInt(st.nextToken());
            i++;
        }
        Integer[] arr2 = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(arr2, (a, b) -> b - a);
        arr = Arrays.stream(arr2).mapToInt(Integer::intValue).toArray();
        System.out.println(arr[k - 1]);
    }
}

