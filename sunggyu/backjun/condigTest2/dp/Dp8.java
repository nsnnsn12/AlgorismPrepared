package sunggyu.backjun.condigTest2.dp;
import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/12869
//뮤탈리스크
/*
    한 번의 3개를 공격할 수 있다.
    9, 3, 1 순으로 각각 체력이 단다.
    한 번의 공격에 동일한 요소를 선택할 수는 없다.
    0또는 그 이하가 되면 파괴된다.

    scv의 최대갯수 3개
    최대 체력 60

    공격의 최소 횟수를 구하라.

    매 공격의 순간에 3가지 공격이 어디를 향해 있어야 하는가

    [i-1][n-9];
    [i-1][n-3];
    [i-1][n-1];

    n개의 scv 체력이 다 0 이하가 될 때까지 반복해야 한다.

    완전탐색을 이용하는 경우
    n이 3일 경우 경우의 수는 6개이다.
    각 step마다 모든 경우의 수를 구한다고 했을 때
    6의 n승으로 계산이 된다.

    다이나믹 프로그래밍
    최대 체력이 60이므로 최대 공격 횟수는 60이하이다.
    그렇다면 각 공격횟수의 최적해를 구할 수 있는가?
    각 공격횟수당 경우의 수는 최대 6개이다.
    각 경우의 수에서 무엇이 최적해인지 판단할 수 있는가?

    n개의 체력합이 가장 낮다고 해서 최적해라 볼 수 있는가? X

    이것도 조합 최적화 문제인 것 같은

    각 체력의 최적해는 구할 수 있는가?
    dp[n-9] == 최적해
    
    dp[i-1][n-9]

    dp[공격횟수][체력][scvIndex] = 최적해를 포함하고 있는가?

    60 * 60 * 3

*/
public class Dp8 {
    static BufferedReader bf;
    static BufferedWriter bw;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        int[] scv = new int[n];
        String[] split = bf.readLine().split(" ");
        for(int i = 0; i < n; i++){
            scv[i] = Integer.parseInt(split[i]);
        }

        int[][][] dp = new int[61][61][n];

        for(int i = 1; i < 61; i++){
            //dp[i-1][i-9];
        }
        bw.flush();
        bw.close();
    }
}


