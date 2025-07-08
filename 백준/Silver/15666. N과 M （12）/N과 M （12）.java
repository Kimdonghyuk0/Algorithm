
import java.io.*;
import java.util.*;



public class Main {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int[] arr;
    static int[] ans;
    static int M;
    static StringBuilder sb = new StringBuilder();
    static void dfs(int start, int depth){
        if(depth==M){
            for(int val:ans){
                sb.append(val).append(" ");

            }
            sb.append("\n");
            return;
        }
        for(int i = start; i<arr.length; i++){
            ans[depth] = arr[i];
            dfs(i,depth+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ans = new int[M];
        TreeSet<Integer> set = new TreeSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }
        arr = new int[set.size()];
        int index = 0;
        for(int n:set){
            arr[index] = n;
            index++;
        }
        dfs(0,0);
        System.out.println(sb.toString());

    }
}