import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            int input = Integer.parseInt(br.readLine());
            if(input==0)break;
            boolean[] isCheck = new boolean[10000];
            int sum = 0;
            while(true){

                if(isCheck[input])break;
                isCheck[input] = true;
                input = input*input;
                sum++;
                input = (input%1000000)/100;
            }
            System.out.println(sum);
        }
    }
}