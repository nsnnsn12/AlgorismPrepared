package sunggyu.backjun.algorism.math2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Math6 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = 10000;
        boolean[] isNotPrimeNumbers = new boolean[N+1];
        List<Integer> primeNumbers = new ArrayList<>();
        isNotPrimeNumbers[1] = true;
        //소수란 1과 자신 외의 나눌 수 없는 수를 뜻한다.
        for(int i = 2; i < isNotPrimeNumbers.length; i++){
            if(isNotPrimeNumbers[i]) continue;
            primeNumbers.add(i);
            int index = 2;
            while(i * index < isNotPrimeNumbers.length){
                isNotPrimeNumbers[i*index] = true;
                index++;
            }
        }

        int T = Integer.parseInt(bf.readLine());
        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(bf.readLine());
            int a = 0;
            int b = 0;
            for(int primeNumber : primeNumbers){
                int rest = n - primeNumber;
                if(rest <= 0) break;

                if(!isNotPrimeNumbers[rest]){
                    if(primeNumber > rest) break;
                    a = primeNumber;
                    b = rest;
                }
            }

            bw.write(String.format("%d %d", a, b));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
