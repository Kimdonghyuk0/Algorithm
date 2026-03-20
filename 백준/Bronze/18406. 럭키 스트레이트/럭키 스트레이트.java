import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int left = 0;
        int right = 0;
        for(int i = 0; i<input.length()/2; i++){
            left+=input.charAt(i)-'0';
            right+=input.charAt(input.length()-1-i)-'0';

        }
        if(left==right)System.out.println("LUCKY");
        else System.out.println("READY");
    }
}