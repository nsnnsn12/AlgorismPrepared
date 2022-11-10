package sunggyu.backjun.algorism.function;

import java.io.*;
import java.util.Arrays;

public class Function2 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] isSelfNumber = new boolean[10001];
        for(int i = 1; i < 10001; i++){
            int number = getNumber(i);
            if(number <= 10000){
                isSelfNumber[number] = true;
            }
        }
        for(int i = 1; i < 10001; i++){
            if(!isSelfNumber[i]) {
                bw.write(String.valueOf(i));
                bw.newLine();
            }

        }

        bw.flush();
        bw.close();
    }

    
    public static int getNumber(int number){
        int result = number;
        result += number / 10000;
        result += (number % 10000) / 1000;
        result += (number % 1000) / 100;
        result += (number % 100) / 10;
        result += number % 10;
        return result;
    }
}
