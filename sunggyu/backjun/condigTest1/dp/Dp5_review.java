package sunggyu.backjun.condigTest1.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/11052
//카드 구매하기
/*
    1. 각 장수를 뽑는 최대 금액을 구한다.(maxList)
    2. 각 장수의 최대 금액에서 n을 뽑는 최대 금액을 뽑는다.

    DP 풀 때 생각해야 하는 것 => n의 대한 계산을 하는데 필요한 n-1 등의 값은 조건에 만족한다고 생각해야 한다.
*/
public class Dp5_review{
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine())+1;
        int[] list = new int[n];
        int[] maxList = new int[n];
        String[] split = bf.readLine().split(" ");
        for(int i = 0; i < n-1; i++){
            list[i+1] = Integer.parseInt(split[i]);
            maxList[i+1] = list[i+1];
        }
        
        for(int i = 2; i < n; i++){
            int max = maxList[i];
            for(int j = 1; j <= i / 2; j++){
                int a = maxList[j];
                int b = maxList[i-j];
                max = Math.max(max, a+b);
            }
            maxList[i] = max;
        }
        System.out.println(maxList[n-1]);

        bw.flush();
        bw.close();
    }
}
