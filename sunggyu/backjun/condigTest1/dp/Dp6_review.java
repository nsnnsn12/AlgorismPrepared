package sunggyu.backjun.condigTest1.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/16194
//카드 구매하기 2
/*

*/
public class Dp6_review{
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine())+1;
        int[] list = new int[n];
        int[] minList = new int[n];
        String[] split = bf.readLine().split(" ");
        for(int i = 0; i < n-1; i++){
            list[i+1] = Integer.parseInt(split[i]);
            minList[i+1] = list[i+1];
        }
        
        for(int i = 2; i < n; i++){
            int min = minList[i];
            for(int j = 1; j <= i / 2; j++){
                int a = minList[j];
                int b = minList[i-j];
                min = Math.min(min, a+b);
            }
            minList[i] = min;
        }
        System.out.println(minList[n-1]);

        bw.flush();
        bw.close();
    }
}
