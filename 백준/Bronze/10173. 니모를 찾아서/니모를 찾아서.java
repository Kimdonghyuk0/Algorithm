import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        
        while (true) {
            String sentence = scan.nextLine(); 
             if (sentence.length()>80) {
	break;
}
            
            else if(sentence.equals("EOI")) {
                break;
            }
            
           
            boolean containsNemo = sentence.toLowerCase().contains("nemo"); //입력받은 모든문자를 소문자로 바꿔서 nemo 찾음
            
          
            if(containsNemo) {
                System.out.println("Found");
            } else {
                System.out.println("Missing");
            }
        }
        
        scan.close(); 
    }
}
