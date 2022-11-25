package sunggyu.backjun.algorism.math;

import java.io.*;

public class Math7 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(bf.readLine());
        for(int i = 0; i < t; i++){
            String[] hwn = bf.readLine().split(" ");
            int h = Integer.parseInt(hwn[0]);
            int w = Integer.parseInt(hwn[1]);
            int n = Integer.parseInt(hwn[2])-1;
            if(n == 0){
                bw.write("101");
                bw.newLine();
                continue;
            }

            int hosu = (n/h) + 1;
            int floor = (n % h) + 1;
            String result = String.valueOf(floor);
            if(hosu < 10) result += "0";
            result += String.valueOf(hosu);
            bw.write(result);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

}
