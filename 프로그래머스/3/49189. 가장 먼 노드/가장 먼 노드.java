import java.util.*;
class Solution {
    int max = 0;
    int[] dist; // 1번 노드부터 거리
    List<Integer>[] graph;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        dist = new int[n+1];
        graph = new List[n+1];
        for(int i = 0; i<n+1; i++){
            graph[i] = new ArrayList<>();
        }// 그래프 초기화
        Arrays.fill(dist,-1);
        //그래프 값 할당
        for(int i = 0; i<edge.length; i++){
            int start = edge[i][0];
            int end = edge[i][1];
            graph[start].add(end);
            graph[end].add(start);
        }
        
        bfs(1);
        for(int num:dist){
            if(num==max)answer++;
        }
        
        return answer;
    }
    void bfs(int start){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        dist[start] = 0;
        while(!q.isEmpty()){
            int now = q.poll();
            for(int next:graph[now]){
                if(dist[next]==-1){
                    dist[next] = dist[now]+1;
                    if(dist[next]>max)max = dist[next];
                    q.add(next);
                }
            }
        }
    }
}