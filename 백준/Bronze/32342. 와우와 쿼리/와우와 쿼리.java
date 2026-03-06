import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while(N-- > 0){
            String input = br.readLine();

            if(input.length() < 3){
                System.out.println(0);
                continue;
            }

            int count = 0;

            for(int i = 0; i < input.length()-2; i++){
                String str = input.substring(i, i+3);

                if(str.equals("WOW")){
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}