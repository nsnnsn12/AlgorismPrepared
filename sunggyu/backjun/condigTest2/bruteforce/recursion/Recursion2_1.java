package sunggyu.backjun.condigTest2.bruteforce.recursion;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1182
//부분수열의 합
/*
    중복없이 모든 부분 수열의 합을 구해야 한다.
*/
public class Recursion2_1{
    static BufferedReader bf;
    static BufferedWriter bw;    
    static int N;
    static int S;
    static int[] list;
    static int result;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] split =bf.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        S = Integer.parseInt(split[1]);
        split = bf.readLine().split(" ");
        list = new int[N];
        for(int i = 0; i < N; i++){
            list[i] = Integer.parseInt(split[i]);
        }
        for(int i = 0; i < list.length; i++){
            dfs(i+1, list[i]);
        }
        System.out.println(result);
        bw.flush();
        bw.close();
    }

    public static void dfs(int startIndex, int sum){
        if(sum == S){
            result++;
        }

        for(int i = startIndex; i < list.length; i++){
            sum += list[i];
            dfs(i + 1, sum);
            sum -= list[i];
        }
    }
}
