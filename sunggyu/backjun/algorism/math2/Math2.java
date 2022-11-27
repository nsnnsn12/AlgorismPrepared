package sunggyu.backjun.algorism.math2;

import java.io.*;

public class Math2 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(bf.readLine());
        int n = Integer.parseInt(bf.readLine());
        boolean[] isNotPrimeNumber = new boolean[10001];
        isNotPrimeNumber[1] = true;

        for(int i = 2; i < 10001; i++){
            if(isNotPrimeNumber[i]) continue;
            int count = 2;
            while(i * count <= 10000){
                isNotPrimeNumber[i*count] = true;
                count++;
            }
        }
        int result = 0;
        int min = -1;
        for(int i = m; i <= n; i++){
            if(!isNotPrimeNumber[i]){
                if(min == -1) min = i;
                result += i;
            }

        }

        if(min == -1) {
            System.out.println(min);
            return;
        }

        System.out.println(result);
        System.out.println(min);
        bw.flush();
        bw.close();
    }
}
