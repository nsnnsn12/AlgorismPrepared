package sunggyu.backjun.algorism.math;

import java.io.*;

public class Math3 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        System.out.println(result(n));
        bw.flush();
        bw.close();
    }

    public static String result(int n){
        boolean isOrder = true;
        int row = 1;
        int total = 1;
        while(total < n){
            row++;
            total += row;
            isOrder = !isOrder;
        }
        if(row == 1){
            return "1/1";
        }
        int count = row - (total - n)-1;
        int a = !isOrder ? 1 : row;
        int b = !isOrder ? row : 1;

        for(int i = 0; i < count; i++){
            a += !isOrder ? 1 : -1;
            b += !isOrder ? -1 : 1;
        }
        return String.format("%d/%d", a,b);
    }
}
