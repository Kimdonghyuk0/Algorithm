import java.io.*;
import java.util.*;


public class Main {
    static int T, x1, y1, r1, x2, y2, r2;

    //always r1<=r2
    private static int solve(int x1, int y1, int r1, int x2, int y2, int r2) {
        //중심이 같은 경우
        if (x1 == x2 & y1 == y2) {
            if (r1 == r2) return -1;//무한
            else return 0;
        }
        //  내접 or 외접 하는 경우
        if ((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) == (r2 - r1) * (r2 - r1) && (r2 - r1) + r1 == r2 || (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1) == (r1 + r2) * (r1 + r2))
            return 1;
        //원안에 원이 있는 경우 or 아예 안겹치는 경우
        if ((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) < r2 * r2 && (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) < (r2 - r1) * (r2 - r1) || (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1) > (r1 + r2) * (r1 + r2))
            return 0;
        return 2;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        int ans;

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            r1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());
            if (r1 > r2) ans = solve(x2, y2, r2, x1, y1, r1);
            else ans = solve(x1, y1, r1, x2, y2, r2);
            System.out.println(ans);
        }
        br.close();

    }


}
