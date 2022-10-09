package sunggyu.programmersLv3;

import java.io.*;
//https://www.acmicpc.net/problem/11441
//합 구하기
/*
    카카오 7번 문제 풀기 전 구간합 구하는 문제 풀이
*/
import java.util.*;
class kakao7_1 {
    static BufferedReader bf;
    static BufferedWriter bw;
    static int N;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(bf.readLine());
        int[] list = new int[N];
        int[] prefixSum = new int[N];
        String[] split = bf.readLine().split(" ");
        list[0] = prefixSum[0] = Integer.parseInt(split[0]);
        for(int i = 1; i < N; i++){
            list[i] = Integer.parseInt(split[i]);
            prefixSum[i] = prefixSum[i-1] + list[i];
        }
        int M = Integer.parseInt(bf.readLine());
        for(int i = 0; i < M; i++){
            String[] ab = bf.readLine().split(" ");
            int a = Integer.parseInt(ab[0]) - 1;
            int b = Integer.parseInt(ab[1]) - 1;
            int last = a == 0 ? 0 : prefixSum[a-1];
            last = prefixSum[b] - last;
            bw.write(String.valueOf(last));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    
}