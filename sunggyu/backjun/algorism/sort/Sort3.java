package sunggyu.backjun.algorism.sort;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Sort3 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bf.readLine());
        int[] list = new int[N];
        
        for(int i = 0; i < N; i++){
            list[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(list);
        for(int i = 0; i < N; i++){
            bw.write(String.format("%d %n", list[i]));
        }
        bw.flush();
        bw.close();
    }
    
}
