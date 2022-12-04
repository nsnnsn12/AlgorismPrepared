package sunggyu.backjun.algorism.array2;

import java.io.*;

public class Array3 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[][] matrix = new boolean[100][100];

        int T = Integer.parseInt(bf.readLine());
        for(int i = 0; i < T; i++){
            String[] split = bf.readLine().split(" ");
            int leftDistance = Integer.parseInt(split[0]);
            int downDistance = Integer.parseInt(split[1]);
            markMatrix(matrix, leftDistance, downDistance);

        }
        int count = 0;
        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                if(matrix[i][j]) count++;
            }
        }

        System.out.println(count);
        bw.flush();
        bw.close();
    }

    public static void markMatrix(boolean[][] matrix, int leftDistance, int downDistance){
        for(int i = 0; i < 10; i++){
            int x = 99-downDistance-i;
            for(int j = 0; j < 10; j++){
                int y = leftDistance + j;
                matrix[x][y] = true;
            }
        }
    }
}
