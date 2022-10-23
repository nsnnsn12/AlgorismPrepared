package sunggyu.backjun.algorism.print;

import java.io.*;
import java.util.Arrays;

public class Print3 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] chessType = {1,1,2,2,2,8};
        int[] list = Arrays.stream(bf.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray();
        for(int i = 0; i < 6; i++){
            System.out.print(chessType[i] - list[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}
