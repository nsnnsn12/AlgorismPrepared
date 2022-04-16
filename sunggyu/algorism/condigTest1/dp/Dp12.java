package sunggyu.algorism.condigTest1.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1912
//연속합
/*
    현재 인덱스를 기준으로 전 인덱스를 더했을 때 현재 인덱스보다 크면 저장
*/
public class Dp12{
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
        memo[0] = list[0];
        for(int i = 1; i < n; i++){
            int sum = memo[i-1] + list[i];
            memo[i] = list[i];
            if(list[i] < sum){
                memo[i] = sum;
            }
        }
        int result = Arrays.stream(memo).max().getAsInt();
        System.out.println(result);
        bw.flush();
        bw.close();
    }
    
    
}
