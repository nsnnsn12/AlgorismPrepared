package sunggyu.backjun.algorism.list;

import java.io.*;
import java.util.*;

public class List4 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(bf.readLine());
        for(int i = 0; i < T; i++){
            String[] split = bf.readLine().split(" ");
            int n = Integer.parseInt(split[0]);
            int[] scores  = new int[n];
            int total = 0;
            for(int j = 0; j < n; j++){
                scores[j] = Integer.parseInt(split[j+1]);
                total += scores[j];
            }

            double value = total / n;
            int count = 0;
            for(int j = 0; j < n; j++){
                if(scores[j] > value) count++;
            }

            bw.write(String.format("%.3f%%", (100/(double)n) * count));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
