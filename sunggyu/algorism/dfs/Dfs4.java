package sunggyu.algorism.dfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1405
//미친 로봇
/*
    같은 곳을 방문하면 안 되기 때문에 경우의 수는 4 * 3의 13승이 됨.
    모든 경우의 수는 대략 600백만
*/
public class Dfs4{
    public static int n;
    public static int E;
    public static int W;
    public static int N;
    public static int S;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] split = bf.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        E = Integer.parseInt(split[1]);
        W = Integer.parseInt(split[2]);
        N = Integer.parseInt(split[3]);
        S = Integer.parseInt(split[4]);

        bw.flush();
        bw.close();
    }

    public static void dfs(int depth){
        if(depth == n);

    }
}