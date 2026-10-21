import java.util.*;

class Solution {
    int[] parent;
    void union(int a, int b){
        parent[find(b)] = find(a);
    }
    int find(int x){
        if(parent[x]==x)return x;
        return parent[x] = find(parent[x]);
    }
    public int solution(int n, int[][] computers) {
        parent = new int[n+1];
        for(int i = 0; i<parent.length; i++){
            parent[i] = i;
        }
        for(int i = 0; i<computers.length; i++){
            for(int j = 0; j<computers[i].length; j++){
                if(computers[i][j]==1)union(i,j);
            }
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i<parent.length-1; i++){
            set.add(find(i));
        }
        return set.size();
        
    }
}

//유니온파인드로 연결한다 부모가 다른게 몇개인지 확인한다.