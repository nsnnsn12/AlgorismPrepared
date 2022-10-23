package sunggyu.backjun.condigTest2.bruteforce.recursion;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1182
//부분수열의 합
/*
    중복없이 모든 부분 수열의 합을 구해야 한다.
*/
public class Recursion2{
    static BufferedReader bf;
    static BufferedWriter bw;
    static int N;
    static int S;
    static int result;
    static int[] list;
    static int[] selected;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ns = bf.readLine().split(" ");
        N = Integer.parseInt(ns[0]);
        S = Integer.parseInt(ns[1]);
        list = new int[N];
        String[] split = bf.readLine().split(" ");
        for(int i = 0; i < N; i++){
            list[i] = Integer.parseInt(split[i]);
        }

        for(int i = 1; i <= N; i++){
            selected = new int[i];
            combo(0, i, 0);
        }
        System.out.println(result);
        bw.flush();
        bw.close();
    }

    public static void combo(int depth, int n, int startIndex){
        if(depth == n){
            int sum = Arrays.stream(selected).sum();
            if(sum == S){
                result++;
            }
            return;
        }
        for(int i = startIndex; i < N; i++){
            selected[depth] = list[i];
            combo(depth+1, n, i+1);
        }
    }
}
