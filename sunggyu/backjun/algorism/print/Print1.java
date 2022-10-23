package sunggyu.backjun.algorism.print;

import java.io.*;

public class Print1 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String id = bf.readLine();
        System.out.println(String.format("%s%s", id,"??!"));
        bw.flush();
        bw.close();
    }
}
