package sunggyu.algorism.condigTest2.bfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/4991
//로봇 청소기
/*
    더러운 칸을 모두 깨끗한 칸으로 만드는데 필요한 이동 횟수의 최솟값을 구하라.

    bfs는 두 노드 간의 최단거리를 알 수 있다.

    a -> b = 5
    a -> c = 3

    c -> b = 4

    c -> e = 5
    b -> e = 2

    버텍스의 여러 간선이 존재하기 때문에 노드간 최단거리를 선택한다고 해서 최단거리를 찾을 수 없다.
    결국 경로간 완전탐색을 해야 한다.
    어떻게 할 것인가?

    1. 로봇청소기와 각각의 더러운 칸 간의 모든 distance를 구한다.
    2. 모든 경로의 대한 경우의 수를 구한다.

*/
public class Bfs19{
    static BufferedReader bf;
    static BufferedWriter bw;
    static int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    static int N;
    static int M;
    static char[][] map;
    static List<Position> dirtyPositions;
    static int[][] dirtyDistance;
    static int MIN = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[]mn = bf.readLine().split(" ");
        N = Integer.parseInt(mn[1]);
        M = Integer.parseInt(mn[0]);
        while(N != 0 && M != 0){
            map = new char[N][M];
            dirtyPositions = new ArrayList<>();
            Position start = null;
            int dirtyCount = 0;
            for(int i = 0; i < N; i++){
                map[i] = bf.readLine().toCharArray();
                for(int j = 0; j < M; j++){
                    if(map[i][j] == 'o'){
                        start = new Position(i, j, 0);
                    }

                    if(map[i][j] == '*'){
                        dirtyPositions.add(new Position(i, j, 0));
                        dirtyCount++;
                    }
                }
            }

            dirtyDistance = new int[dirtyCount][dirtyCount];
            for(int i = 0; i < dirtyCount; i++){
                setDistance(i);
            }
            MIN = Integer.MAX_VALUE;

            getDistance(start);

            if(Integer.MAX_VALUE == MIN) MIN = -1;
            bw.write(String.valueOf(MIN));
            bw.newLine();

            mn = bf.readLine().split(" ");
            N = Integer.parseInt(mn[1]);
            M = Integer.parseInt(mn[0]);
        }
        bw.flush();
        bw.close();
    }

    public static void setDistance(int dirtyCount){
        Queue<Position> queue = new LinkedList<>();
        queue.add(dirtyPositions.get(dirtyCount));
        boolean[][] visited = new boolean[N][M];

        while(!queue.isEmpty()){
            Position now = queue.poll();
            if(!canVisit(now)) continue;
            if(visited[now.x][now.y]) continue;

            visited[now.x][now.y] = true;

            if(map[now.x][now.y] == '*'){
                int index = getDirtyIndex(now.x, now.y);
                dirtyDistance[dirtyCount][index] = now.distance;
            }

            for(int[] direction : directions){
                int nx = direction[0] + now.x;
                int ny = direction[1] + now.y;
                queue.add(new Position(nx, ny, now.distance+1));
            }
        }
    }

    public static int getDirtyIndex(int x, int y){
        for(int i = 0; i < dirtyPositions.size(); i++){
            if(x == dirtyPositions.get(i).x && y == dirtyPositions.get(i).y){
                return i;
            }
        }
        return 0;
    }

    public static void getDistance(Position start){
        Queue<Position> queue = new LinkedList<>();
        queue.add(start);
        boolean[][] visited = new boolean[N][M];

        while(!queue.isEmpty()){
            Position now = queue.poll();
            if(!canVisit(now)) continue;
            if(visited[now.x][now.y]) continue;

            visited[now.x][now.y] = true;

            if(map[now.x][now.y] == '*'){
                int distance = now.distance;
                int index = getDirtyIndex(now.x, now.y);
                boolean[] v = new boolean[dirtyPositions.size()];
                v[index] = true;
                dfs(1, v, distance, dirtyPositions.size(), index);
            }

            for(int[] direction : directions){
                int nx = direction[0] + now.x;
                int ny = direction[1] + now.y;
                queue.add(new Position(nx, ny, now.distance+1));
            }
        }
    }

    public static void dfs(int depth, boolean[] visited, int distance, int max, int index){
        if(depth == max){
            MIN = Math.min(MIN, distance);
        }

        for(int i = 0; i < dirtyPositions.size(); i++){
            if(!visited[i] && dirtyDistance[index][i] != 0){
                visited[i] = true;
                distance += dirtyDistance[index][i];
                dfs(depth + 1, visited, distance, max, i);
                distance -= dirtyDistance[index][i];
                visited[i] = false;
            }
        }
    }

    public static boolean canVisit(Position position){
        if(position.x < 0 || position.x >= N || position.y < 0 || position.y >= M) return false;
        if(map[position.x][position.y] == 'x') return false;
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
