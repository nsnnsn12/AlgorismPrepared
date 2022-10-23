package sunggyu.backjun.condigTest1.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/10844
//쉬운 계단 수
/*
    길이가 n인 계단 수 = 길이가 n-1인 계단 수의 +, -
    0으로 끝나는 계단 수는 +밖에 못함.
    9로 끝나는 계단 수는 -밖에 못함.
    나머지는 +,-;

    고로 각 길이가 n인 계단 수의 끝자리의 숫자를 저장하면 됨.

*/
public class Dp8_review{
    static final int MOD = 1000000000;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        int[][] list = new int[n][10];
        for(int i = 1; i < 10; i++){
            list[0][i] = 1;
        }

        for(int i = 1; i < n; i++){
            list[i][1] = list[i-1][0];
            list[i][8] = list[i-1][9];
            for(int j = 1; j < 9; j++){
                int value = list[i-1][j];
                list[i][j-1] = add(value, list[i][j-1]);
                list[i][j+1] = add(value, list[i][j+1]);
            }
        }
        
        int result = 0;
        for(int i = 0; i < 10; i++){
            result = add(list[n-1][i], result);
        }

        System.out.println(result);
        bw.flush();
        bw.close();
    }
    public static int multiple(int a, int b){
        return ((a % MOD) * (b % MOD)) % MOD;
    }
    public static int add(int a, int b){
        return ((a % MOD) + (b % MOD)) % MOD;
    }

    public static int minus(int a, int b){
        return ((a % MOD) - (b % MOD) + MOD) % MOD;
    }
    
}
