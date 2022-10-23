package sunggyu.backjun.condigTest1.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/11726
//2×n 타일링
/*
    n이 1일 때 경우의 수 1개
    n이 2일 때 경우의 수 2개
    n을 구하는 방법 = n-1 + n-2
    타일을 세로로 놓는 경우 n-1
    타일을 가로로 놓는 경우 n-2
*/
public class Dp2{
    public static final int MOD = 10007;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        int[] list = new int[n];
        list[0] = 1;
        if(n > 1){
            list[1] = 2;
        }
        for(int i = 2; i < list.length; i++){
            int a = list[i-1];
            int b = list[i-2];
            list[i] = add(a, b);
        }

        System.out.println(list[n-1]);
        bw.flush();
        bw.close();
    }

    public static int add(int a, int b){
        return ((a % MOD) + (b% MOD)) % MOD;
    }

    public static int multiple(int a, int b){
        return ((a % MOD) * (b % MOD)) % MOD;
    }

    public static int minus(int a, int b){
        return ((a % MOD) - (b % MOD) + MOD) % MOD;
    }
}
