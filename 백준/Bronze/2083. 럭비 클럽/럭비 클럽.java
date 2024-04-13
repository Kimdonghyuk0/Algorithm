
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

       String name = "";
       int age, w;
       
       while(true) {
    	   name = scan.next();
    	   if(name.equals("#")) return;
    	   age =scan.nextInt();
    	   w =scan.nextInt();
    	   if(age>17||w>=80) {
    		   System.out.println(name+" Senior");
    	   }
    	   else System.out.println(name+" Junior");
    	   
       }
    }
}
