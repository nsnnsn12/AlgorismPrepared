package sunggyu.backjun.algorism.print;

import java.io.*;

public class Print2 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int year = Integer.parseInt(bf.readLine());
        System.out.println(year-543);
        bw.flush();
        bw.close();
    }
}
