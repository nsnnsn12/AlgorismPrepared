package sunggyu.algorism.condigTest1.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/11055
//가장 큰 증가 부분 수열
/*
*/
public class Dp21{
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        int[] list = new int[n];
        int[] maxList = new int[n];
        String[] split = bf.readLine().split(" ");
        list[0] = Integer.parseInt(split[0]);
        maxList[0] = list[0];
        for(int i = 1; i < n; i++){
            list[i] = Integer.parseInt(split[i]);
            int max = 0 ;
            for(int j = 0; j < i; j++){
                if(list[j] < list[i]){
                    max = Math.max(max, maxList[j]);
                }
            }
            maxList[i] = list[i] + max;
        }

        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(maxList[i], max);
        }

        System.out.println(max);
        bw.flush();
        bw.close();
    }
}