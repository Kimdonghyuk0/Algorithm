import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N;
        N = Integer.parseInt(st.nextToken());
        if(N%2==0)System.out.println("CY");
        else System.out.println("SK");
        br.close();

    }



}
