package sunggyu.backjun.condigTest1.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1149
//RGB거리
/*
    인접한 두 집간의 색이 같지 않아야 한다.
    결국 n은 n - 1과 색이 같지 않아야 한다.

    각 색의 경우에 최소 값을 가지고 있는다.
*/
public class Dp16{
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        int[][] rgbs = new int[n][3];
        int[][] minRgbs = new int[n][3];
        for(int i = 0; i < n; i++){
            String[] split = bf.readLine().split(" ");
            for(int j = 0; j < 3; j++){
                rgbs[i][j] = Integer.parseInt(split[j]);
            }
        }
        minRgbs[0][0] = rgbs[0][0];
        minRgbs[0][1] = rgbs[0][1];
        minRgbs[0][2] = rgbs[0][2];
        for(int i = 1; i < n; i++){
            minRgbs[i][0] = rgbs[i][0] + Math.min(minRgbs[i-1][1], minRgbs[i-1][2]);
            minRgbs[i][1] = rgbs[i][1] + Math.min(minRgbs[i-1][0], minRgbs[i-1][2]);
            minRgbs[i][2] = rgbs[i][2] + Math.min(minRgbs[i-1][0], minRgbs[i-1][1]);
        }
        int min = Math.min(minRgbs[n-1][0], minRgbs[n-1][1]);
        min = Math.min(min, minRgbs[n-1][2]);
        System.out.println(min);
        bw.flush();
        bw.close();
    }
}
