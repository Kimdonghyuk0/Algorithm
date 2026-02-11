import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = st.countTokens();
        int[][][] position = new int [size][5][5]; // 움직인 횟수/왼발/오른발
        //첫세팅
        int next = Integer.parseInt(st.nextToken());
        position[1][next][0] = 2;
        position[1][0][next] = 2;
        int count = 1;
        while(st.hasMoreTokens()){
            next = Integer.parseInt(st.nextToken());
            if(next==0)break;
            //모든 경우 순회
            for(int i = 0; i<5; i++){
                for(int k = 0; k<5; k++){
                    if(position[count][i][k]==0) continue;

// ===== 왼발이동 =====
                    if(i==0){
                        if(position[count+1][next][k]==0) position[count+1][next][k] = position[count][i][k] + 2;
                        else position[count+1][next][k] = Math.min(position[count+1][next][k], position[count][i][k] + 2);
                    }
                    else if(Math.abs(i-next)==0){
                        if(position[count+1][next][k]==0) position[count+1][next][k] = position[count][i][k] + 1;
                        else position[count+1][next][k] = Math.min(position[count+1][next][k], position[count][i][k] + 1);
                    }
                    else if(Math.abs(i-next)==1){
                        if(position[count+1][next][k]==0) position[count+1][next][k] = position[count][i][k] + 3;
                        else position[count+1][next][k] = Math.min(position[count+1][next][k], position[count][i][k] + 3);
                    }
                    else if(Math.abs(i-next)==3){
                        if(position[count+1][next][k]==0) position[count+1][next][k] = position[count][i][k] + 3;
                        else position[count+1][next][k] = Math.min(position[count+1][next][k], position[count][i][k] + 3);
                    }
                    else if(Math.abs(i-next)==2){
                        if(position[count+1][next][k]==0) position[count+1][next][k] = position[count][i][k] + 4;
                        else position[count+1][next][k] = Math.min(position[count+1][next][k], position[count][i][k] + 4);
                    }

                    // ===== 오른발이동 =====
                    if(k==0){
                        if(position[count+1][i][next]==0) position[count+1][i][next] = position[count][i][k] + 2;
                        else position[count+1][i][next] = Math.min(position[count+1][i][next], position[count][i][k] + 2);
                    }
                    else if(Math.abs(k-next)==0){
                        if(position[count+1][i][next]==0) position[count+1][i][next] = position[count][i][k] + 1;
                        else position[count+1][i][next] = Math.min(position[count+1][i][next], position[count][i][k] + 1);
                    }
                    else if(Math.abs(k-next)==1){
                        if(position[count+1][i][next]==0) position[count+1][i][next] = position[count][i][k] + 3;
                        else position[count+1][i][next] = Math.min(position[count+1][i][next], position[count][i][k] + 3);
                    }
                    else if(Math.abs(k-next)==3){
                        if(position[count+1][i][next]==0) position[count+1][i][next] = position[count][i][k] + 3;
                        else position[count+1][i][next] = Math.min(position[count+1][i][next], position[count][i][k] + 3);
                    }
                    else if(Math.abs(k-next)==2){
                        if(position[count+1][i][next]==0) position[count+1][i][next] = position[count][i][k] + 4;
                        else position[count+1][i][next] = Math.min(position[count+1][i][next], position[count][i][k] + 4);
                    }

                }
            }
            count++;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<5; i++){
            for(int k = 0; k<5; k++){
                if(position[size-1][i][k]!=0&&min>position[size-1][i][k])min = position[size-1][i][k];
            }
        }

        System.out.println(min);
    }
}