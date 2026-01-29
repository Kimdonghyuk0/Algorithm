import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
        private static class driver{
            String name;
            int x;
            driver(String name, int x){
                this.name = name;
                this.x = x;
            }
        }
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<String> ans = new ArrayList<>();
            int N = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            driver[] drivers = new driver[N];
            for(int i = 0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                int x = Integer.parseInt(st.nextToken());

                if(i!=0) {
                    x = (drivers[i-1].x - (x%T))>=0?drivers[i-1].x - (x%T):T+(drivers[i-1].x - (x%T));
                }
                drivers[i] = new driver(name,x);
            }

            //절대 위치 기준으로 정렬
              Arrays.sort(drivers, (a,b) -> Integer.compare(a.x, b.x));

            for(int i = 0; i<N; i++){
                if(i!=N-1&&(drivers[(i+1)].x-drivers[i].x)<=1000)ans.add(drivers[i].name);
                else if((T-drivers[i].x)<=1000)ans.add(drivers[i].name);
            }
            if(ans.isEmpty())System.out.println(-1);
            else{
                Collections.sort(ans);
                for(String s:ans)System.out.print(s+" ");
            }

        }

}
