package sunggyu.algorism.condigTest1.graph;
import java.io.*;
import java.util.*;

import javax.lang.model.type.NoType;
//https://www.acmicpc.net/problem/2178
//미로 탐색
/*
    bfs는 최단거리를 보장한다.
    왜? 제일 인접한 노드를 먼저 방문하기 때문에
*/
public class Graph6_review{
    static int N;
    static int M;
    static int[][] map;
    static int[][] distance;
    static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = bf.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);
        map = new int[N][M];
        distance = new int[N][M];
        for(int i = 0; i < N; i++){
            char[] list = bf.readLine().toCharArray();
            for(int j = 0; j < M; j++){
                map[i][j] = (int)(list[j]-'0');
            }
        }
        bfs();
        System.out.println(distance[N-1][M-1]);
        bw.flush();
        bw.close();
    }

    public static void bfs(){
        Deque<int[]> deque = new ArrayDeque<>();
        int[] xy = {0,0};
        deque.add(xy);
        distance[0][0] = 1;
        while(!deque.isEmpty()){
            int[] now = deque.poll();
            int nowDistance = distance[now[0]][now[1]];
            for(int i = 0; i < 4; i++){
                int nx = directions[i][0] + now[0];
                int ny = directions[i][1] + now[1];
                if(canVisit(nx, ny) && map[nx][ny] == 1 && distance[nx][ny] == 0){
                    distance[nx][ny] = nowDistance+1;
                    int[] nxy = {nx,ny};
                    deque.add(nxy);
                }
            }
        }
    }

    public static boolean canVisit(int x, int y){
        if(x < 0 || x >= N || y < 0 || y >= M) return false;
        return true;
    }
}
