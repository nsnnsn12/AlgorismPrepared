package sunggyu.backjun.condigTest1.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/15990
//1, 2, 3 더하기 5
/*
    numbersOfCases

    경우의 수들[n] = 경우의 수들[n-1] + 경우의 수들[n-2] + 경우의 수들[n-3];
    같은 수를 연속해서 2번 이상 사용하면 안 된다.
    list[n-1]은 1로 시작하는 모든 경우의 수를 의미한다.
    list[n-2]은 2로 시작하는 모든 경우의 수를 의미한다.
    list[n-3]은 3로 시작하는 모든 경우의 수를 의미한다.
    
    1로 시작하는 경우 1로 시작하는 경우의 수를 뺀다.
    2로 시작하는 경우 2로 시작하는 경우의 수를 뺀다.
    3로 시작하는 경우 3로 시작하는 경우의 수를 뺀다.
    그리고 저장
*/
public class Dp7_review{
    static int MOD = 1000000009;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(bf.readLine());
        int[] test = new int[t];
        int max = 0;
        for(int i = 0; i < t; i++){
            test[i] = Integer.parseInt(bf.readLine());
            max = Math.max(max, test[i]);
        }

        int[] numbersOfCases = getNumbersOfCases(max+3);

        for(int i = 0; i < t; i++){
            bw.write(numbersOfCases[test[i]-1]+"\n");
        }
        bw.flush();
        bw.close();
    }

    public static int[] getNumbersOfCases(int n){
        int[] numbersOfCases = initNumbersOfCases(n);
        int[][] startOneAndTwoAndThreeOfCases = initStartOneAndTwoAndThreeOfCases(n);

        for(int i = 3; i < n; i++){
            int numberOfCases = getCase(i,numbersOfCases, startOneAndTwoAndThreeOfCases);

            numbersOfCases[i] = numberOfCases;
        }
        return numbersOfCases;
    }

    public static int[][] initStartOneAndTwoAndThreeOfCases(int n){
        int[][] startOneAndTwoAndThreeOfCases = new int[n][3];

        startOneAndTwoAndThreeOfCases[0][0] = 1;
        startOneAndTwoAndThreeOfCases[0][1] = 0;
        startOneAndTwoAndThreeOfCases[0][2] = 0;

        startOneAndTwoAndThreeOfCases[1][0] = 0;
        startOneAndTwoAndThreeOfCases[1][1] = 1;
        startOneAndTwoAndThreeOfCases[1][2] = 0;

        startOneAndTwoAndThreeOfCases[2][0] = 1;
        startOneAndTwoAndThreeOfCases[2][1] = 1;
        startOneAndTwoAndThreeOfCases[2][2] = 1;

        return startOneAndTwoAndThreeOfCases;
    }

    public static int[] initNumbersOfCases(int n){
        int[] numbersOfCases = new int[n];
        numbersOfCases[0] = 1;
        numbersOfCases[1] = 1;
        numbersOfCases[2] = 3;

        return numbersOfCases;
    }

    public static int getCase(int now, int[] numbersOfCases, int[][] startOneAndTwoAndThreeOfCases){
        int result = 0;
        for(int i = 1; i <= 3; i++){
            int index = now - i;
            int minus = minus(numbersOfCases[index], startOneAndTwoAndThreeOfCases[index][i-1]);
            startOneAndTwoAndThreeOfCases[now][i-1] = minus;
            result = add(result, minus);
        }

        return result;
    }

    public static int add(int a, int b){
        return ((a % MOD) + (b % MOD)) % MOD;
    }

    public static int minus(int a, int b){
        return ((a % MOD) - (b % MOD) + MOD) % MOD;
    }
}
