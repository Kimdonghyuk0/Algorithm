import java.io.*;
import java.util.*;


public class Main {

    static ArrayList<ArrayList<Info>> list = new ArrayList<>();
    // 이따 리스트 초기화 해야됨 음식리스트 안에 학생 정보 리스트들어감
    static class Info {
        int student,v;
        Info(int p, int v){
            this.student = p;
            this.v = v;
        }
    }
    static long dp(ArrayList<Info> infos){
        if (infos.isEmpty()) return 0;
        long []dp = new long[infos.size()+1];
        dp[1] = infos.get(0).v;
        for(int i = 2; i<dp.length; i++){
            if(infos.get(i-1).student-1==infos.get(i-2).student) dp[i] = Math.max(dp[i-1],dp[i-2]+infos.get(i-1).v);
            else dp[i] = dp[i-1]+infos.get(i-1).v;
        }


        return dp[dp.length-1];
    }

    public static void main(String[] args) throws IOException{
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long sum = 0;
        int N,M; // 음식, 학생수
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        for(int i = 0; i<N; i++){
            list.add(new ArrayList<Info>());
        }
        for(int i = 0; i<M; ++i){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            for(int ii = 0; ii<l; ii++){
                int p = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                Info info = new Info(i+1,v);
                list.get(p-1).add(info);
            }
        }
        //n번째 음식의 리스트 크기가 1 이하면 그 안에있는 info.v 더해버리기
        // 2개 이상이면 바로 "DP"
        for (ArrayList<Info> infos : list) {//음식 개수만큼 돌게됨
            if (infos.size() == 1) {// sum에 더해
                sum += infos.get(0).v;
            }
            else sum+=dp(infos);
        }
        System.out.println(sum);


    }
}