
import java.util.Scanner;

public class Main {

	
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	int T;
    	int change;
    	int []result = new int[4];
    	T = scan.nextInt();
    	
    	for(int i = 0; i<T; i++) {
    		int k = 0;
    		change = scan.nextInt();
    		result[k] = change/25;
    		change = change%25;
    		k++;
    		result[k] = change/10;
    		change = change%10;
    		k++;
    		result[k] = change/5;
    		change = change%5;
    		k++;
    		result[k] = change;
    		for(int j = 0; j<result.length; j++) {
    			System.out.print(result[j]+" ");
    		}
    		System.out.println();
    	}
    	
    	
    	
        
    }
}

