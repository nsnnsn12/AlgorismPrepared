package sunggyu.backjun.condigTest1.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/14002
//가장 긴 증가하는 부분 수열 4
/*
    각 경우의 수의 가장 작은 값을 선택하면 됨.
*/
public class Dp11{
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
        int[] results = new int[max];
        int startIndex = list.length-1;
        for(int i = max; i > 0; i--){
            int min = 1001;
            int minIndex = 1001;
            for(int j = startIndex; j >= 0; j--){
                if(maxList[j] == i){
                    if(min > list[j]){
                        min = list[j];
                        minIndex = j;
                    }
                }
            }

            results[i-1] = min;
            startIndex = minIndex;
        }
        StringBuilder sb = new StringBuilder();
        for(int i : results){
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString().trim());


        bw.flush();
        bw.close();
    }
    
    
}
