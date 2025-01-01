import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[N];
        int freq[] = new int[10];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int MaxCount = 0;
        int count = 0;
        int left = 0;
        int right = 0;
        int v = 0; //종류
        while (right < N) {
            int vc = 0;
            if (v <= 2) freq[arr[right]]++;
            for (int i = 0; i < freq.length; i++) {
                if (freq[i] != 0) vc++;
            }
            v = vc;
            if (v <= 2) {
                count++;
                right++;
            } else {
                if (MaxCount < count) MaxCount = count;
                freq[arr[left]]--;
                left++;
                count = right - left;
            }
        }
        if (MaxCount < count) MaxCount = count;
        System.out.println(MaxCount);
    }
}