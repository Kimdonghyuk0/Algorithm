import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	int n;
    	int a1,a2,a3;
    	int interval;
    	int count = 0;
    	n = scan.nextInt();
    	if(n<100) {
    		System.out.print(n);
    		System.exit(0);
    	}
    	for(int i = 111; i<n+1; i++) {
    		if(i!=1000) {
    		a1 = i%1000/100;
    		a2 = i%100/10;
    		a3 = i%10;
    		interval = a2-a1;
    		if(a2 + interval == a3) {
    			count++;
    		}
    	
    		}
    	}
    	System.out.print(count+99);
    	
    }
}
