import java.io.*;
import java.util.*;

public class Main {
    static int V,M;
    static int j,s;
    static int[][] dist;
    static ArrayList<Integer> ans = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[V+1][V+1];
        //dist 초기화
        for(int i = 0; i< dist.length; i++){
            for(int j = 0; j<dist[i].length; j++){
                if(j==i)dist[i][j] = 0;
                else dist[i][j] = 100_000_001;
            }
        }

        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a,b,cost;
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            dist[a][b] = Math.min(dist[a][b], cost);
            dist[b][a] = Math.min(dist[b][a], cost);
        }
        st = new StringTokenizer(br.readLine());
        j = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        for(int k = 1; k<V+1; k++){ //k 정점을 중간에 거치는 경우
            for(int i = 1; i<V+1; i++){
                for(int j = 1; j<V+1; j++){
                    dist[i][j] = Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 1; i<V+1; i++){ //각 정점 검사
            if(i==s||i==j)continue;
            int jdis = dist[j][i]; //지헌이가 걸리는 시간
            int sdis = dist[s][i]; //성하가 걸리는 시간
            if (jdis > 100_000_000 || sdis > 100_000_000) continue;
            if(jdis+sdis<=min){
                if(jdis+sdis==min){
                    ans.add(i);
                }
                else{
                    min = jdis+sdis;
                    ans.clear();
                    ans.add(i);
                }
            }

        }
        for (int i = ans.size() - 1; i >= 0; i--) {
            int place = ans.get(i);
            int jdis = dist[j][place];
            int sdis = dist[s][place];
            if (jdis > sdis) ans.remove(i);  // 뒤에서부터 제거 해야 리스트 밀리는거 방지가능
        }
        Collections.sort(ans,(a,b)->{
            if(dist[a][j]==dist[b][j])return a-b;
            else return dist[a][j]-dist[b][j];
        });

        if(ans.isEmpty())System.out.println("-1");
        else System.out.println(ans.get(0));

    }
}