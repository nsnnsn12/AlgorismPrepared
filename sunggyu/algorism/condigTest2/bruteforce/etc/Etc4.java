package sunggyu.algorism.condigTest2.bruteforce.etc;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1208
//부분수열의 합 2
/*
    부분수열이란 원 수열의 항의 일부분만을 딴 수열
    ex) 1, 4, 0, 3, 7, 2, 5, 10 -> 1, 4, 7, 10
*/
public class Etc4{
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
