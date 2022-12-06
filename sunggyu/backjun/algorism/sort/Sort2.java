package sunggyu.backjun.algorism.sort;

import java.io.*;
import java.util.Arrays;

public class Sort2 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nk = bf.readLine().split(" ");
        int N = Integer.parseInt(nk[0]);
        int K = Integer.parseInt(nk[1]);
        int[] list = new int[N];
        String[] split = bf.readLine().split(" ");
        for(int i = 0; i < N; i++){
            list[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(list);
        System.out.println(list[N-K]);
        bw.flush();
        bw.close();
    }
}
