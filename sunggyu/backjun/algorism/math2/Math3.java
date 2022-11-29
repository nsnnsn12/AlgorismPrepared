package sunggyu.backjun.algorism.math2;

import java.io.*;

public class Math3 {
    public static void main(String[] args) throws Exception {
        //소인수분해란? 소인수(소수로 이루어진 인수) 들의 곱으로만 자연수를 나타낸 것을 뜻한다.
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        boolean[] isNotPrimeNumber = new boolean[10000001];
        isNotPrimeNumber[1] = true;
        for(int i = 2; i < 10000001; i++){
            if(n == 1) break;
            if(isNotPrimeNumber[i]) continue;
            while(n % i == 0){
                bw.write(String.valueOf(i));
                bw.newLine();
                n /= i;
            }
            int count = 2;
            while(i * count <= 10000000){
                isNotPrimeNumber[i*count] = true;
                count++;
            }
        }
        bw.flush();
        bw.close();
    }
}
