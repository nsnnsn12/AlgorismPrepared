package sunggyu.algorism.condigTest2.bfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/2206
//벽 부수고 이동하기 리팩토링
/*
    벽을 1개까지 부술 수 있다.
    고로 벽을 1개 부쉈을 때의 distance 정보와 부수지 않았을 때의 distance 정보를 다 가지고 있어야 한다.
    부수지 않은 distance 정보를 기준으로 bfs로 최단거리를 검색하고 벽을 만났을 때 부쉈을 때의 distance 정보를 갱신하는 작업을 거쳐야 한다.
*/
public class Bfs5_1{
    static BufferedReader bf;
    static BufferedWriter bw;
    static int N;
    static int M;
    static int[][] map;
    static int[][][] visited;
    static int[][] directions = {{0, 1},{0, -1}, {1, 0}, {-1, 0}};
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = bf.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);
        map = new int[N][M];
        visited = new int[2][N][M];
        for(int i = 0; i < N; i++){
            Arrays.fill(visited[0][i], Integer.MAX_VALUE);
            Arrays.fill(visited[1][i], Integer.MAX_VALUE);
            char[] list = bf.readLine().toCharArray();
            for(int j = 0; j < M; j++){
                map[i][j] = list[j] - '0';
            }
        }

        bfs();

        result = result == Integer.MAX_VALUE ? -1 : result;
        System.out.println(result);
        bw.flush();
        bw.close();
    }

    public static void bfs(){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 1, false));

        while(!queue.isEmpty()){
            Point now = queue.poll();
            if(!canVisit(now)) continue;

            if(map[now.x][now.y] == 1 && now.isBroken) continue;
            if(map[now.x][now.y] == 1 && !now.isBroken) now.isBroken = true;

            if(now.isBroken){
                visited[1][now.x][now.y] = now.distance;
            }else{
                visited[0][now.x][now.y] = now.distance;
            }

            if(now.x == N-1 && now.y == M-1){
                result = Math.min(result, now.distance);
                continue;
            }

            for(int[] direction : directions){
                int nx = direction[0] + now.x;
                int ny = direction[1] + now.y;
                queue.add(new Point(nx, ny, now.distance+1, now.isBroken));
            }
        }
    }

    public static boolean canVisit(Point point){
        if(point.x < 0 || point.x >= N || point.y < 0 || point.y >= M) return false;
        int distance;
        if(point.isBroken){
            distance = visited[1][point.x][point.y];
        }else{
            distance = visited[0][point.x][point.y];
        }
        if(point.distance >= distance) return false;
        return true;
    }

    public static class Point{
        int x;
        int y;
        int distance;
        boolean isBroken;
        public Point(int x, int y, int distance, boolean isBroken){
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.isBroken = isBroken;
        }
    }
}
