package sunggyu.backjun.algorism.recursive;

import java.io.*;
import java.util.Arrays;

public class Recursive2 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());

        System.out.println(pabo(n));
        bw.flush();
        bw.close();
    }

    public static int pabo(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        return pabo(n-1) + pabo(n-2);
    }
}
