

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n, m;
        int[] costN;
        int[] costM;

        n = scan.nextInt();
        m = scan.nextInt();
        costN = new int[n];
        costM = new int[m];
        int[] vote = new int[n];
        for (int i = 0; i < n; i++) {
            costN[i] = scan.nextInt();
        }

        for (int i = 0; i < m; i++) {
            costM[i] = scan.nextInt();
        }
        for (int i = 0; i < vote.length; i++) {
            vote[i] = 0;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (costM[i] >= costN[j]) {
                    vote[j]++;
                    break;
                }
                
            }
        }

        int max = vote[0];
        int index = 0;
        for (int i = 1; i < vote.length; i++) {
            if (vote[i] > max) {
                max = vote[i];
                index = i;
            }
        }
        System.out.println(index+1);
    }
}