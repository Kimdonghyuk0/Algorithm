import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
        static int N;
        static int[] arr;
        static int ans = -1;
        static int[] dx = {-1,0,1};
    static int check(int dif, int now,int add){
        int sum = add;
        int index = 2;
        while(true){
            if(index==arr.length)break;
            if(arr[index]-now == dif){
                now = arr[index];
                index++;

            }
            else if(arr[index]+1-now == dif){
                now = arr[index]+1;
                index++;
                sum++;
            }
            else if(arr[index]-1-now == dif){
                now = arr[index]-1;
                index++;
                sum++;
            }
            else{
                sum = -1;
                break;
            }
        }
        return sum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if(N==1){
            System.out.println("0");
            return;
        }

        for(int i = 0; i<3; i++){
            int add1 = 0;
            int first = arr[0]+dx[i];
            if(dx[i]!=0)add1++;
            for(int j = 0; j<3; j++){
                int add2 = 0;
                if(dx[j]!=0)add2++;
                int second = arr[1]+dx[j];
                int dif = second - first;
                int temp = check(dif,second,add1+add2);
                if(temp!=-1){
                    if(ans==-1)ans = Integer.MAX_VALUE;
                    ans = Math.min(ans,temp);
                }
            }
        }
        System.out.println(ans);
    }
}
