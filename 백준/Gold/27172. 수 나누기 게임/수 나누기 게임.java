import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] playerScore ;
    static int[] playerCard ;
    static boolean[] valid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        playerScore = new int[10000001];
        playerCard = new int[N];
        valid = new boolean[1000001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            playerCard[i] = Integer.parseInt(st.nextToken());
            valid[playerCard[i]] = true;
        }
        for(int n:playerCard){
            int i = 2;
            while(true){
                int val = i*n;
                if(val>1000000)break;
                if(valid[val]){
                    playerScore[n]++;
                    playerScore[val]--;
                }
                i++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int x : playerCard) sb.append(playerScore[x]).append(' ');
        System.out.print(sb.toString());
    }

}
