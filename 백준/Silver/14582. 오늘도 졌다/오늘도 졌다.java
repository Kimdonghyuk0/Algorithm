
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	int [] ulim = new int [9];
    	int[] start= new int[9];
    	
    	int sum1 = 0;
    	int sum2 = 0;
    	
    	for(int i = 0; i<ulim.length; i++) {
    		ulim[i] = scan.nextInt();
    	}
    	for(int i = 0; i<start.length; i++) {
    		start[i] = scan.nextInt();
    	}
    	
    	int sumUlim = Arrays.stream(ulim).sum();
    	int sumStart = Arrays.stream(start).sum();
    	
    	if(sumUlim>=sumStart) {
    		System.out.print("No");
    		System.exit(0);
    	}
    	
    	
    	for(int i = 0; i<9; i++) {
    		sum1 += ulim[i];
    		
    		if(sum1>sum2) {
    			System.out.print("Yes");
        		System.exit(0);
    		}
    		
    		sum2 += start[i];
    		
    	}
    	System.out.print("No");
    }
}
