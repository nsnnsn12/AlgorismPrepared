package sunggyu.backjun.condigTest1.graph;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/7576
//토마토
/*
    정수 1은 익은 토마토
    정수 0은 익지 않은 토마토
    정수 -1은 토마토가 들어있지 않다.
*/
public class Graph7_review{
    static int N;
    static int M;
    static int[][] map;
    static int[][] days;
    static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] mn = bf.readLine().split(" ");
        N = Integer.parseInt(mn[1]);
        M = Integer.parseInt(mn[0]);
        map = new int[N][M];
        days = new int[N][M];
        Deque<int[]> deque = new ArrayDeque<>();
        for(int i = 0; i < N; i++){
            String[] split = bf.readLine().split(" ");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(split[j]);
                if(map[i][j] == 1){
                    int[] xy = {i,j};
                    deque.add(xy);
                    days[i][j] = 1;
                }
            }
        }
        
        bfs(deque);

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(days[i][j] == 0 && map[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, days[i][j]-1);
            }
        }
        System.out.println(max);
        bw.flush();
        bw.close();
    }

    public static void bfs(Deque<int[]> deque){
        while(!deque.isEmpty()){
            int[] xy = deque.poll();
            int day = days[xy[0]][xy[1]];
            for(int[] direct : directions){
                int nx = xy[0] + direct[0];
                int ny = xy[1] + direct[1];
                if(canVisit(nx, ny) && days[nx][ny] == 0){
                    days[nx][ny] = day + 1;
                    int[] nxy = {nx, ny};
                    deque.add(nxy);
                }
            }
        }
    }

    public static boolean canVisit(int x, int y){
        if(x < 0 || x >= N || y < 0 || y >= M) return false;
        if(map[x][y] == -1) return false;
        return true;
    }
}
