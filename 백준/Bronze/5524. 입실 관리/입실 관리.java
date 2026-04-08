import java.io.*;
import java.util.*;


class Node{
    int to, w;
     Node(int to,int w){
        this.to = to;
        this. w = w;
    }
}
public class Main {
    static int n,m;
    static List<Node>[] graph;
    static int[] dist;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i<n; i++){
            String input = br.readLine()    ;
            System.out.println(input.toLowerCase());
        }


    }
}