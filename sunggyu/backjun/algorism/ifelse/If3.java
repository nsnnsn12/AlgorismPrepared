package sunggyu.backjun.algorism.ifelse;

import java.io.*;

public class If3 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] hm = bf.readLine().split(" ");
        int h = Integer.parseInt(hm[0]);
        int m = Integer.parseInt(hm[1]);
        int c = Integer.parseInt(bf.readLine());

        int nm = (m + c) % 60;
        int nh = h + ((m+c) / 60);
        nh = nh % 24;

        bw.write(String.format("%s %s", nh, nm));
        bw.flush();
        bw.close();
    }
}
