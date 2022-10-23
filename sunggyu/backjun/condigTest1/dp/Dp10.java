package sunggyu.backjun.condigTest1.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/11053
//가장 긴 증가하는 부분 수열
/*
    index를 기준으로 자기보다 값이 작고 제일 긴 수열을 가지고 있는 것을 선택
*/
public class Dp10{
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        int[] list = new int[n];
        String[] split = bf.readLine().split(" ");
        for(int i = 0; i < n; i++){
            list[i] = Integer.parseInt(split[i]);
        }
        int[] maxList = new int[n];
        maxList[0] = 1;
        for(int i = 1; i < n; i++){
            int max = 0;
            for(int j = i-1; j >= 0; j--){
                if(list[j] < list[i]){
                    max = Math.max(max, maxList[j]);
                }
            }
            maxList[i] = max + 1;
        }
        int max = 0;
        max = Arrays.stream(maxList).max().getAsInt();
        System.out.println(max);

        bw.flush();
        bw.close();
    }
    
    
}
