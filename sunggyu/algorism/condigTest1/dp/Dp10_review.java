package sunggyu.algorism.condigTest1.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/11053
//가장 긴 증가하는 부분 수열
/*
    각 인덱스가 가장 긴 부분 수열을 가지고 있게 한다.

    초기 조건
    list[0] = 1;
    
    list[n] = max(list[n-1] ... list[0]) + 1;
*/
public class Dp10_review{
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        int[] list = new int[n];
        int[] countOfIndexs = new int[n];
        String[] split = bf.readLine().split(" ");
        for(int i = 0; i < n; i++){
            list[i] = Integer.parseInt(split[i]);
        }
        countOfIndexs[0] = 1;

        int max = 1;
        for(int i = 1; i < n; i++){
            int maxCount = 1;
            for(int j = i; j >= 0; j--){
                if(list[j] < list[i]){
                    maxCount = Math.max(maxCount, countOfIndexs[j] + 1);
                }
            }
            countOfIndexs[i] = maxCount;
            max = Math.max(max, maxCount);
        }

        System.out.println(max);
        
        bw.flush();
        bw.close();
    }
    
    
}
