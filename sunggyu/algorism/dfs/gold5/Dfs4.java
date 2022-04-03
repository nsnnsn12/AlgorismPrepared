package sunggyu.algorism.dfs.gold5;
import java.io.*;
import java.math.BigDecimal;
import java.util.*;
//https://www.acmicpc.net/problem/1405
//미친 로봇
/*
    같은 곳을 방문하면 안 되기 때문에 경우의 수는 4 * 3의 13승이 됨.
    모든 경우의 수는 대략 600백만
*/
public class Dfs4{
    public static int n;
    public static double E;
    public static double W;
    public static double N;
    public static double S;
    public static int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public static double[] percent = new double[4];
    public static boolean[][] visit = new boolean[29][29];
    public static double result;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] split = bf.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        for(int i = 0; i < 4; i++){
            percent[i] = Integer.parseInt(split[i+1]);
            percent[i] /= 100;
        }

        int x = 14;
        int y = 14;
        visit[x][y] = true;

        for(int i = 0; i < 4; i++){
            int nx = x + directions[i][0];
            int ny = y + directions[i][1];
            double per = percent[i];
            visit[nx][ny] = true;
            dfs(1, nx, ny, per);
            visit[nx][ny] = false;
        }

        System.out.print(new BigDecimal(result));
        bw.flush();
        bw.close();
    }

    public static void dfs(int depth, int x, int y, double per){
        if(depth == n){
            result += per;
            return;
        }

        for(int i = 0; i < 4; i++){
            int nx = x + directions[i][0];
            int ny = y + directions[i][1];
            if(!visit[nx][ny]){
                visit[nx][ny] = true;
                dfs(depth+1, nx, ny, per * percent[i]);
                visit[nx][ny] = false;
            }
        }


    }
}