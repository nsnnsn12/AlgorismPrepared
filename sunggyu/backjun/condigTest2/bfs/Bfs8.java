package sunggyu.backjun.condigTest2.bfs;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
//https://www.acmicpc.net/problem/16933
//벽 부수고 이동하기 3
/*
*/
public class Bfs8{
    static BufferedReader bf;
    static BufferedWriter bw;
    static int N;
    static int M;
    static int K;
    static int[][] map;
    static int[][][] distances;
    static int[][] directions = {{-1, 0},{1, 0},{0, 1},{0, -1}};
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nmk = bf.readLine().split(" ");
        N = Integer.parseInt(nmk[0]);
        M = Integer.parseInt(nmk[1]);
        K = Integer.parseInt(nmk[2]);
        map = new int[N][M];
        for(int i = 0; i < N; i++){
            char[] list = bf.readLine().toCharArray();
            for(int j = 0; j < M; j++){
                map[i][j] = list[j] - '0';
            }
        }

        distances = new int[K+1][N][M];
        for(int i = 0; i < K + 1; i++){
            for(int j = 0; j < N; j++){
                Arrays.fill(distances[i][j], Integer.MAX_VALUE);
            }
        }
        bfs();

        result = result == Integer.MAX_VALUE ? -1 : result;

        System.out.println(result);
        bw.flush();
        bw.close();
    }

    static void bfs(){
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0, 0, 0, 1, false));
        //벽은 낮에만 부술 수 있다.
        while(!queue.isEmpty()){
            Position now = queue.poll();
            if(!canVisit(now)) continue;
            if(map[now.x][now.y] == 1) now.k++;
            if(map[now.x][now.y] == 1 && !now.isNight){
                now.isNight = true;
                now.distance++;
            }
            if(now.k > K) continue;
            if(distances[now.k][now.x][now.y] <= now.distance) continue;

            distances[now.k][now.x][now.y] = now.distance;

            if(now.x == N-1 && now.y == M-1){
                result = Math.min(result, now.distance);
                continue;
            }

            for(int[] direction : directions){
                int nx = direction[0] + now.x;
                int ny = direction[1] + now.y;
                queue.add(new Position(nx, ny, now.k, now.distance+1, !now.isNight));
            }
        }
    }

    static boolean canVisit(Position position){
        if(position.x < 0 || position.x >= N || position.y < 0 || position.y >= M) return false;
        return true;
    }

    static class Position{
        int x;
        int y;
        int k;
        int distance;
        boolean isNight;
        public Position(int x, int y, int k, int distance, boolean isNight){
            this.x = x;
            this.y = y;
            this.k = k;
            this.distance = distance;
            this.isNight = isNight;
        }
    }
}
