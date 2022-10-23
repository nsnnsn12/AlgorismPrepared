package sunggyu.backjun.condigTest1.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1309
//동물원
/*
    n = 1일 때 경우
    왼쪽만, 오른쪽만, 둘 다 없을 때

*/
public class Dp17{
    public static int MOD = 9901;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int NONE = 2;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        int[][] cases = new int[n][3];
        cases[0][LEFT] = 1;
        cases[0][RIGHT] = 1;
        cases[0][NONE] = 1;
        for(int i = 1; i < n; i++){
            cases[i][LEFT] = sum(cases[i-1][RIGHT], cases[i-1][NONE]);
            cases[i][RIGHT] = sum(cases[i-1][LEFT], cases[i-1][NONE]);
            cases[i][NONE] = sum(cases[i-1][LEFT], cases[i-1][NONE]);
            cases[i][NONE] = sum(cases[i][NONE], cases[i-1][RIGHT]);
        }
        int result = sum(cases[n-1][RIGHT], cases[n-1][NONE]);
        result = sum(result, cases[n-1][LEFT]);
        System.out.println(result);
        bw.flush();
        bw.close();
    }

    public static int sum(int a, int b){
        return ((a % MOD) + (b % MOD)) % MOD;
    }
}
