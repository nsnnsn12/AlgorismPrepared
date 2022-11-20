package sunggyu.backjun.algorism.math;

import java.io.*;

public class Math2 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long n = Long.parseLong(bf.readLine());
        //1, 7, 19, 37, 61, 
        long count = 1L;
        long valid = 1L;

        while(valid < n){
            valid += 6 * count;
            count++;
        }
        System.out.println(count);
        bw.flush();
        bw.close();
    }
}
