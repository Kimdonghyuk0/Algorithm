
import java.util.Scanner;

public class Main {
 static void countInt(int n, int m) {
	int a,b;
	int count = 0;
	double result;
	for(b = 1; b < n; b++) {
		
		for(a = 1; a<b; a++) {
			if(a!=b) { // a<b인 경우
			
				result = ((a * a) + (b * b) + m) / (double)(a * b); 

				if(result == (int)result) { // result가 정수인 경우
	                count++; 
	            }
			}
		}
	}
	System.out.println(count);
	
}
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
       int T,n,m;
       T = scan.nextInt();
     
       
       for(int i = 0; i< T; i++) {
    	   
    	   n  = scan.nextInt();       
           m  = scan.nextInt();  
           Main main = new Main();
           countInt(n,m);
           
       } 
       
    }
}
