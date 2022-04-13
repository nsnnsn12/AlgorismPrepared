package sunggyu.algorism.condigTest1.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/16194
//카드 구매하기 2
/*
    n개의 리스트가 주어졌을 때
    리스트 내의 요소의 최대합을 구하라.
    
    각 요소를 이루는 최솟값을 구한다.


*/
public class Dp6{
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine()) + 1;
        int[] list = new int[n];
        int[] minList = new int[n];
        String[] split = bf.readLine().split(" ");
        for(int i = 1; i < n; i++){
            list[i] = Integer.parseInt(split[i-1]);
        }
        minList[1] = list[1];

        for(int i = 2; i < n; i++){
            int min = list[i];
            for(int j = i - 1; j >= 1; j--){
                int a = j;
                int b = i - j;
                int sum = minList[a] + minList[b];
                min = Math.min(min, sum);
            }
            minList[i] = min;
        }

        System.out.println(minList[n-1]);

        bw.flush();
        bw.close();
    }
}
