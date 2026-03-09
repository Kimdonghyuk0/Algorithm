import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 과장된 이야기 최댓값
        // 진실을 아는 사람이 있으면 진실만 말함 즉 진실을 모르는 사람끼리만 계속 매친되면 늘 과장, 진실을 말하는 파티와 거짓 말하는 파티 둘다 가는 사람은 카운트 X
        // 즉 진실을 아는 사람이 없고, 진실을 아는 사람이 있는 파티에 간 사람이 없는 사람들끼리만 있는 파티의 수를 구하는 것
        // 전체에서 진실을 말하는 파티랑 거짓말 쟁이가 되는 경우를 빼면 될듯
        // 각 사람마다 진실/과장 속성을 저장하고
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());//사람의 수
        int M = Integer.parseInt(st.nextToken());//파티의 수
        boolean[] isKnow = new boolean[M+1];
        Queue<ArrayList<Integer>> q = new ArrayDeque<>();
        ArrayList<Integer>[] party = new ArrayList[M+1]; //0번째 파티에 있는사람들은 모든걸 아는사람들임
        for(int i = 0; i<M+1; i++){
            party[i] = new ArrayList<>();
        }
        //아는사람 수와 번호 0번째 파티에 있는사람들은 모든걸 아는사람들임
        st = new StringTokenizer(br.readLine());
        int trueN = Integer.parseInt(st.nextToken());
        for(int i = 0; i<trueN; i++){
            isKnow[0] = true;
            party[0].add(Integer.parseInt(st.nextToken()));
        }
        q.add(party[0]);
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            trueN = Integer.parseInt(st.nextToken());
            for(int ii = 0; ii<trueN; ii++){
                party[i+1].add(Integer.parseInt(st.nextToken()));
            }
        }
        while(!q.isEmpty()){
            // 전체 파티를 돌면서 같은 참가자가 있는 파티는 큐에 추가 한다. (isKnow가 false파티만)
            ArrayList<Integer> now = q.poll();

            for(int i = 1; i<M+1; i++){
                if(isKnow[i])continue;
                for(int person:party[i]){
                    // now안에 해당 사람이 있으면 i번째 파티도 큐에 추가
                    for(int k = 0; k<now.size(); k++){
                        if(now.get(k)==person){
                            q.add(party[i]);
                            isKnow[i] = true;
                            break;
                        }
                    }
                }
            }

        }

        int count = 0;
        for(int i = 1; i <= M; i++){
            if(!isKnow[i]) count++;
        }
        System.out.println(count);
    }
}