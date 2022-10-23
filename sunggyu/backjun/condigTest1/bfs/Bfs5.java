package sunggyu.backjun.condigTest1.bfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1261
//알고스팟
/*
    0은 빈방
    1은 벽

    0,0 에서 n,m까지 가는데 최소한으로 벽을 부수는 경우를 구하라.

    nm은 최대 100개
    최대 사이즈는 10,000

    각각의 nm의 도착하기 까지의 최소한으로 벽을 부수는 경우를 구하라.
*/
public class Bfs5{
    static int n;
    static int m;
    static int[][] map;
    static int[][] brokenCounts;
    static boolean[][] visited;
    static int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] mn = bf.readLine().split(" ");
        m = Integer.parseInt(mn[0]);
        n = Integer.parseInt(mn[1]);
        map = new int[n][m];
        visited = new boolean[n][m];
        brokenCounts = new int[n][m];

        for(int i = 0; i < n; i++){
            char[] list = bf.readLine().toCharArray();
            for(int j = 0; j < m; j++){
                map[i][j] = (int)list[j] - '0';
            }
        }
        bfs();
        System.out.println(brokenCounts[n-1][m-1]);
        
        bw.flush();
        bw.close();
    }

    public static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        int[] info = {0,0,0};
        queue.add(info);
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            int brokenCount = now[2];
            if(!canVisit(x, y)) continue;

            if(map[x][y] == 1) brokenCount++;

            if(visited[x][y] && brokenCounts[x][y] <= brokenCount) continue;

            visited[x][y] = true;

            brokenCounts[x][y] = brokenCount;

            for(int[] direct : directions){
                int nx = x + direct[0];
                int ny = y + direct[1];
                int[] next = {nx,ny,brokenCount};
                queue.add(next);
            }
        }
    }

    public static boolean canVisit(int x, int y){
        if(x < 0 || x >= n || y < 0 || y >= m) return false;
        return true;
    }

    
}
