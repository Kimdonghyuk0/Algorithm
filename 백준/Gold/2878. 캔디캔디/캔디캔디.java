import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] input = br.readLine().split(" ");
            long M = Long.parseLong(input[0]);
            int N = Integer.parseInt(input[1]);
            long[] friends = new long[N];
            long sum = 0;
            for(int i = 0; i<N; i++){
                friends[i] = Long.parseLong(br.readLine());
                sum+=friends[i];
            }
            long can = sum-M;
            Arrays.sort(friends);
            for(int i = 0; i<N; i++){
                if(friends[i]<can/(N-i)) {
                    can-=friends[i];
                    continue;
                };
                friends[i] = can/(N-i);
                can-= can/(N-i);
            }

            long ans = 0;
            for(int i = 0; i<N; i++){
               ans+=friends[i]*friends[i];
            }
            System.out.println(Long.toUnsignedString(ans));


          }
}
