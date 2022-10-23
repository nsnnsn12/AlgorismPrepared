package sunggyu.backjun.condigTest1.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1912
//연속합
/*
    maxList[n] = max(list[n], maxList[n-1]+list[n])
*/
public class Dp12_review{
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        int[] list = new int[n];
        int[] maxList = new int[n];
        String[] split = bf.readLine().split(" ");
        for(int i = 0; i < n; i++){
            list[i] = Integer.parseInt(split[i]);
        }
        maxList[0] = list[0];
        for(int i = 1; i < n; i++){
            int value = maxList[i-1] + list[i];
            maxList[i] = Math.max(value, list[i]);
        }

        int result = Arrays.stream(maxList).max().getAsInt();
        System.out.println(result);
        bw.flush();
        bw.close();
    }
    
    
}
