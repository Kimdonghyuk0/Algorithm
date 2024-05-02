import java.util.Scanner;

public class Main {

	
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	int T;
    	T = scan.nextInt();
    	int a,b,com;
    	for(int i =0; i<T; i++) {
    		a = scan.nextInt();
    		b = scan.nextInt();
    		while(b>4)
    		{
    			b-=4;
    		}
    		double result = Math.pow(a, b);
    		com = (int)result%10;
    		if(com==0)System.out.println("10");
    		else System.out.println(com);
    		
    	}
    }
}

