import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int v;
        Node left,right;

        Node(int input){
            this.v = input;
        }
        void insert(int num){
            if(v<num){
                if(right==null)right = new Node(num);
                else right.insert(num);
            }
            if(v>num){
                if(left==null)left = new Node(num);
                else left.insert(num);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));
        while(true){
            String input = br.readLine();
            if(input==null||input.equals(""))break;
            root.insert(Integer.parseInt(input));
        }
        postOrder(root);


    }

    static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.v);
    }
}