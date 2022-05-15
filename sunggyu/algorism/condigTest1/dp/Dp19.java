package sunggyu.algorism.condigTest1.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/2156
//포도주 시식
/*
    3잔 연속으로 마실 수 없다.

    각 인덱스는 n-1을 방문할 때, n-2부터 방문할 때의 정보가 있어야 한다.
    내가 제대로 이해하지 못 하기 때문에 예외가 생긴다.
*/
public class Dp19{
    public static final int oneBlock = 0;
    public static final int twoBlock = 1;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        
        int[][] memo = new int[n][2];
        for(int i = 0; i < n; i++){
            int value = Integer.parseInt(bf.readLine());
            memo[i][0] = value;
            memo[i][1] = value;
        }
        //memo[i][0] 인접한 index를 방문한 값
        //memo[i][1] 한 칸 떨어진 index를 방문한 값
        for(int i = 1; i < n; i++){
            //인접한 경우
            memo[i][twoBlock] += memo[i-1][oneBlock];

            //인접하지 않은 경우
            if(i - 2 >= 0){
                memo[i][oneBlock] += memo[i-2][twoBlock];
            }
            
        }

        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max, memo[i][0]);
            max = Math.max(max, memo[i][1]);
        }

        System.out.println(max);
        bw.flush();
        bw.close();
    }
}