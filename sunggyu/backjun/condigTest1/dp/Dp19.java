package sunggyu.backjun.condigTest1.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/2156
//포도주 시식
/*
    3잔 연속으로 마실 수 없다.

    인접한 index의 최댓값 = memo[n-1][인접하지 않은 index]
    인접하지 않은 index의 최댓값 = max(memo[n-2 .... 0][인접한 Index], memo[n-2 .... 0][인접하지 않은 Index]);
    
    인접하지 않은 index의 최댓값을 방문하는 경우의 수
    n의 최대 갯수는 10000
    (10000 + 1) * (10000/2) = 50,005,000 = 대략 5천만으로 탐색 가능
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
                int maxCapacity = 0;
                for(int j = 0; j <= i - 2; j++){
                    maxCapacity = Math.max(maxCapacity, memo[j][oneBlock]);
                    maxCapacity = Math.max(maxCapacity, memo[j][twoBlock]);
                }
                memo[i][oneBlock] += maxCapacity;
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