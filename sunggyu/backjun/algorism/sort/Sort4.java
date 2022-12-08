package sunggyu.backjun.algorism.sort;

import java.io.*;

public class Sort4 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] counts = new int[1000001];
        int N = Integer.parseInt(bf.readLine());
        for(int i = 0; i < N; i++){
            int index = Integer.parseInt(bf.readLine());
            counts[index]++;
        }

        for(int i = 1; i < counts.length; i++){
            for(int j = 0; j < counts[i]; j++){
                bw.write(String.valueOf(i));
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }
    
}
