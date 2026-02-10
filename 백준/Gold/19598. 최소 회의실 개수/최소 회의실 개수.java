import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        //끝나는 시각 기준 정렬 한 뒤 우선순위큐에 삽입, 우선순위큐의 크기가 정답입
        int[][] rooms = new int[N][2];
        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int s,e;
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            rooms[i][0] = s;
            rooms[i][1] = e;
        }
        // 끝나는 시각 기준 정렬
        Arrays.sort(rooms, (a, b) -> {
            if (a[0] == b[0])
                return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        // 큐에 넣기

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 0; i<N; i++){
            if(q.isEmpty()){
                q.add(rooms[i][1]);
                continue;
            }
            int endT = q.peek()!=null?q.peek():0;
            int startT = rooms[i][0];
            if(startT>=endT){
                q.poll();
                q.add(rooms[i][1]);
            }
            else{
                q.add(rooms[i][1]);
            }
        }

        System.out.println(q.size());
    }
}