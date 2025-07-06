import org.w3c.dom.Node;

import java.io.*;
import java.util.*;



public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        long[][] dist;
        int n,m;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dist = new long[n+1][n+1];
        for(int i = 1; i<dist.length; i++){
            for(int j = 1; j<dist.length; j++){
                if(i==j)dist[i][j] = 0;
                else dist[i][j] = Integer.MAX_VALUE;
            }
        }
        int a,b,c;
        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            dist[a][b] = Math.min(dist[a][b],c);
        }

        //플로이드 와샬 알고리즘
        for(int i = 1; i<dist.length; i++){ //중간노드
            for(int j = 1; j<dist.length; j++){ //출발노드
                for(int k = 1; k<dist.length; k++){ //도착노드
                    if (dist[j][i] != Integer.MAX_VALUE && dist[i][k] != Integer.MAX_VALUE)dist[j][k] = Math.min(dist[j][k],dist[j][i]+dist[i][k]);
                }
            }
        }
        for(int i = 1; i< dist.length; i++){
            for(int j = 1; j<dist.length; j++){
                if(dist[i][j]<Integer.MAX_VALUE)System.out.print(dist[i][j]+" ");
                else System.out.print("0 ");
            }
            System.out.println();
        }



    }
}