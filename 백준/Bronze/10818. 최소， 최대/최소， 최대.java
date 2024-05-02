
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N;
        N = scan.nextInt();
        int []arr = new int[N];
        for (int i=0; i<N; i++) {
        	arr[i] = scan.nextInt();
        }
       int min = arr[0];
       int max = arr[0];
       
       for(int i=1; i<N; i++) {
    	   if(min>arr[i])min = arr[i];
    	   if(max<arr[i])max = arr[i];
    	   
       }
       System.out.print(min+" "+max);
    }
}
