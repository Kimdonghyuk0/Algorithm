import java.io.*;
import java.util.*;


public class Main {
    static String[] strings;
    static int R,C;
    static boolean check(int mid){
        // count++가능하면 (중복이 없다면) true 리턴
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i<C; i++ ){
            StringBuilder sb = new StringBuilder(); //비교하는 기본 값
                for(int k = mid; k<R; k++ ){
                    sb.append(strings[k].charAt(i));
                }
                if (!set.add(sb.toString())) return false;


        }
        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()) ;

        int ans = 0;


        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        strings = new String[R];
        int left = 0;
        int right = R-1;
        int mid;
        for(int i = 0; i<R; i++){
            strings[i]  =  br.readLine();
        }
        while(left<=right){
            mid = (left+right)/2;

            if(check(mid)){
                left = mid+1;

                ans = mid;
            }
            else right = mid - 1;
        }

        System.out.println(ans);


    }
}