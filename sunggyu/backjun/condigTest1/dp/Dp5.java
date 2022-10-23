package sunggyu.backjun.condigTest1.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/11052
//카드 구매하기
/*
    n개의 리스트가 주어졌을 때
    리스트 내의 요소의 최대합을 구하라.
    
    각 요소를 이루는 최댓값을 구한다.


*/
public class Dp5{
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine()) + 1;
        int[] list = new int[n];
        int[] maxList = new int[n];
        String[] split = bf.readLine().split(" ");
        for(int i = 1; i < n; i++){
            list[i] = Integer.parseInt(split[i-1]);
        }
        maxList[1] = list[1];

        for(int i = 2; i < n; i++){
            int max = list[i];
            for(int j = i - 1; j >= 1; j--){
                int a = j;
                int b = i - j;
                int sum = maxList[a] + maxList[b];
                max = Math.max(max, sum);
            }
            maxList[i] = max;
        }

        System.out.println(maxList[n-1]);

        bw.flush();
        bw.close();
    }
}
