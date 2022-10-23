package sunggyu.backjun.condigTest1.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/9095  
//1, 2, 3 더하기
/*
    초기 조건
    n이 1일 때 경우의 수 1개
    n이 2일 때 경우의 수 2개
    n이 3일 때 경우의 수 4개

    n = list[n-1] + list[n-2] + list[n-3];
*/
public class Dp4_review{
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(bf.readLine());
        int[] testResult = new int[t];
        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(bf.readLine());
            int[] list = new int[n+2];

            list[0] = 1;
            list[1] = 2;
            list[2] = 4;

            for(int j = 3; j < list.length; j++){
                int sum = list[j-1] + list[j-2] + list[j-3];
                list[j] = sum;
            }

            testResult[i] = list[list.length-3];
        }

        Arrays.stream(testResult).forEach(System.out::println);
        bw.flush();
        bw.close();
    }
}
