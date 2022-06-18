package sunggyu.algorism.condigTest2.bruteforce.etc;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1806
//부분합
/*

*/
public class Etc2{
    static BufferedReader bf;
    static int N;
    static int S;
    static int[] list;

    static BufferedWriter bw;    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] split = bf.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        S = Integer.parseInt(split[1]);
        split = bf.readLine().split(" ");
        list = new int[N];
        int total = 0;
        for(int i = 0 ; i < N; i++){
            list[i] = Integer.parseInt(split[i]);
            total += list[i];
        }  


        bw.flush();
        bw.close();
    }

    public static void dfs(int total){
        
    }
}
