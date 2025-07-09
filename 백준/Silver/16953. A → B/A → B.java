
import java.io.*;
import java.util.*;



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int A,B;
        A = Integer.parseInt(input[0]);
        B = Integer.parseInt(input[1]);
        int count = 1;
        while(true){
            if(A==B)break;
            if((B-1)%10==0){ //뒷자리 1이면 1빼기
                B/=10;
                count++;
            }
            else if(B%2!=0){
                count = -1;
                break;
            }
            else{
                B/=2;
                count++;
            }
            if(B<A){
                count = -1;
                break;
            }
        }
        System.out.println(count);

    }
}