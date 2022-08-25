package sunggyu.algorism.condigTest2.bfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/14442
//벽 부수고 이동하기 2
/*
*/
public class Bfs7{
    static BufferedReader bf;
    static BufferedWriter bw;
    static int N;
    static int M;
    static int K;
    static int[][][] ditsances;
    static int[][] map;
    static int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nmk = bf.readLine().split(" ");
        N = Integer.parseInt(nmk[0]);
        M = Integer.parseInt(nmk[1]);
        K = Integer.parseInt(nmk[2]);
        ditsances = new int[K+1][N][M];
        map = new int[N][M];

        for(int i = 0; i < N; i++){
            char[] list = bf.readLine().toCharArray();
            for(int j = 0; j < M; j++){
                map[i][j] = list[j] - '0';
            }
        }

        for(int i = 0; i <= K; i++){
            for(int j = 0; j < N; j++){
                Arrays.fill(ditsances[i][j], Integer.MAX_VALUE);
            }
        }

        bfs();
        result = result == Integer.MAX_VALUE ? -1 : result;

        System.out.println(result);
        bw.flush();
        bw.close();
    }

    public static void bfs(){
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0, 0, 0, 1));

        while(!queue.isEmpty()){
            Position now = queue.poll();
            if(!canVisit(now)) continue;
            if(map[now.x][now.y] == 1) now.brokenCount++;
            if(now.brokenCount > K) continue;
            if(ditsances[now.brokenCount][now.x][now.y] <= now.distance) continue;

            ditsances[now.brokenCount][now.x][now.y] = now.distance;

            if(now.x == N -1 && now.y == M-1){
                result = Math.min(result, now.distance);
                continue;
            }

            for(int[] direction : directions){
                int nx = now.x + direction[0];
                int ny = now.y + direction[1];
                queue.add(new Position(nx, ny, now.brokenCount, now.distance + 1));
            }
        }

    }

    public static boolean canVisit(Position position){
        if(position.x < 0 || position.x >= N || position.y < 0 || position.y >= M) return false;
        return true;
    }

    static class Position{
        int x;
        int y;
        int brokenCount;
        int distance;
        public Position(int x, int y, int brokenCount, int distance){
            this.x = x;
            this.y = y;
            this.brokenCount = brokenCount;
            this.distance = distance;
        }
    }
}
