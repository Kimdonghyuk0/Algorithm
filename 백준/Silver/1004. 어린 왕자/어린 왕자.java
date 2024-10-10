import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

class Start {
    int x;
    int y;

    public Start(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

class End {
    int x;
    int y;

    public End(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

class Circle {
    int x;
    int y;
    int r;

    public Circle(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

}

public class Main {
    private static boolean checkIn(Start s, End e, Circle c) {
        int sD = 0;
        int eD = 0;
        sD = (s.x - c.x) * (s.x - c.x) + (s.y - c.y) * (s.y - c.y);
        eD = (e.x - c.x) * (e.x - c.x) + (e.y - c.y) * (e.y - c.y);
        if (sD <= c.r * c.r && eD > c.r * c.r || eD <= c.r * c.r && sD > c.r * c.r) return true;
        else return false;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int x1, x2, y1, y2;
        while (T-- > 0) {
            int count = 0;
            String input[] = br.readLine().split(" ");
            x1 = Integer.parseInt(input[0]);
            y1 = Integer.parseInt(input[1]);
            x2 = Integer.parseInt(input[2]);
            y2 = Integer.parseInt(input[3]);
            Start s = new Start(x1, y1);
            End e = new End(x2, y2);
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                input = br.readLine().split(" ");
                int cx = Integer.parseInt(input[0]);
                int cy = Integer.parseInt(input[1]);
                int r = Integer.parseInt(input[2]);
                Circle c = new Circle(cx, cy, r);
                if (checkIn(s, e, c)) count++;
            }
            System.out.println(count);

        }
    }


}
