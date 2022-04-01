package sunggyu.algorism.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/11053
//가장 긴 증가하는 부분 수열
/*
*/
public class Dp1{
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        int[] list = new int[n];
        String[] split = bf.readLine().split(" ");
        for(int i = 0; i < n; i++){
            list[i] = Integer.parseInt(split[i]);
        }

        int[] memo = new int[n];
        Arrays.fill(memo, 1);
        for(int i = n-2; i >= 0; i--){
            int index =list[i];
            for(int j = i+1; j < n; j++){
                if(index < list[j]){
                    int count = memo[j] + 1;
                    memo[i] = count > memo[i] ? count : memo[i];
                }
            }
        }

        int max = 0;
        for(int i : memo){
            max = max > i ? max : i;
        }
        System.out.println(max);
        bw.flush();
        bw.close();
    }
}
