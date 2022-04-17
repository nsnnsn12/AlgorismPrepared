package sunggyu.algorism.condigTest1.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1699
//제곱수의 합
/*
*/
public class Dp13{
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());

        int[] memo;
        if(n > 3){
            memo = new int[n+1];
        }else{
            memo = new int[4];
        }
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 2;
        for(int i = 3; i < memo.length; i++){
            int sqrt = (int)Math.sqrt(i);
            memo[i] = 1;
            if(i != sqrt * sqrt){
                int end = i / 2;
                int min = 100000;
                for(int j = 1; j <= end; j++){
                    int temp = memo[j] + memo[i-j];
                    min = Math.min(min, temp);
                }
                memo[i] = min;
            }
        }
        System.out.println(memo[n]);

        bw.flush();
        bw.close();
    }
    
    
}
