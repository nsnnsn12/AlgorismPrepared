package sunggyu.backjun.condigTest2.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/15989
//1, 2, 3 더하기 4
/*
    정수 n을 1,2,3의 요소를 더하여 나타내라
    합을 나타낼 때는 수를 1개 이상 사용해야 한다.
    합을 이루고 있는 수의 순서만 다른 것은 같은 것으로 친다.
    
    n-1은 1로 시작하는 경우의 수
    n-2는 2로 시작하는 경우의 수
    n-3은 3으로 시작하는 경우의 수
    
    n을 만드는 경우의 수
    dp[n-1] + dp[n-2] + dp[n-3] - 중복되는 요소
    
    중복되는 요소는 무엇인가?
    dp[n-1]
    n의 요소를 만드는데 
    1로 시작하는 경우, 2로 시작하는 경우, 3으로 시작하는 경우를 각각 메모제이션한다.
    왜? 중복되는 요소를 지우기 위해서

    핵심은 n을 이루는 1,2,3의 요소 갯수가 중복되는 경우가 없어야 한다.
    4의 값을 구한다고 해보자.
    n - 1인 3을 만드는 경우의 수에는  
    n - 2인 2를 만드는 경우의 수가 포함되어 있을 수 밖에 없다.
    고로 2를 만드는 경우의 수에서 3을 만드는 경우의 수를 제거해야 한다.
*/
public class Dp4 {
    static BufferedReader bf;
    static BufferedWriter bw;
    static int T;
    static int[][] dp = new int[10001][4];
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(bf.readLine());
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 2;
        dp[3][3] = 1;

        for(int i = 4; i < dp.length; i++){
            dp[i][1] = dp[i-1][1] + dp[i-1][2] + dp[i-1][3];
            dp[i][2] = dp[i-2][2] + dp[i-2][3];
            dp[i][3] = dp[i-3][3];
        }

        for(int i = 0; i < T; i++){
            int index = Integer.parseInt(bf.readLine());
            int result = dp[index][1] + dp[index][2] + dp[index][3];
            bw.write(String.valueOf(result));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}


