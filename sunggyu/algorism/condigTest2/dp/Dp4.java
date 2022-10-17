package sunggyu.algorism.condigTest2.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/15989
//1, 2, 3 더하기 4
/*
    정수 n을 1,2,3의 요소를 더하여 나타내라
    합을 나타낼 때는 수를 1개 이상 사용해야 한다.
    합을 이루고 있는 수의 순서만 다른 것은 같은 것으로 친다.
    
    경우의 수
    1 => 1
    2 => 2
    3 => 3
    4 => 

    n-1
    n-2
    n-3 
*/
public class Dp4 {
    static BufferedReader bf;
    static BufferedWriter bw;
    static int T;
    static int[] dp = new int[10001];
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(bf.readLine());
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;
        for(int i = 5; i < dp.length; i++){
            int total = 0;
            total += dp[i-1];
            total += dp[i-2];
            total += dp[i-3];

            //경우의 수가 중복되는 것을 어떻게 해결할 것인가?

            dp[i] = total;
        }

        for(int i = 0; i < T; i++){
            int index = Integer.parseInt(bf.readLine());
            bw.write(String.valueOf(dp[index]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}


