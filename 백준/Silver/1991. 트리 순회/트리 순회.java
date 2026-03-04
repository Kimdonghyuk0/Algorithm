import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node{
    char root;
    char left;
    char right;

    public Node(char root,char left, char right){
        this.root = root;
        this.left = left;
        this.right = right;
    }
}

public class Main {
    static Map<Character,Node> tree = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        for(int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            tree.put(root, new Node(root, left, right));

        }
        preOrder(tree.get('A'));
        System.out.println();
        inOrder(tree.get('A'));
        System.out.println();
        postOrder(tree.get('A'));
    }
    static void preOrder(Node node){

         System.out.print(node.root);
         if(node.left!='.')preOrder(tree.get(node.left));
        if(node.right!='.') preOrder(tree.get(node.right));
    }

    static void inOrder(Node node){


        if(node.left!='.')inOrder(tree.get(node.left));
        System.out.print(node.root);
        if(node.right!='.') inOrder(tree.get(node.right));
    }

    static void postOrder(Node node){


        if(node.left!='.')postOrder(tree.get(node.left));
        if(node.right!='.')   postOrder(tree.get(node.right));
        System.out.print(node.root);
    }



}
