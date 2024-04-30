
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	int X;
    	int stick = 64;
    	ArrayList<Integer> list = new ArrayList<>();

    	X = scan.nextInt();
    	while(true) {
    	
    	list.add(stick);
    	if( list.stream().mapToInt(Integer::intValue).sum()==X) {
    		System.out.print(list.size());
    		System.exit(0);
    	}
    	else list.remove(list.size() - 1); 
    		
    	
    		stick = stick / 2;
    		if(X>stick) {
    			list.add(stick);
    			if( list.stream().mapToInt(Integer::intValue).sum()==X) {
    	    		System.out.print(list.size());
    	    		System.exit(0);
    	    	}
    			if( list.stream().mapToInt(Integer::intValue).sum()>X) {
    				list.remove(list.size() - 1); 
    	    	}
    			list.add(stick);
    			if( list.stream().mapToInt(Integer::intValue).sum()==X) {
    	    		System.out.print(list.size());
    	    		System.exit(0);
    	    	}
    			else list.remove(list.size() - 1); 
    			
    			
    		}
    		
    	
    	
    	}
    }
}
