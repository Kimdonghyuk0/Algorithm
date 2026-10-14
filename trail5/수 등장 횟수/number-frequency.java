import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N,M;
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        HashMap<Integer,Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            int target = Integer.parseInt(st.nextToken());
            map.put(target,map.getOrDefault(target, 0) + 1);
        }
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            System.out.print(map.getOrDefault(Integer.parseInt(st.nextToken()), 0)+" ");
        }
      
    }
}