import java.io.*;
import java.util.*;

public class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine();


            for(int i = 1; i<=999; i++){
                StringBuilder sb = new StringBuilder();
                for(int k = i; k<=999; k++){
                    sb.append(Integer.toString(k));
                    if(sb.toString().equals(input)){
                        System.out.println(i+" "+k);
                        return;
                    }
                }
            }


        }

}
