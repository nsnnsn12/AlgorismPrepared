package sunggyu.backjun.algorism.print;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Print4 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(bf.readLine());
        String b = bf.readLine();
        char[] aaa = b.toCharArray();
        for(int i = aaa.length-1; i >= 0; i--){
            int calc = a * (int)(aaa[i]-'0');
            System.out.println(calc);
        }
        System.out.println(a * Integer.parseInt(b));
        bw.flush();
        bw.close();
    }
}
