import java.util.Vector;

class Solution {
    static int count = 0;
    static int target;
    static int[] value;
    static Vector<Integer>[] graph;

    // DFS: 현재 노드 s와 지금까지의 합 sum을 전달받음
    static void dfs(int s, int sum) {
        sum += value[s];
        
        // 리프 노드(자식이 없는 노드)인 경우, 합이 target과 일치하면 count 증가
        if (graph[s].isEmpty()) { 
            if (sum == target) {
                count++;
            }
            return;
        }

        // 현재 노드의 자식 노드들을 순회하며 DFS 실행
        for (int i = 0; i < graph[s].size(); i++) {
            int next = graph[s].get(i);
            dfs(next, sum);
        }
    }

    public int solution(int[] numbers, int target) {
        Solution.target = target;
        count = 0; // count 초기화

        // 배열 및 그래프 초기화 (크기 1050000)
        value = new int[1050000];
        graph = (Vector<Integer>[]) new Vector[1050000];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new Vector<Integer>();
        }

        // 그래프에 값 할당: 루트 노드 설정
        graph[1].add(2);
        graph[1].add(3);
        value[1] = 0;

        // numbers 배열의 각 숫자에 대해 양수와 음수 값을 노드에 할당
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            int k = 2 * (i + 1);
            value[k] = num;
            value[k + 1] = -num;
        }

        // 그래프 연결: 각 레벨의 노드들을 이진 트리 형식으로 연결
        // 수정 전: for (int i = 1; i < numbers.length - 1; i++) { ... }
        // 수정 후: 마지막 레벨까지 연결하도록 조건 변경
        for (int i = 1; i < numbers.length; i++) {
            int k = 2 * i;
            graph[k].add(k + 2);
            graph[k].add(k + 3);
            graph[k + 1].add(k + 3);
            graph[k + 1].add(k + 2);
        }

        dfs(1, 0);  // 루트 노드(1)에서 시작, 초기 합은 0

        return count;
    }
}
