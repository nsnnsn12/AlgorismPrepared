package sunggyu.backjun.algorism.math1;

import java.io.*;

public class Math4 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] abc = bf.readLine().split(" ");
        long a = Long.parseLong(abc[0]);
        long b = Long.parseLong(abc[1]);
        long c = Long.parseLong(abc[2]);
        c -= a;
        long diff = a - b;
        long count = c / diff;
        count++;
        if(c % diff != 0){
            count++;
        }

        //달팽이가 하루동안 갈 수 있는 거리는 A - B이다.
        //하지만 낮에만 움직이는 경우는 A를 갈 수 있다.
        
        System.out.println(count);
        bw.flush();
        bw.close();
    }

}
