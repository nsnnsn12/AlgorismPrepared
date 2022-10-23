package sunggyu.backjun.condigTest1.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/10844
//쉬운 계단 수
/*
    자릿수를 입력받는다. 최대 100자리
    인접한 모든 자릿수의 차이가 1인 경우를 계단수라고 한다.
    +1, -1이므로 경우의 수는 *2를 하면 됨.
    단 0과 9의 경우 경우의 수가 1개이기 때문에 해당 처리만 하면 될 듯
    자릿수가 늘어날 때마다 0과 9의 갯수가 몇 개인지 파악하면 될 듯

    고록 각 자릿수의 갯수를 저장
*/
public class Dp8{
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
            for(int j = 1; j < 9; j++){
                list[i][j-1] = add(list[i][j-1], list[i-1][j]);
                list[i][j+1] = add(list[i][j+1], list[i-1][j]);
            }
            list[i][8] = add(list[i-1][9], list[i][8]);
        }
        int result = 9;
        for(int i = 1; i < n; i++){
            result = multiple(result, 2);
            int sum = add(list[i-1][0], list[i-1][9]);
            result = minus(result, sum);
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
