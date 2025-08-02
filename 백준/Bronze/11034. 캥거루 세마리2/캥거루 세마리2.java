import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int A,B,C;
        while(true){
            String input  = br.readLine();
            if(input == null||input.equals(" "))break;
            String[] inp = input.split(" ");
            A = Integer.parseInt(inp[0]);
            B = Integer.parseInt(inp[1]);
            C = Integer.parseInt(inp[2]);
            System.out.println(Math.max(B-A,C-B)-1);
        }


          }
}
