package sunggyu.backjun.algorism.math2;

import java.io.*;

public class Math5 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = 300000;
        boolean[] isNotPrimeNumbers = new boolean[N+1];
        isNotPrimeNumbers[1] = true;
        //소수란 1과 자신 외의 나눌 수 없는 수를 뜻한다.
        for(int i = 2; i < isNotPrimeNumbers.length; i++){
            if(isNotPrimeNumbers[i]) continue;
            int index = 2;
            while(i * index < isNotPrimeNumbers.length){
                isNotPrimeNumbers[i*index] = true;
                index++;
            }
        }

        while(true){
            int M = Integer.parseInt(bf.readLine());
            if(M == 0) break;
            int count = 0;
            for(int i = M + 1; i <= M * 2; i++){
                if(!isNotPrimeNumbers[i]){
                    count++;
                }
            }

            bw.write(String.valueOf(count));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
