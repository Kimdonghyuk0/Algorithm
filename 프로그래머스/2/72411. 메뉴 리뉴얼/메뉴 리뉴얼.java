import java.util.*;
class Solution {
    public Map<String, Integer> map = new HashMap<>();
    
    public void dfs(String order, int m, char[] ans, int depth, int start) {
        if (depth == m) {
           // Arrays.sort(ans,0,m); 여기서 정렬을 하면 ans순서가 바뀐상태로 재귀를 탈출하기에 잘못된 결과가 나온다!! 처음에 order를 정렬하고 넣어야한다.
            String str = new String(ans);
            Integer count = map.get(str);
            if (count == null)
                map.put(str, 1);
            else
                map.put(str, count + 1);
            return;
        }
        for (int i = start; i < order.length(); i++) {
            ans[depth] = order.charAt(i);
            dfs(order, m, ans, depth + 1, i + 1);
        }
    }
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < orders.length; i++) {
            String order = orders[i];
            char[] orderArr = order.toCharArray();
            Arrays.sort(orderArr);
            order = new String(orderArr);
            for (int k = 0; k < course.length; k++) {
                int m = course[k];
                char[] ans = new char[m];
                dfs(order, m, ans, 0, 0);
            }
        }
        for(int i : course ){
            int max = 2;
            Iterator <Map.Entry<String,Integer>> iterator = map.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry<String,Integer> entry = iterator.next();
                System.out.println(entry.getKey()+"->"+entry.getValue());
                int len = entry.getKey().length();
                if(len==i&&max<entry.getValue())max = entry.getValue();
            }
            for(Map.Entry<String,Integer> entry: map.entrySet()){
                if(entry.getKey().length()==i&&entry.getValue()==max)list.add(entry.getKey());
            }
        }
        Collections.sort(list);
        answer =  list.toArray(new String[0]);
        return answer;
    }
}
