package sunggyu.algorism.condigTest1.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/15988
//1, 2, 3 더하기 3
/*
*/
public class Dp15{
    public static final int MOD = 1000000009;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(bf.readLine());
        int[] testCases = new int[t];
        int max = 0;
        for(int i = 0; i < t; i++){
            testCases[i] = Integer.parseInt(bf.readLine());
            max = Math.max(testCases[i], max);
        }

        int[] memo = new int[max+3];
        memo[1] = 1;
        memo[2] = 2;
        memo[3] = 4;

        for(int i = 4; i < memo.length; i++){
            int sum = 0;
            for(int j = 1; j <= 3; j++){
                sum = sum(sum, memo[i-j]);
            }
            memo[i] = sum;
        }
        for(int i = 0; i < t; i++){
            bw.write(memo[testCases[i]]+"\n");
        }
        bw.flush();
        bw.close();
    }

    public static int sum(int a, int b){
        return ((a % MOD) + (b % MOD)) % MOD;
    }
    
    
}
