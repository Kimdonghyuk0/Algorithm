import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
//        RDD
//        4
//        [1,2,3,4]
        while(T-- > 0){
            ArrayDeque<String> dq = new ArrayDeque<>();
            String prompt = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String ss = br.readLine();
            ss = ss.substring(1, ss.length()-1);
            String[] input = ss.split(",");
            for(int i = 0; i<n; i++){
                //input arr val into array
                dq.add(input[i]);
            }
            boolean flag = true; // if true->front else back
            boolean isError = false;
            for(int i = 0; i<prompt.length(); i++){
                if(prompt.charAt(i)=='R')flag = !flag;
                else {
                    //delete
                    //if null-> error
                    if(dq.isEmpty()){
                        isError = true;
                        break;
                    }
                    if(flag){
                        //순방향
                        dq.pollFirst();

                    }
                    else{
                        //역방향
                        dq.pollLast();

                    }

                }
            }
            if (isError) {
                System.out.println("error");
                continue;
            }
            System.out.print("[");
            while(!dq.isEmpty()){
                if(flag){
                    //순방향
                    String s = dq.pollFirst();
                    System.out.print(s);
                }
                else{
                    //역방향
                    String s = dq.pollLast();
                    System.out.print(s);
                }

                if(!dq.isEmpty())System.out.print(",");

            }

            System.out.println("]");


        }

    }
}