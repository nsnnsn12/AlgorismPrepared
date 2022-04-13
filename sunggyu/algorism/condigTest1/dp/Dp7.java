package sunggyu.algorism.condigTest1.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/15990
//1, 2, 3 더하기 5
/*
    같은 수를 연속해서 2번 이상 사용하면 안 된다.
    list[n-1]은 1로 시작하는 모든 경우의 수를 의미한다.
    list[n-2]은 2로 시작하는 모든 경우의 수를 의미한다.
    list[n-3]은 3로 시작하는 모든 경우의 수를 의미한다.
    고로 1,2,3으로 시작하는 경우의 수를 저장하고
    1로 시작하는 경우 1로 시작하는 경우의 수를 뺀다.
*/
public class Dp7{
    static int MOD = 1000000009;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(bf.readLine());
        int[] test = new int[t];
        for(int i = 0; i < t; i++){
            test[i] = Integer.parseInt(bf.readLine());
        }
        int[] list = new int[100001];
        int[][] startNumberCounts = new int[100001][3];
        list[0] = 1;
        startNumberCounts[0][0] = 1;
        list[1] = 1;
        startNumberCounts[1][1] = 1;
        list[2] = 3;
        startNumberCounts[2][0] = 1;
        startNumberCounts[2][1] = 1;
        startNumberCounts[2][2] = 1;

        for(int i = 3; i < list.length; i++){
            int sum = 0;
            for(int j = 1; j < 4; j++){
                int cases = getCases(i, list, j, startNumberCounts);
                startNumberCounts[i][j-1] = cases;
                sum = add(cases, sum);
            }
            list[i] = sum;
        }

        for(int i = 0; i < t; i++){
            System.out.println(list[test[i]-1]);
        }
        bw.flush();
        bw.close();
    }
    public static int getCases(int index, int[] list, int startNumber, int[][] startNumberCounts){
        int result = 0;
        int cases = list[index - startNumber];
        int startNumberCount = startNumberCounts[index - startNumber][startNumber - 1];
        result = minus(cases, startNumberCount);
        return result;
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
