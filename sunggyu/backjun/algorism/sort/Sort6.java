package sunggyu.backjun.algorism.sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort6 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] list = bf.readLine().toCharArray();
        Arrays.sort(list);
        for(int i = list.length-1; i >= 0; i--){
            bw.write(String.valueOf(list[i]));
        }
        bw.flush();
        bw.close();
    }
    
}
