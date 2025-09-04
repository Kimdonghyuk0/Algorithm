import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<String> answer = new ArrayList<>();
    static String[] form = {"*","+","-",""};
    static int maxIndex;

    static void backTracking(StringBuilder result, char[] input, int index){
        result.append(input[index]);

        if(index == maxIndex){
            String expression = result.toString();

            // 0으로 시작하면 return
            String temp = expression.replaceAll("[*+\\-]", " ");
            String[] numbers = temp.split(" ");
            boolean hasLeadingZero = false;
            for(String num : numbers){
                if(num.length() > 1 && num.startsWith("0")){
                    hasLeadingZero = true;
                    break;
                }
            }
            if(hasLeadingZero){
                result.deleteCharAt(result.length() - 1);
                return;
            }

            // 연산시 값이 2000이면 answer에 추가
            try {
                // 먼저 곱셈 처리
                String expr = expression;
                while(expr.contains("*")){
                    int idx = expr.indexOf("*");

                    // 왼쪽 숫자 찾기
                    int leftStart = idx - 1;
                    while(leftStart >= 0 && Character.isDigit(expr.charAt(leftStart))){
                        leftStart--;
                    }
                    leftStart++;
                    int leftNum = Integer.parseInt(expr.substring(leftStart, idx));

                    // 오른쪽 숫자 찾기
                    int rightEnd = idx + 1;
                    while(rightEnd < expr.length() && Character.isDigit(expr.charAt(rightEnd))){
                        rightEnd++;
                    }
                    int rightNum = Integer.parseInt(expr.substring(idx + 1, rightEnd));

                    // 곱셈 결과로 치환
                    int multiplyResult = leftNum * rightNum;
                    expr = expr.substring(0, leftStart) + multiplyResult + expr.substring(rightEnd);
                }

                // 덧셈과 뺄셈 처리 (왼쪽에서 오른쪽으로)
                int finalResult = 0;
                int currentNum = 0;
                char operation = '+';
                StringBuilder numStr = new StringBuilder();

                for(int i = 0; i < expr.length(); i++){
                    char c = expr.charAt(i);

                    if(Character.isDigit(c)){
                        numStr.append(c);
                    }

                    if(!Character.isDigit(c) || i == expr.length() - 1){
                        if(numStr.length() > 0){
                            currentNum = Integer.parseInt(numStr.toString());

                            if(operation == '+'){
                                finalResult += currentNum;
                            } else if(operation == '-'){
                                finalResult -= currentNum;
                            }

                            numStr = new StringBuilder();
                        }

                        if(c == '+' || c == '-'){
                            operation = c;
                        }
                    }
                }

                if(finalResult == 2000){
                    answer.add(expression);
                }
            } catch(Exception e){
                // 계산 오류 시 무시
            }

            result.deleteCharAt(result.length() - 1);
            return;
        }

        for(int i = 0; i < 4; i++){
            result.append(form[i]);
            backTracking(result, input, index + 1);
            // 백트래킹 - 추가한 것을 제거
            if(!form[i].equals("")){
                result.deleteCharAt(result.length() - 1);
            }
        }

        // 현재 index의 문자도 제거
        result.deleteCharAt(result.length() - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        maxIndex = input.length - 1;
        StringBuilder sb = new StringBuilder();
        backTracking(sb, input, 0);

        // 사전 순서로 정렬
        Collections.sort(answer);

        for(String str : answer){
            System.out.println(str);
        }

        br.close();
    }
}