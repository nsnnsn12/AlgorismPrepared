package sunggyu.backjun.algorism.ifelse;

import java.io.*;

public class If2 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] hm = bf.readLine().split(" ");
        int h = Integer.parseInt(hm[0]);
        int m = Integer.parseInt(hm[1]);
        if(m - 45 < 0){
            h = h - 1 < 0 ? 23 : h-1;
        }
        m = m - 45 < 0 ? 60 + (m - 45) : m - 45;
        bw.write(String.format("%s %s", h, m));
        bw.flush();
        bw.close();
    }
}
