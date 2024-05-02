import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N, M;
        N = scan.nextInt();
        M = scan.nextInt();
        int B; // B로 시작하는 체스판으로 바꿀때 바꿔야하는 색의 수
        int W; // W로 시작하는 체스판으로 바꿀때 바꿔야하는 색의 수
        int minTrueCount = 10000; // 최소 변경 횟수 초기화
        char[][] chess = new char[N][M]; // 입력받을 체스판

        // 체스판 입력 받기
        for (int i = 0; i < N; i++) {
            String line = scan.next();
            for (int j = 0; j < M; j++) {
                if (line.charAt(j) != ' ') chess[i][j] = line.charAt(j);
            }
        }

        // 가능한 모든 8x8 영역 탐색
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                B = 0;
                W = 0;
                // 8x8 영역에 대해 Bchess와 비교하여 변경 횟수 계산
                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        if ((k + l) % 2 == 0) {
                            if (chess[i + k][j + l] != 'B') B++;
                        } else {
                            if (chess[i + k][j + l] != 'W') B++;
                        }
                    }
                }
                // 8x8 영역에 대해 Wchess와 비교하여 변경 횟수 계산
                for (int k = 0; k < 8; k++) {
                    for (int l = 0; l < 8; l++) {
                        if ((k + l) % 2 == 0) {
                            if (chess[i + k][j + l] != 'W') W++;
                        } else {
                            if (chess[i + k][j + l] != 'B') W++;
                        }
                    }
                }
                // B로 시작하는 체스판으로 변경할 때와 W로 시작하는 체스판으로 변경할 때
                // 변경해야 하는 색의 수 중 작은 값을 선택하여 최소 변경 횟수 갱신
                minTrueCount = Math.min(minTrueCount, Math.min(B, W));
            }
        }

        System.out.println(minTrueCount);
    }
}
