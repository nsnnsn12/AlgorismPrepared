package sunggyu.backjun.condigTest2.bfs;
import java.io.*;
import java.util.*;
import java.util.function.Predicate;
//https://www.acmicpc.net/problem/10026
//적록색약 
/*
    적록색약은 빨간색과 초록색의 차이를 거의 느끼지 못 한다.
*/
public class Bfs13{
    static BufferedReader bf;
    static BufferedWriter bw;
    static char[][] map;
    static int N;
    static int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(bf.readLine());
        map = new char[N][N];
        for(int i = 0; i < N; i++){
            char[] list = bf.readLine().toCharArray();
            for(int j = 0; j < N; j++){
                map[i][j] = list[j];
            }
        }
        boolean isWeakness = true;
        int count1 = getArea(!isWeakness);
        
        int count2 = getArea(isWeakness);

        System.out.println(String.format("%d %d", count1, count2));
        bw.flush();
        bw.close();
    }

    public static int getArea(boolean isWeakness){
        int reuslt = 0;
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    reuslt++;
                    if(isWeakness){
                        searchByWeakness(i, j);
                    }else{
                        search(i, j);
                    }
                }
            }
        }

        return reuslt;
    }
    public static void searchByWeakness(int x, int y){
        bfs(x, y, (position) -> {
            if(map[position.x][position.y] == position.color) return true;
            if(position.color == 'B' || map[position.x][position.y] == 'B') return false;
            return true;
        });
    }

    public static void search(int x, int y){
        bfs(x, y, (position) -> {
            if(position.color != map[position.x][position.y]) return false;
            return true;
        });
    }

    public static void bfs(int x, int y, Predicate<Position> canVisit){
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(x, y, map[x][y]));

        while(!queue.isEmpty()){
            Position now = queue.poll();
            if(!canVisit(now)) continue;
            if(!canVisit.test(now)) continue;

            visited[now.x][now.y] = true;

            for(int[] direction : directions){
                int nx = now.x + direction[0];
                int ny = now.y + direction[1];
                queue.add(new Position(nx, ny, now.color));
            }
        }
    }

    public static boolean canVisit(Position position){
        if(position.x < 0 || position.x >= N || position.y < 0 || position.y >= N) return false;
        if(visited[position.x][position.y]) return false;
        return true;
    }

    public static class Position{
        int x;
        int y;
        char color;
        public Position(int x, int y, char color){
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }
}
