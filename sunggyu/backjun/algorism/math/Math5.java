package sunggyu.backjun.algorism.math;

import java.io.*;

public class Math5 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(bf.readLine());
        int[][] residents = new int[15][15];
        for(int i = 0; i < 15; i++){
            residents[0][i] = i;
        }

        //k층에 n호
        //0층부터 i까지 존재
        //1호부터 i까지 존재
        //a층의 b호에 살려면 자신의 아래(a-1)층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야 한다.
        for(int i = 1; i < 15; i++){
            for(int j = 1; j < 15; j ++){
                int total = 0;
                for(int z = 0; z <= j; z++){
                    total += residents[i-1][z];
                }
                residents[i][j] = total;
            }
        }
        for(int i = 0; i < T; i++){
            int k = Integer.parseInt(bf.readLine());
            int n = Integer.parseInt(bf.readLine());
            bw.write(String.valueOf(residents[k][n]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

}
