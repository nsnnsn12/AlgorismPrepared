package sunggyu.backjun.algorism.math2;

import java.io.*;

public class Math4 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] mn = bf.readLine().split(" ");
        int M = Integer.parseInt(mn[0]);
        int N = Integer.parseInt(mn[1]);
        if(N == 1) return;

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

        for(int i = M; i < N+1; i++){
            if(!isNotPrimeNumbers[i]){
                bw.write(String.valueOf(i));
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }
}
