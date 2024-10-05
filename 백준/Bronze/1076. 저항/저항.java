import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bbr = new BufferedReader(new InputStreamReader(System.in));
	
		String[] color = {"black", "brown", "red", "orange", "yellow", "green",
				"blue", "violet", "grey", "white"};	
		String A = bbr.readLine();
		String B = bbr.readLine();
		String C = bbr.readLine();
		long result = (Arrays.asList(color).indexOf(A) * 10) + Arrays.asList(color).indexOf(B);
		result *= Math.pow(10, Arrays.asList(color).indexOf(C));
		
		System.out.println(result);
	}

}