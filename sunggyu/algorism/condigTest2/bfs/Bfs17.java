package sunggyu.algorism.condigTest2.bfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1600
//말이 되고픈 원숭이
/*
    k번 말처럼 움직일 수 있다.
    말처럼 움직일 경우에는 장애물을 통과할 수 있다.
    최소한의 움직임을 구하라.
*/
public class Bfs17{
    static BufferedReader bf;
    static BufferedWriter bw;
    static int K;
    static int[][] map;
    static int[][][] counts;
    static int N;
    static int M;
    static int[][] horseDirections = {{-1, -2},{-2, -1},{-2,1},{-1,2},{1,2},{2,1},{1,-2},{2,-1}};
    static int[][] monkeyDirections = {{-1,0},{1,0},{0,1},{0,-1}};
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        K = Integer.parseInt(bf.readLine()) + 1;
        String[] mn = bf.readLine().split(" ");
        N = Integer.parseInt(mn[1]);
        M = Integer.parseInt(mn[0]);
        map = new int[N][M];
        counts = new int[K][N][M];
        for(int i = 0; i < N; i++){
            String[] split = bf.readLine().split(" ");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        for(int i = 0; i < K; i++){
            for(int j = 0; j < N; j++){
                Arrays.fill(counts[i][j], Integer.MAX_VALUE);
            }
        }

        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0, 0, 0, 0));

        while(!queue.isEmpty()){
            Position now = queue.poll();
            if(!canVisit(now)) continue;
            if(counts[now.k][now.x][now.y] <= now.count) continue;

            counts[now.k][now.x][now.y] = now.count;
            if(now.x == N-1 && now.y == M-1){
                result = Math.min(result, now.count);
                continue;
            }

            for(int[] direction : monkeyDirections){
                int nx = direction[0] + now.x;
                int ny = direction[1] + now.y;
                queue.add(new Position(nx, ny, now.k, now.count + 1));
            }

            if(now.k != K-1){
                for(int[] direction : horseDirections){
                    int nx = direction[0] + now.x;
                    int ny = direction[1] + now.y;
                    queue.add(new Position(nx, ny, now.k+1, now.count + 1));
                }
            }
        }
        result = result == Integer.MAX_VALUE ? -1 : result;

        System.out.println(result);
        bw.flush();
        bw.close();
    }

    public static boolean canVisit(Position position){
        if(position.x < 0 || position.x >= N || position.y < 0 || position.y >= M) return false;
        if(map[position.x][position.y] == 1) return false;
        return true;
    }

    static class Position{
        int x;
        int y;
        int k;
        int count;
        public Position(int x, int y, int k, int count){
            this.x = x;
            this.y = y;
            this.k = k;
            this.count = count;
        }

    }
}
