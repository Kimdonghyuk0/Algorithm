import java.util.*;

class Solution {
    Map<Integer, String> map = new TreeMap<>();
    Map<String, Integer> indexMap = new HashMap<>();
    int icn = 0;
    List<Integer>[] graph;
    int ticketCount;

    public String[] solution(String[][] tickets) {

        Set<String> set = new TreeSet<>();

        for (int i = 0; i < tickets.length; i++) {
            for (int j = 0; j < tickets[i].length; j++) {
                set.add(tickets[i][j]);
            }
        }

        ticketCount = tickets.length;

        int ii = 0;
        for (String s : set) {
            map.put(ii, s);
            indexMap.put(s, ii);

            if (s.equals("ICN")) icn = ii;
            ii++;
        }

        graph = new List[map.size()];

        for (int j = 0; j < graph.length; j++) {
            graph[j] = new ArrayList<>();
        }

        for (int i = 0; i < tickets.length; i++) {
            int from = indexMap.get(tickets[i][0]);
            int to = indexMap.get(tickets[i][1]);

            graph[from].add(to);
        }

        // 알파벳순 인덱스를 부여했으므로 인덱스 오름차순 정렬
        for (int i = 0; i < graph.length; i++) {
            Collections.sort(graph[i]);
        }

        List<String> answer = new ArrayList<>();

        dfs(icn, answer, ticketCount);

        String[] result = new String[answer.size()];

        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }

    boolean dfs(int start, List<String> answer, int remain) {
        answer.add(map.get(start));

        if (remain == 0) {
            return true;
        }

        for (int i = 0; i < graph[start].size(); i++) {
            int next = graph[start].get(i);

            // 티켓 사용
            graph[start].remove(i);

            if (dfs(next, answer, remain - 1)) {
                return true;
            }

            // 실패했으면 복구
            graph[start].add(i, next);

            // 방금 추가한 공항 제거
            answer.remove(answer.size() - 1);
        }

        return false;
    }
}