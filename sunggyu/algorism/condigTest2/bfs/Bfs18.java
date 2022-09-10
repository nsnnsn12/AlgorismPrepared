package sunggyu.algorism.condigTest2.bfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/17086
//아기 상어 2
/*
    안전거리가 가장 큰 칸을 구하라.
    안전거리란 아기 상어와의 최단거리를 뜻한다.
    이동은 8방향으로 갈 수 있다.
*/
public class Bfs18{
    static BufferedReader bf;
    static BufferedWriter bw;
    static int[][] directions = {{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,1},{1,-1}};
    static int[][] map;
    static int N;
    static int M;
    static int result = 0;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = bf.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);
        map = new int[N][M];

        for(int i = 0; i < N; i++){
            String[] list = bf.readLine().split(" ");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(list[j]);
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] != 1){
                    getSafetyDistance(i, j);
                }
            }
        }

        System.out.println(result);
        bw.flush();
        bw.close();
    }

    static void getSafetyDistance(int x, int y){
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(x, y, 0));
        boolean[][] visited = new boolean[N][M];
        while(!queue.isEmpty()){
            Position now = queue.poll();
            if(!canVisit(now, visited)) continue;
            visited[now.x][now.y] = true;
            if(map[now.x][now.y] == 1){
                result = Math.max(result, now.distance);
                return;
            }

            for(int[] direction : directions){
                int nx = direction[0] + now.x;
                int ny = direction[1] + now.y;
                queue.add(new Position(nx, ny, now.distance+1));
            }
        }
    }

    static boolean canVisit(Position position, boolean[][] visited){
        if(position.x < 0 || position.x >= N || position.y < 0 || position.y >= M) return false;
        if(visited[position.x][position.y]) return false;
        return true;
    }

    static class Position{
        int x, y, distance;
        public Position(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
