package sunggyu.backjun.algorism.ifelse;

import java.io.*;

public class If1 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int x = Integer.parseInt(bf.readLine());
        int y = Integer.parseInt(bf.readLine());
        if(x > 0 && y > 0) System.out.println(1);
        if(x < 0 && y > 0) System.out.println(2);
        if(x < 0 && y < 0) System.out.println(3);
        if(x > 0 && y < 0) System.out.println(4);
        bw.flush();
        bw.close();
    }
}
