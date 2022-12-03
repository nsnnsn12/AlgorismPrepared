package sunggyu.backjun.algorism.array2;

import java.io.*;

public class Array1 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = bf.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);
        int[][][] arrays = new int[2][N][M];

        for(int i = 0; i < 2; i++){
            for(int x = 0; x < N; x++){
                String[] split = bf.readLine().split(" ");
                for(int y = 0; y < M; y++){
                    arrays[i][x][y] = Integer.parseInt(split[y]);
                    if(i == 1){
                        bw.write(String.format("%d ", arrays[i][x][y] + arrays[0][x][y]));
                    }
                }

                if(i== 1) bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }
}
