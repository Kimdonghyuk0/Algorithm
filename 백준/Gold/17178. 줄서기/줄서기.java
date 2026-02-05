import java.io.*;
import java.util.*;

public class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken()); // 줄 수
            Stack<String> sorted = new Stack<>();  // 이거 정렬시키고 순서대로 뽑을 거임
            Stack<String> waitLine = new Stack<>();
            Queue<String>[] lines = new Queue[N];
            for (int i = 0; i < N; i++) {
                lines[i] = new ArrayDeque<>();
            }

            for(int i = 0 ;i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k<5; k++){
                    String input = st.nextToken();
                    lines[i].add(input);
                    sorted.add(input);
                }
            }
            // sorted정렬하기
            sorted.sort(Comparator
                    .comparing((String s)->s.charAt(0))
                    .thenComparingInt(s-> Integer.parseInt(s.split("-")[1]))
                    .reversed()
            );

            boolean isTrue = true; //가능한가?

            while(isTrue&&!sorted.isEmpty()){
                String target = sorted.pop();
                boolean isFind = false; // 지금 pop한 애를 입장시킬 수 있나?
                if(!waitLine.isEmpty()&&target.equals(waitLine.peek())){
                    waitLine.pop();
                    continue;
                }
                for(int i = 0; i<N; i++) {
                    while(!lines[i].isEmpty()){
                    String next = lines[i].poll();
                    if (target.equals(next)) {
                        isFind = true;
                        break;
                    }
                    waitLine.push(next);
                    }
                    if(isFind)break;
                }
                if(!isFind)isTrue = false;

            }

            if(isTrue)System.out.print("GOOD");
            else System.out.println("BAD");

        }

}
