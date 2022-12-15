package sunggyu.backjun.algorism.recursive;

import java.io.*;
import java.util.Arrays;

public class Recursive1 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());

        System.out.println(recursive(n));
        bw.flush();
        bw.close();
    }

    public static int recursive(int n){
        if(n == 0) return 1;
        return n * recursive(n-1);
    }
}
