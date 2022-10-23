package sunggyu.backjun.condigTest1.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/11722
//가장 긴 감소하는 부분 수열
/*
*/
public class Dp22{
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        int[] list = new int[n];
        int[] maxLengths = new int[n];
        String[] split = bf.readLine().split(" ");
        list[0] = Integer.parseInt(split[0]);
        maxLengths[0] = 1;
        for(int i = 1; i < n; i++){
            list[i] = Integer.parseInt(split[i]);
            maxLengths[i] = 1;
            int max = 0;
            for(int j = 0; j < i; j++){
                if(list[i] < list[j]){
                    max = Math.max(maxLengths[j], max);
                }
            }
            maxLengths[i] += max;
        }
        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max, maxLengths[i]);
        }

        System.out.println(max);
        bw.flush();
        bw.close();
    }
}