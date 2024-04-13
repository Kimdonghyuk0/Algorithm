
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Integer> arr = new ArrayList<>();
        
        int ds = -2; 
        int q, r;
        int d = scan.nextInt(); 
        if(d==0) {
        	 System.out.print(0);
        }

        while (d != 0) {
            r = d % ds;
           
            if (r < 0) {
                r += 2;  
                q = (d / ds)+1;
            } 
            else {
                q = d / ds; 
            }

            arr.add(r);  
            d = q;                 
        }

       
        for (int j = arr.size() - 1; j >= 0; j--) {
            System.out.print(arr.get(j));
        }
    }
}
