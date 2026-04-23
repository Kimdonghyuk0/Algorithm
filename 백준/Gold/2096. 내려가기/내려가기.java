import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N;
    static Node[][] nodes;

    static class Node{
        int initPoint;
        int min = -1;
        int max = -1;

        int y,x;
        Node(int y, int x,int initPoint){
            this.initPoint = initPoint;
            this.y = y;
            this.x = x;
        }
    }
    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        // 초기값
        nodes[0][0].max = nodes[0][0].initPoint;
        nodes[0][1].max = nodes[0][1].initPoint;
        nodes[0][2].max = nodes[0][2].initPoint;
        nodes[0][0].min = nodes[0][0].initPoint;
        nodes[0][1].min = nodes[0][1].initPoint;
        nodes[0][2].min = nodes[0][2].initPoint;
        q.add(nodes[0][0]);
        q.add(nodes[0][1]);
        q.add(nodes[0][2]);

        while (!q.isEmpty()) {
            Node temp = q.poll();
            int tx = temp.x;
            int ty = temp.y;
            int tmin = temp.min;
            int tmax = temp.max;

            if (ty == N - 1) continue;

            if (tx == 0) {
                boolean updated;
                updated = false;
                if (nodes[ty + 1][tx].min == -1 || nodes[ty + 1][tx].min > nodes[ty + 1][tx].initPoint + tmin) {
                    nodes[ty + 1][tx].min = nodes[ty + 1][tx].initPoint + tmin;
                    updated = true;
                }
                if (nodes[ty + 1][tx].max == -1 || nodes[ty + 1][tx].max < nodes[ty + 1][tx].initPoint + tmax) {
                    nodes[ty + 1][tx].max = nodes[ty + 1][tx].initPoint + tmax;
                    updated = true;
                }
                if (updated) q.add(nodes[ty + 1][tx]);

                updated = false;
                if (nodes[ty + 1][tx + 1].min == -1 || nodes[ty + 1][tx + 1].min > nodes[ty + 1][tx + 1].initPoint + tmin) {
                    nodes[ty + 1][tx + 1].min = nodes[ty + 1][tx + 1].initPoint + tmin;
                    updated = true;
                }
                if (nodes[ty + 1][tx + 1].max == -1 || nodes[ty + 1][tx + 1].max < nodes[ty + 1][tx + 1].initPoint + tmax) {
                    nodes[ty + 1][tx + 1].max = nodes[ty + 1][tx + 1].initPoint + tmax;
                    updated = true;
                }
                if (updated) q.add(nodes[ty + 1][tx + 1]);
            } else if (tx == 1) {
                boolean updated;

                updated = false;
                if (nodes[ty + 1][tx - 1].min == -1 || nodes[ty + 1][tx - 1].min > nodes[ty + 1][tx - 1].initPoint + tmin) {
                    nodes[ty + 1][tx - 1].min = nodes[ty + 1][tx - 1].initPoint + tmin;
                    updated = true;
                }
                if (nodes[ty + 1][tx - 1].max == -1 || nodes[ty + 1][tx - 1].max < nodes[ty + 1][tx - 1].initPoint + tmax) {
                    nodes[ty + 1][tx - 1].max = nodes[ty + 1][tx - 1].initPoint + tmax;
                    updated = true;
                }
                if (updated) q.add(nodes[ty + 1][tx - 1]);

                updated = false;
                if (nodes[ty + 1][tx].min == -1 || nodes[ty + 1][tx].min > nodes[ty + 1][tx].initPoint + tmin) {
                    nodes[ty + 1][tx].min = nodes[ty + 1][tx].initPoint + tmin;
                    updated = true;
                }
                if (nodes[ty + 1][tx].max == -1 || nodes[ty + 1][tx].max < nodes[ty + 1][tx].initPoint + tmax) {
                    nodes[ty + 1][tx].max = nodes[ty + 1][tx].initPoint + tmax;
                    updated = true;
                }
                if (updated) q.add(nodes[ty + 1][tx]);

                updated = false;
                if (nodes[ty + 1][tx + 1].min == -1 || nodes[ty + 1][tx + 1].min > nodes[ty + 1][tx + 1].initPoint + tmin) {
                    nodes[ty + 1][tx + 1].min = nodes[ty + 1][tx + 1].initPoint + tmin;
                    updated = true;
                }
                if (nodes[ty + 1][tx + 1].max == -1 || nodes[ty + 1][tx + 1].max < nodes[ty + 1][tx + 1].initPoint + tmax) {
                    nodes[ty + 1][tx + 1].max = nodes[ty + 1][tx + 1].initPoint + tmax;
                    updated = true;
                }
                if (updated) q.add(nodes[ty + 1][tx + 1]);
            } else if (tx == 2) {
                boolean updated;

                updated = false;
                if (nodes[ty + 1][tx - 1].min == -1 || nodes[ty + 1][tx - 1].min > nodes[ty + 1][tx - 1].initPoint + tmin) {
                    nodes[ty + 1][tx - 1].min = nodes[ty + 1][tx - 1].initPoint + tmin;
                    updated = true;
                }
                if (nodes[ty + 1][tx - 1].max == -1 || nodes[ty + 1][tx - 1].max < nodes[ty + 1][tx - 1].initPoint + tmax) {
                    nodes[ty + 1][tx - 1].max = nodes[ty + 1][tx - 1].initPoint + tmax;
                    updated = true;
                }
                if (updated) q.add(nodes[ty + 1][tx - 1]);

                updated = false;
                if (nodes[ty + 1][tx].min == -1 || nodes[ty + 1][tx].min > nodes[ty + 1][tx].initPoint + tmin) {
                    nodes[ty + 1][tx].min = nodes[ty + 1][tx].initPoint + tmin;
                    updated = true;
                }
                if (nodes[ty + 1][tx].max == -1 || nodes[ty + 1][tx].max < nodes[ty + 1][tx].initPoint + tmax) {
                    nodes[ty + 1][tx].max = nodes[ty + 1][tx].initPoint + tmax;
                    updated = true;
                }
                if (updated) q.add(nodes[ty + 1][tx]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        N = Integer.parseInt(br.readLine());
        nodes = new Node[N][3];
        for(int i = 0; i<N; i++){
            input = br.readLine().split(" ");
            for(int k = 0; k<3; k++){
                nodes[i][k] = new Node( i, k,Integer.parseInt(input[k]));
            }
        }
        bfs();
        int max = nodes[N-1][0].max;
        int min = nodes[N-1][0].min;
        for(int i = 1; i<3; i++){
            if(max<nodes[N-1][i].max)max = nodes[N-1][i].max;
            if(min>nodes[N-1][i].min)min = nodes[N-1][i].min;
        }

        System.out.println(max+" "+min);


    }
}