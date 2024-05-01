

import java.util.Scanner;

class Player{
    int[] card = new int[5];
    int[] max = new int[10]; // 3개 합의 일의자리수 저장

    void cardSet(Scanner scan) {
        for (int i = 0; i < 5; i++) {
            card[i] = scan.nextInt();
        }
    }

    int MaxNum() { // 가장 큰 3개의 일의자리 합 리턴
        int index = 0;
        for (int i = 0; i < card.length - 2; i++) {
            for (int j = i + 1; j < card.length - 1; j++) {
                for (int k = j + 1; k < card.length; k++) {
                    max[index] = (card[i] + card[j] + card[k]) % 10;
                    index++;
                }
            }
        }
        int maxNum = max[0];
        for (int i = 1; i < max.length; i++) {
            if (max[i] > maxNum) {
                maxNum = max[i];
            }
        }
        return maxNum;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] MaxNum = new int[N];
        Player[] player = new Player[N];

        for (int i = 0; i < N; i++) {
            player[i] = new Player();
            player[i].cardSet(scan); // Scanner 객체를 공유
            MaxNum[i] = player[i].MaxNum();
        }

        int max = MaxNum[0];
        int index = 0;
        for (int i = 1; i < MaxNum.length; i++) {
            if (MaxNum[i] >= max) {
                max = MaxNum[i];
                index = i;
            }
        }

        System.out.print(index + 1);
    }
}
