import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        // 빠른 입력을 위한 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 1. 입력 읽기
        int N = Integer.parseInt(br.readLine().trim());
        String A = br.readLine().trim();
        // indoor[i] = true이면 i번 장소는 실내, false이면 실외 (노드는 1~N)
        boolean[] indoor = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            indoor[i] = (A.charAt(i - 1) == '1');
        }
        
        // 트리 구성 – 인접 리스트 (1부터 N까지)
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
        
        // 결과를 담을 변수 (경로의 수; 순서가 있으므로 정답이 매우 클 수 있음)
        long ans = 0;
        
        // 2. 직접 연결된 실내–실내 간선 처리
        // 각 간선는 입력에서 한 번만 주어지므로, 각 간선에 대해 두 노드 모두 실내이면 두 방향 경로가 존재
        for (int i = 1; i <= N; i++) {
            for (int j : graph[i]) {
                if (j > i) { // 한 간선을 한 번만 처리하기 위해 (u,v) with u < v
                    if (indoor[i] && indoor[j]) {
                        ans += 2;  // (i -> j)와 (j -> i)
                    }
                }
            }
        }
        
        // 3. 실외 노드들만 남겨서 연결 컴포넌트(포레스트) 구하기
        // comp[i] = 컴포넌트 번호 (실외 노드만 대상으로; 실내 노드는 0)
        int[] comp = new int[N + 1];
        int compId = 0;
        // BFS를 이용하여 실외 노드들의 연결 컴포넌트를 찾는다.
        for (int i = 1; i <= N; i++) {
            if (!indoor[i] && comp[i] == 0) {
                compId++;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                comp[i] = compId;
                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    for (int nxt : graph[cur]) {
                        if (!indoor[nxt] && comp[nxt] == 0) {
                            comp[nxt] = compId;
                            queue.add(nxt);
                        }
                    }
                }
            }
        }
        
        // 4. 각 실외 컴포넌트와 인접한 실내 노드 집합을 구하기
        // adjIndoor[c] : 컴포넌트 c에 인접한(실외 노드에 붙어있는) 실내 노드들의 집합
        @SuppressWarnings("unchecked")
        HashSet<Integer>[] adjIndoor = new HashSet[compId + 1];
        for (int i = 1; i <= compId; i++) {
            adjIndoor[i] = new HashSet<>();
        }
        // 모든 실외 노드에 대해, 그 노드의 인접 노드 중 실내 노드를 해당 컴포넌트의 집합에 추가
        for (int i = 1; i <= N; i++) {
            if (!indoor[i]) {
                int cid = comp[i];
                for (int nxt : graph[i]) {
                    if (indoor[nxt]) {
                        adjIndoor[cid].add(nxt);
                    }
                }
            }
        }
        
        // 5. 각 실외 컴포넌트에서 인접한 실내 노드 집합 S에 대해, S에 속한 서로 다른 두 실내 노드의 순서쌍 수 = s*(s-1)
        for (int i = 1; i <= compId; i++) {
            int sCount = adjIndoor[i].size();
            ans += (long) sCount * (sCount - 1);
        }
        
        // 6. 결과 출력
        System.out.println(ans);
    }
}
