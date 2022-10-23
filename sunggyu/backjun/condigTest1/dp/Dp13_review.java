package sunggyu.backjun.condigTest1.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1699
//제곱수의 합
/*
    n
*/
public class Dp13_review{
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        int[] memo = new int[n+1];
        memo[1] = 1;
        for(int i = 2; i <= n; i++){
            int sqrt = (int)Math.sqrt(i);
            int min = 100000;
            if(sqrt * sqrt == i){
                memo[i] = 1;
                continue;
            }
            for(int j = 1; j <= i/2; j++){
                min = Math.min(min, memo[j] + memo[i-j]);
            }
            memo[i] = min;
        }
        System.out.println(memo[n]);
        bw.flush();
        bw.close();
    }
    
    
}
