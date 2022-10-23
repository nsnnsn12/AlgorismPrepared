package sunggyu.backjun.condigTest2.bfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/16236
//아기 상어
/*
    bfs를 이용하여 거리가 가장 가까운 물고기를 찾는다.

*/
public class Bfs10{
    static BufferedReader bf;
    static BufferedWriter bw;
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[][] directions = {{-1, 0},{0,-1},{1,0},{0,1}};
    static int lastSecood;
    static Position last;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(bf.readLine());
        map = new int[N][N];
        Position position = null;
        for(int i = 0; i < N; i++){
            char[] list = bf.readLine().toCharArray();
            for(int j = 0; j < list.length; j += 2){
                map[i][j/2] = list[j] - '0';
                if(map[i][j/2] == 9){
                    map[i][j/2] = 0;
                    position = new Position(i, j/2, 0, 2, 0);
                }
            }
        }

        bfs(position);
        System.out.println(lastSecood);
        bw.flush();
        bw.close();
    }

    public static void bfs(Position position){
        visited = new boolean[N][N];
        Queue<Position> queue = new LinkedList<>();
        queue.add(position);
        while(!queue.isEmpty()){
            Position now = queue.poll();
            if(!canVisit(now)) continue;
            if(canEating(now)){
                now = minDistance(queue, now);
                lastSecood = now.second;
                visited = new boolean[N][N];
                map[now.x][now.y] = 0;
                now.eat();
            }
            visited[now.x][now.y] = true;

            for(int[] direction : directions){
                int nx = direction[0] + now.x;
                int ny = direction[1] + now.y;
                queue.add(new Position(nx, ny, now.second + 1, now.size, now.eatingCount));
            }

        }
    }

    public static Position minDistance(Queue<Position> queue, Position now){
        Position minPosition = now;
        while(!queue.isEmpty()){
            Position position = queue.poll();
            if(now.second != position.second) continue;
            if(!canVisit(position)) continue;
            if(!canEating(position)) continue;
            if(minPosition.x > position.x) minPosition = position;

            if(minPosition.x == position.x && minPosition.y > position.y) minPosition = position;
        }

        return minPosition;
    }

    public static boolean canVisit(Position position){
        if(position.x < 0 || position.x >= N || position.y < 0 || position.y >= N) return false;
        if(map[position.x][position.y] > position.size) return false;
        if(visited[position.x][position.y]) return false;
        return true;
    }

    public static boolean canEating(Position position){
        if(map[position.x][position.y] != 0 && map[position.x][position.y] < position.size) return true;
        return false;
    }

    public static class Position{
        int x;
        int y;
        int second;
        int size;
        int eatingCount;

        public Position(int x, int y, int second, int size, int eatingCount){
            this.x = x;
            this.y = y;
            this.second = second;
            this.size = size;
            this.eatingCount = eatingCount;
        }

        public void eat(){
            eatingCount++;
            if(eatingCount == size){
                size++;
                eatingCount = 0;
            }
        }
    }
}
