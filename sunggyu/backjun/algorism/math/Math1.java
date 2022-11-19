package sunggyu.backjun.algorism.math;

import java.io.*;

public class Math1 {
    /*
     * A : 고정 급여
     * B : 가변 급여
     * C : 노트북 급여
     */
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] abc = bf.readLine().split(" ");
        long a = Long.parseLong(abc[0]);
        long b = Long.parseLong(abc[1]);
        long c = Long.parseLong(abc[2]);

        long rest = c - b;
        if(rest < 1){
            System.out.println("-1");
            return;
        }

        if(a == 0){
            System.out.println("1");
            return;
        }
        long count = a / rest;

        System.out.println(count+1);
        bw.flush();
        bw.close();
    }
}
