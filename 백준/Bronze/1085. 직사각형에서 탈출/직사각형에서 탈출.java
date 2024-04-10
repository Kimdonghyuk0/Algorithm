

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
      int x, y, w, h;
      int arr[];
      int min;
      x = scan.nextInt();
      y = scan.nextInt();
      w = scan.nextInt();
      h = scan.nextInt();
      arr = new int []{x,y,w-x,h-y};
      min = arr[0];
      for(int i=1; i<arr.length; i++) {
    	  if(min>arr[i]) {
    		  min = arr[i];
    	  }
      }
      System.out.print(min);
    }
}