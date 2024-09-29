import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int one = 2;
        int zero = 4;
        int another = 3;
        String input= "";
        input = br.readLine();
        while(!input.equals("0")){

            int count = 0;
            for(int i = 0; i < input.length(); i++){
                if(input.charAt(i) == '1'){
                    count+=one;
                }
                else if(input.charAt(i) == '0'){
                    count+=zero;
                }
                else{
                    count+=another;
                }
            }
            count+=input.length()+1;
            bw.write(Integer.toString(count) + "\n");
            bw.flush();
            input = br.readLine();
        }

    }
}