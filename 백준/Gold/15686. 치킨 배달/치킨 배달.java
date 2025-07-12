import java.io.*;
import java.util.*;

public class Main {
    static int M;
    static ArrayList<int[]> home = new ArrayList<>();
    static ArrayList<int[]> chicken = new ArrayList<>();
    static ArrayList<int[]> chickenList = new ArrayList<>();
    static boolean[] visited;
    static int ans = Integer.MAX_VALUE;
    static void dfs(int start, int depth){

        if(depth==M) {
            int sum = 0;
            //해당 조합에 대해 최소 치킨 거리 구하기
            for (int j = 0; j < home.size(); j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < chickenList.size(); k++) {
                    int dis = Math.abs(home.get(j)[0] - chickenList.get(k)[0]) + Math.abs(home.get(j)[1] - chickenList.get(k)[1]);
                    if (dis < min) min = dis;
                }
                sum += min;

            }
            if (sum < ans) ans = sum;
            return;
        }
        for(int i = start; i<chicken.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                chickenList.add(chicken.get(i));
                dfs(i+1,depth+1);
                chickenList.remove(chickenList.size() - 1);
                visited[i] = false;
            }


        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int input;
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                input = Integer.parseInt(st.nextToken());
                if(input==1){

                    home.add(new int[]{i,j});
                }
                else if(input==2){
                    chicken.add(new int[]{i,j});
                }

            }
        }
        visited = new boolean[chicken.size()];
        dfs(0,0);
        System.out.println(ans);

    }
}