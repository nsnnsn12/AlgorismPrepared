package sunggyu.backjun.condigTest1.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1463
//1로 만들기
/*

    bottomUp은 통과
    topDown은 시간초과

    dp를 사용할 때는 최대한 bottomUp 사용

    정수 X를 3가지의 연산을 이용하여 1로 만드는 최소 연산 횟수를 구하라.
    1. 3으로 나누어 떨어지는 경우
    2. 2로 나누어 떨어지는 경우
    3. 1을 빼는 경우
    
    초기 조건
    1 = 0

    X = min(X % 3, X % 2, X - 1) + 1
*/
public class Dp1_review{
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        int[] list = new int[n+1];

        bottomUp(list);
        System.out.println(list[n]);
        bw.flush();
        bw.close();
    }

    public static void bottomUp(int[] list){
        for(int i = 2; i < list.length; i++){
            int min = list[i-1];
            if(i % 2 == 0) min = Math.min(min, list[i / 2]);

            if(i % 3 == 0) min = Math.min(min, list[i / 3]);

            list[i] = min + 1;
        }
    }

    
}
