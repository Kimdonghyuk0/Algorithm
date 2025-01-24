import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        boolean isIn[]; //true - 실내 false = 실외
        boolean visited[];
        int nearInCount[];
        int ans = 0;
        Vector<Integer>[] graph;
        Queue<Integer> q = new LinkedList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        isIn = new boolean[N + 1];
        visited = new boolean[N + 1];
        graph = new Vector[N + 1];
        nearInCount = new int[N + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new Vector<>();
        }
        //실내 실외 체크
        for (int i = 1; i <= input.length(); i++) {
            isIn[i] = input.charAt(i - 1) == '1';
        }

        //그래프 연결
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }
        for (int i = 1; i <= N; i++) {
            int inCount = 0;
            if (!isIn[i] && !visited[i]) {
                q.add(i);
                visited[i] = true;
                while (!q.isEmpty()) {
                    int current = q.poll();
                    //연결된 실내 개수 세기
                    for (int k = 0; k < graph[current].size(); k++) {
                        if (isIn[graph[current].get(k)]) inCount++;
                        else {
                            if (!visited[graph[current].get(k)]) {
                                q.add(graph[current].get(k));
                                visited[graph[current].get(k)] = true;
                            }
                        }
                    }
                }
            }
            ans += inCount * (inCount - 1);
        }
        //실내-실내 경우
        for (int i = 1; i <= N; i++) {
            int inCount = 0;
            if (isIn[i] && !visited[i]) {
                q.add(i);
                visited[i] = true;
                while (!q.isEmpty()) {
                    int current = q.poll();
                    //연결된 실내 개수 세기
                    for (int k = 0; k < graph[current].size(); k++) {
                        if (isIn[graph[current].get(k)]) {
                            inCount++;
                            if (!visited[graph[current].get(k)]) {
                                q.add(graph[current].get(k));
                                visited[graph[current].get(k)] = true;
                            }
                        }

                    }
                }
            }
            if (inCount > 1) ans += inCount;
        }
        System.out.println(ans);

    }


}
