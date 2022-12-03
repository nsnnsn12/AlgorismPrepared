package sunggyu.backjun.algorism.array2;

import java.io.*;

public class Array2 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int max = 0;
        int[] xy = new int[2];
        for(int i = 0; i < 9; i++){
            String[] split = bf.readLine().split(" ");
            for(int j = 0; j < 9; j++){
                int n = Integer.parseInt(split[j]);
                if(n > max){
                    max = n;
                    xy[0] = i;
                    xy[1] = j;
                }
            }
        }

        System.out.println(max);
        System.out.println(String.format("%d %d", xy[0]+1, xy[1]+1));
        bw.flush();
        bw.close();
    }
}
