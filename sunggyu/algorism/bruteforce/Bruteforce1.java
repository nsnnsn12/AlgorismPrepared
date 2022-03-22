package sunggyu.algorism.bruteforce;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/2468
//안전 영역
//최대 크기는 100 * 100 = 10000
//모든 높이에 대해서 확인한다고 했을 때 10000 * 100 = 1000000
//완전 탐색 가능

public class Bruteforce1{
    public static int N;
    public static int[][] map;
    public static int min = 101;
    public static int max = 0;
    public static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(bf.readLine());
        map = new int[N][N];

        for(int i = 0; i < N; i++){
            String[] split = bf.readLine().split(" ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(split[j]);
                min = map[i][j] < min ? map[i][j] : min;
                max = map[i][j] > max ? map[i][j] : max;
            }
        }

        int maxSafetyCount = 0;
        for(int i = min-1; i < max; i++){
            int count = getSafetyCount(i);
            maxSafetyCount = maxSafetyCount > count ? maxSafetyCount : count;
        }

        System.out.println(maxSafetyCount);


        bw.flush();
        bw.close();
    }

    public static int getSafetyCount(int high){
        int result = 0;
        boolean[][] visit = new boolean[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] > high && !visit[i][j]){
                    dfs(i, j, visit, high);
                    result++;
                }
            }
        }
        return result;
    }

    public static void dfs(int x, int y, boolean[][] visit, int high){
        if(!canSafeCheck(x, y, high, visit)){
            return;
        }

        visit[x][y] = true;

        for(int[] direction : directions){
            int nx = x + direction[0];
            int ny = y + direction[1];
            dfs(nx, ny, visit, high);
        }
    }

    public static boolean canSafeCheck(int x, int y, int high, boolean[][] visit){
        if(x < 0 || x >= N || y < 0 || y >= N){
            return false;
        }

        if(visit[x][y]){
            return false;
        }

        if(map[x][y] <= high){
            return false;
        }

        return true;
    }

    
}
