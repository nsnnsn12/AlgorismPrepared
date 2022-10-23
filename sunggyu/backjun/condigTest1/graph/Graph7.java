package sunggyu.backjun.condigTest1.graph;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/7576
//토마토
/*
*/
public class Graph7{
    static int N;
    static int M;
    static int[][] map;
    static int maxDay;
    static int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = bf.readLine().split(" ");
        M = Integer.parseInt(nm[0]);
        N = Integer.parseInt(nm[1]);
        map = new int[N][M];
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < N; i++){
            String[] split = bf.readLine().split(" ");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(split[j]);
                if(map[i][j] == 1){
                    int[] tomatoInfo = {i,j,0};
                    queue.add(tomatoInfo);
                }
            }
        }

        bfs(queue);
        boolean isValid = true;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0){
                    isValid = false;
                    break;
                }
            }
        }
        maxDay = isValid ? maxDay : -1;

        System.out.println(maxDay);
        bw.flush();
        bw.close();
    }

    public static void bfs(Queue<int[]> queue){
        while(!queue.isEmpty()){
            int[] tomotoInfo = queue.poll();
            int x = tomotoInfo[0];
            int y = tomotoInfo[1];
            int day = tomotoInfo[2];
            maxDay = Math.max(day, maxDay);
            for(int[] direct : directions){
                int nx = direct[0] + x;
                int ny = direct[1] + y;
                if(canVisit(nx, ny)){
                    if(map[nx][ny] == 0){
                        map[nx][ny] = 1;
                        int[] nextTomatoInfo={nx,ny,day+1};
                        queue.add(nextTomatoInfo);
                    }
                }
            }
        }
    }

    public static boolean canVisit(int x, int y){
        if(x < 0 || x >= N || y < 0 || y >= M) return false;
        return true;
    }

    
}
