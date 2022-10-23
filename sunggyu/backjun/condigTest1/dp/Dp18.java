package sunggyu.backjun.condigTest1.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/11057
//오르막 수
/*
    각 길이가 끝나는 숫자의 경우의 수를 다 저장한다.
*/
public class Dp18{
    public static int MOD = 10007;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        int[][] memo = new int[n][10];
        for(int i = 0; i < 10; i++){
            memo[0][i] = 1;
        }

        for(int i = 1; i < n; i++){
            for(int startIndex = 0; startIndex < 10; startIndex++){
                int value = memo[i-1][startIndex];
                setValue(memo, startIndex, i, value);
            }
        }

        int result = 0;
        for(int i = 0; i < 10; i++){
            result = sum(result, memo[n-1][i]);
        }

        System.out.println(result);
        bw.flush();
        bw.close();
    }
    public static void setValue(int[][] memo, int startIndex, int index, int value){
        for(int i = startIndex; i < 10; i++){
            memo[index][i] = sum(memo[index][i], value);
        }
    }

    public static int sum(int a, int b){
        return ((a % MOD) + (b % MOD)) % MOD;
    }
}
