package sunggyu.backjun.condigTest1.bfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1261
//알고스팟
/*
    각 좌표마다 도착하기까지 벽을 부순 갯수를 저장한다.
    그래프를 탐색할 때 좌표에 도착하기까지의 벽을 부순 갯수와 현재 갱신된 벽을 부순 갯수를 비교한다.
    
    즉 그래프를 탐색할 때마다 최소 갯수를 갱신한다.
*/
public class Bfs5_review{
    static int N;
    static int M;
    static int[][] map;
    static int[][] brokenCounts;
    static boolean[][] visited;
    static int[][] directions = {{0,1},{0, -1}, {1,0},{-1,0}};
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] mn = bf.readLine().split(" ");
        N = Integer.parseInt(mn[1]);
        M = Integer.parseInt(mn[0]);
        map = new int[N][M];
        visited = new boolean[N][M];
        brokenCounts = new int[N][M];
        for(int i = 0; i < N; i++){
            char[] split = bf.readLine().toCharArray();
            for(int j = 0; j < M; j++){
                map[i][j] = (int)(split[j]-'0');
            }
        }
        bfs();

        System.out.println(brokenCounts[N-1][M-1]);
        bw.flush();
        bw.close();
    }

    public static void bfs(){
        visited[0][0] = true;
        Deque<int[]> deque = new ArrayDeque<>();
        int[] xy = {0,0,0};
        deque.add(xy);

        while(!deque.isEmpty()){
            int[] now = deque.poll();
            int x = now[0];
            int y = now[1];
            int brokenCount = now[2];
            for(int[] direction : directions){
                int nx = x + direction[0];
                int ny = y + direction[1];
                int nextBrokenCount = brokenCount;
                if(canVisit(nx, ny)){
                    if(map[nx][ny] == 1){
                        nextBrokenCount++;
                    }

                    if(!visited[nx][ny] || brokenCounts[nx][ny] > nextBrokenCount){
                        brokenCounts[nx][ny] = nextBrokenCount;
                        visited[nx][ny] = true;
                        int[] next = {nx, ny, nextBrokenCount};
                        deque.add(next);
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
