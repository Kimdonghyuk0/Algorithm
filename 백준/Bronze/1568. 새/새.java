import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
	    int bird = 0; // 현재 새의 수
	    int sec = 0; // 시간으로 노래를 부르면 ++
	    int number; // 새가 부르는 숫자
	    
		Scanner scan = new Scanner(System.in);
		bird = scan.nextInt();
		
		while(bird != 0){
		    number = 1;
		    
		   while(bird>=number){
		       sec++;
		       bird -= number;
		       number++;
		       
		       
		   }
		    
		}
		System.out.print(sec);
		
		
		
		
	}
}
