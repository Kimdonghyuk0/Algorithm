import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
    public static int[][][] isH = new int[10][10][10]; // 합이 아니면 0, 합이면 1, 외쳤으면 2이상 (1이 없으면 결)
    public static boolean checkH(Card a, Card b, Card c){
        Set<String> Sset = new HashSet<String>();
        Set<String> Cset = new HashSet<String>();
        Set<String> Bset = new HashSet<String>();
        //S 체크
        Sset.add(a.S);
        Sset.add(b.S);
        Sset.add(c.S);
        if(Sset.size()==2)return false;
        //C체크
        Cset.add(a.C);
        Cset.add(b.C);
        Cset.add(c.C);
        if(Cset.size()==2)return false;
        //B체크
        Bset.add(a.B);
        Bset.add(b.B);
        Bset.add(c.B);
        return Bset.size() != 2;
    }
    static class Card {
        String S, C, B;

        public Card(String S, String C, String B) {
            this.S = S;
            this.C = C;
            this.B = B;
        }
    }

    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            int score = 0;
            Card[] cards = new Card[10];
            boolean isG = false;

            for(int i = 1; i<10; i++){
                st = new StringTokenizer(br.readLine());
                cards[i] = new Card(st.nextToken(),st.nextToken(),st.nextToken());
            }
            //합인지 체크
            for(int i = 1; i<10; i++){
                for(int j = i+1; j<10; j++){
                    for(int k = j+1; k<10; k++){
                        if(checkH(cards[i],cards[j],cards[k]))isH[i][j][k] = 1;
                    }
                }
            }
            int n = Integer.parseInt(br.readLine());
            for(int ii = 0; ii<n; ii++){
                boolean flag = true;
                st = new StringTokenizer(br.readLine());
                if(st.nextToken().equals("G")){
                    for(int i = 1; i<10; i++){
                        for(int j = i+1; j<10; j++){
                            for(int k = j+1; k<10; k++){
                                if(isH[i][j][k]==1){
                                    flag = false;
                                    break;
                                }
                            }
                        }
                    }
                    if(flag &&!isG) {
                        score += 3;
                        isG = true;
                    }
                    else score-=1;
                }
                else{
                    int[] arr = new int[3];
                    arr[0] = Integer.parseInt(st.nextToken());
                    arr[1] = Integer.parseInt(st.nextToken());
                    arr[2] = Integer.parseInt(st.nextToken());
                    Arrays.sort(arr);
                    if(isH[arr[0]][arr[1]][arr[2]]==1){
                        score++;
                        isH[arr[0]][arr[1]][arr[2]]++;
                    }
                    else score--;
                }
            }
            System.out.println(score);


          }
}
