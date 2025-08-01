import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long totalUsed = 0;

        int clusterSize = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int fileSize = Integer.parseInt(st.nextToken());
            if (fileSize == 0) continue;
            totalUsed += ((fileSize + clusterSize - 1) / clusterSize) * clusterSize;
        }

        System.out.println(totalUsed);
    }
}
