import java.io.*;
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Integer.parseInt(br.readLine());

        long fiveCount = 0;

        for(int i = 5; i<=N; i*=5){
            fiveCount+=N/i;
        }

        System.out.println(fiveCount);
    }
}