package sunggyu.algorism.dp.silver1;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/10844
//쉬운 계단 수
/*
    인접한 모든 자리의 차이가 1이다.
    각 자릿수는 첫번째를 제외하고 0~9로 이루어져 있다.
    각 자릿수의 1을 더하거나 1을 빼는 것으로 조건을 만족시킬 수 있다.
    이 말은 각 자릿수마다 경우의 수가 2개가 생긴다는 의미
    단 0은 더할 수만 있고 9는 뺄 수만 있음으로 경우의 수가 1
    그렇다면 각 자릿수마다 2를 곱하고 0과 9의 갯수만큼만 빼면 되지 않나?

    list[0] = 9;
    list[n] = list[n-1] * 2 - (list[n-1]에 존재하는 0과 9의 갯수)

    그렇다면 각 자릿수마다 0과 9의 갯수는 어떻게 알 수 있는가?
    n번에 0~9까지의 갯수를 이용하여 n+1의 0~9까지의 값을 알 수 있음
    예)n에 1이 5개 있다면 n+1은 0과 2가 5개 존재하게 되는 것
    
*/
public class Dp4{
    public static final int MOD = 1000000000;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        int[] list = new int[n];

        //각 depth마다 0~9까지의 갯수를 구함
        int[][] numberCountOfDepth = new int[n][10];

        for(int i = 1; i < 10; i++){
            numberCountOfDepth[0][i] = 1;
        }
        //구한 값을 이용하여 계산
        for(int i = 1; i< n; i++){
            numberCountOfDepth[i][1] = numberCountOfDepth[i-1][0];
            for(int j = 1; j < 9; j++){
                int beforeCount = numberCountOfDepth[i-1][j];
                numberCountOfDepth[i][j+1] = add(numberCountOfDepth[i][j+1], beforeCount);
                numberCountOfDepth[i][j-1] = add(numberCountOfDepth[i][j-1], beforeCount);

            }
            numberCountOfDepth[i][8] = add(numberCountOfDepth[i][8], numberCountOfDepth[i-1][9]);
        }
        list[0] = 9;

        for(int i = 1; i < n; i++){
            int temp = multiple(list[i-1], 2);
            temp = minus(temp ,numberCountOfDepth[i-1][0]);
            temp = minus(temp ,numberCountOfDepth[i-1][9]);
            list[i] = temp;
        }
        System.out.println(list[n-1]);


        bw.flush();
        bw.close();
    }

    public static int add(int a, int b){
        return ((a % MOD) + (b % MOD)) % MOD;
    }

    public static int multiple(int a, int b){
        return ((a % MOD) * (b % MOD)) % MOD;
    }

    public static int minus(int a, int b){
        return ((a % MOD) - (b % MOD) + MOD) % MOD;
    }
}
