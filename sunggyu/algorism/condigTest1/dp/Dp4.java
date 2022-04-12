package sunggyu.algorism.condigTest1.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/9095  
//1, 2, 3 더하기
/*
    n이 1일 때 경우의 수 1개
    n이 2일 때 경우의 수 2개
    n이 3일 때 경우의 수 4개

    n을 이루는 요소는 무조건 1,2,3
    n이 1로 끝나는 경우의 수 n - 1;
    n이 2로 끝나는 경우의 수 n - 2;
    n이 3으로 끝나는 경우의 수 n - 3;
*/
public class Dp4{
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(bf.readLine());
        int[] testResult = new int[t];
        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(bf.readLine());
            int[] list = new int[n];

            list[0] = 1;
            if(n > 1){
                list[1] = 2;
            }

            if(n > 2){
                list[2] = 4;
            }

            for(int j = 3; j < list.length; j++){
                int sum = list[j-1] + list[j-2] + list[j-3];
                list[j] = sum;
            }

            testResult[i] = list[n-1];
        }

        Arrays.stream(testResult).forEach(System.out::println);
        bw.flush();
        bw.close();
    }
}
