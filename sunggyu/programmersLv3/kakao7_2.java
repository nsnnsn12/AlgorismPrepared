package sunggyu.programmersLv3;

import java.io.*;
//https://www.acmicpc.net/problem/11659
//구간 합 구하기 4
/*
    카카오 7번 문제 풀기 전 구간합 구하는 문제 풀이
*/
import java.util.*;
class kakao7_2 {
    static BufferedReader bf;
    static BufferedWriter bw;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = bf.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);
        int[] list = new int[N];
        int[] prefixSum = new int[N];
        String[] split = bf.readLine().split(" ");
        prefixSum[0] = list[0] = Integer.parseInt(split[0]);

        for(int i = 1; i < N; i++){
            list[i] = Integer.parseInt(split[i]);
            prefixSum[i] = prefixSum[i-1] + list[i];
        }

        for(int i = 0; i < M; i++){
            String[] ab = bf.readLine().split(" ");
            int a = Integer.parseInt(ab[0]) - 1;
            int b = Integer.parseInt(ab[1]) - 1;
            b = prefixSum[b];
            a = a == 0 ? 0 : prefixSum[a-1];
            bw.write(String.valueOf(b - a));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
    
}