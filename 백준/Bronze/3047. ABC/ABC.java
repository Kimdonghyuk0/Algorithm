
import java.util.*;

public class Main {
    public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
    int arr[] = new int[3];
    for(int i = 0; i<arr.length; i++) {
    	arr[i] = scan.nextInt();
    }
    
    Arrays.sort(arr);
    int A = arr[0];
    int B = arr[1];
    int C = arr[2];
    
    String input = scan.next();
   
    for(int i =0; i<3; i++) {
    	if(input.charAt(i)=='A'){
    		System.out.print(A+" ");
    	}
    	
    	else if(input.charAt(i)=='B'){
    		System.out.print(B+" ");
    	}
    	
    	else if(input.charAt(i)=='C'){
    		System.out.print(C+" ");
    	}
    }
    
      
     scan.close();  
    }
}