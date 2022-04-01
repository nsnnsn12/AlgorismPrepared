package sunggyu.algorism.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1149
//RGB거리
/*
    각각의 집에 빨강, 초록, 파랑으로 칠하는 값이 주어진다.
    이웃하는 집은 색이 같으면 안 된다.
    이 조건을 만족하는 최솟값을 구하라.

    각각의 집이 빨강, 초록, 파랑이였을 경우의 최솟값을 구하면 된다.

    최대 1000개의 집이 주어짐.
    1000 * 3 * 2 = 6000
*/
public class Dp2{
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        //0:빨강, 1:초록, 2:파랑
        int[][] rgbs = new int[n][3];
        for(int i = 0; i < n; i++){
            String[] split = bf.readLine().split(" ");
            for(int j = 0; j < 3; j++){
                rgbs[i][j] = Integer.parseInt(split[j]);
            }
        }
        int[][] memo = new int[n][3];
        memo[n-1][0] = rgbs[n-1][0];
        memo[n-1][1] = rgbs[n-1][1];
        memo[n-1][2] = rgbs[n-1][2];

        for(int i = n-2; i >= 0; i--){
            for(int j = 0; j < 3; j++){
                memo[i][j] = rgbs[i][j];
                int beforeRed = memo[i+1][0];
                int beforeGreen = memo[i+1][1];
                int beforeBlue = memo[i+1][2];
                if(j == 0){
                    memo[i][j] += beforeGreen < beforeBlue ? beforeGreen : beforeBlue;
                }else if(j == 1){
                    memo[i][j] += beforeRed < beforeBlue ? beforeRed : beforeBlue;
                }else{
                    memo[i][j] += beforeRed < beforeGreen ? beforeRed : beforeGreen;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++){
            min = min < memo[0][i] ? min : memo[0][i];
        }

        System.out.println(min);

        bw.flush();
        bw.close();
    }
}
