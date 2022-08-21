package sunggyu.algorism.condigTest2.bfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/2206
//벽 부수고 이동하기
/*
    n * m의 맵이 존재한다.
    0은 이동가능
    1은 벽이다.

    벽은 1번까지 부수고 지나갈 수 있다.
    
    1,1에서 N,M까지의 최단거리를 구하라.
    최단거리를 구할 때 1,1과 N,M도 포함한다.
    최단거리로 도달할 수 없는 경우 -1을 리턴한다.

    N <= 1000
    M <= 1000

    zero -> n = a
    goal -> n = b
    zero -> goal = a + b

*/
public class Bfs5{
    static BufferedReader bf;
    static BufferedWriter bw;
    static int N;
    static int M;
    static boolean[][] wallInfo;
    static int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    static int result;
    static int[][] zeroToNDistance;
    static int[][] goalToNDistance;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = bf.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);
        wallInfo = new boolean[N][M];
        zeroToNDistance = new int[N][M];
        goalToNDistance = new int[N][M];
        for(int i = 0; i < N; i++){
            Arrays.fill(zeroToNDistance[i], Integer.MAX_VALUE);
            Arrays.fill(goalToNDistance[i], Integer.MAX_VALUE);
            char[] mapInfo = bf.readLine().toCharArray();
            for(int j = 0; j < M; j++){
                if(mapInfo[j] == '1'){
                    wallInfo[i][j] = true;
                }
            }
        }
        bfs(0, 0, zeroToNDistance);
        bfs(N-1, M-1, goalToNDistance);
        result = zeroToNDistance[N-1][M-1];
        simulationBrokenWall();

        if(result == Integer.MAX_VALUE) result = -1;

        System.out.println(result);
        bw.flush();
        bw.close();
    }

    public static void simulationBrokenWall(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(wallInfo[i][j]){
                    breakWall(i, j);
                }
            }
        }
    }

    public static void breakWall(int x, int y){
        for(int i = 0; i < 4; i++){
            int nx = x + directions[i][0];
            int ny = y + directions[i][1];
            if(canVisit(nx, ny) && zeroToNDistance[nx][ny] != Integer.MAX_VALUE){
                for(int j = 0; j < 4; j++){
                    if(j != i){
                        int xx = x + directions[j][0];
                        int yy = y + directions[j][1];
                        if(canVisit(xx, yy) && goalToNDistance[xx][yy] != Integer.MAX_VALUE){
                            int zeroToGoal = zeroToNDistance[nx][ny];
                            int goalToZero = goalToNDistance[xx][yy];
                            int distance = zeroToGoal + goalToZero + 1;
                            result = Math.min(distance, result);
                        }
                    }
                }
            }
        }
    }

    public static void bfs(int i, int j, int[][] distanceInfo){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j,1});

        while(!queue.isEmpty()){
            int[] info = queue.poll();
            int x = info[0];
            int y = info[1];
            int distance = info[2];

            if(!canVisit(x, y) || distanceInfo[x][y] <= distance) continue;

            distanceInfo[x][y] = distance;

            for(int[] direction : directions){
                int nx = x + direction[0];
                int ny = y + direction[1];
                queue.add(new int[]{nx, ny, distance + 1});
            }
        }
    }

    public static boolean canVisit(int x, int y){
        if(x < 0 || x >= N || y < 0 || y >= M) return false;
        if(wallInfo[x][y]) return false;
        return true;
    }
}
