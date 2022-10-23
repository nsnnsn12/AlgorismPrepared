package sunggyu.backjun.condigTest2.bfs;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
//https://www.acmicpc.net/problem/16954
//움직이는 미로 탈출
/*
    캐릭터가 먼저 움직이고 그 다음에 벽이 한 칸씩 내려간다.
    캐릭터는 상하좌우 대각선 8방향으로 움직일 수 있다.

    유의할 점
    캐릭터가 먼저 움직이고 그 다음에 벽이 움직인다.
    현재 방문 가능한지 확인, 방문 후 벽이 움직이는지 확인
*/

public class Bfs9{
    static BufferedReader bf;
    static BufferedWriter bw;
    static char[][][] map = new char[9][8][8];
    static int[][] directions = {{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,1},{1,-1}};
    static int result;
    static boolean[][][] visited = new boolean[9][8][8];
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < 8; i++){
            char[] list = bf.readLine().toCharArray();
            for(int j = 0; j < 8; j++){
                map[0][i][j] = list[j];
            }
        }

        for(int i = 1; i <= 8; i++){
            for(int j = 0; j < 8; j++){
                Arrays.fill(map[i][j], '.');
            }
        }

        for(int i = 1; i < 8; i++){
            moveWall(i);
        }

        bfs();
        System.out.println(result);
        bw.flush();
        bw.close();
    }

    public static void bfs(){
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(7, 0, 0));

        while(!queue.isEmpty()){
            Position now = queue.poll();
            
            if(now.second > 8) now.second = 8;
            if(map[now.second][now.x][now.y] == '#') continue;
            if(visited[now.second][now.x][now.y]) continue;

            if(now.x == 0 && now.y == 7){
                result = 1;
                return;
            }

            visited[now.second][now.x][now.y] = true;

            queue.add(new Position(now.x, now.y, now.second + 1));
            for(int[] direction : directions){
                int nx = direction[0] + now.x;
                int ny = direction[1] + now.y;
                //범위가 벗어나고 벽으로 이동하는 경우 넘어감
                if(nx < 0 || nx >= 8 || ny < 0 || ny >= 8) continue;
                if(map[now.second][nx][ny] == '#') continue;
                queue.add(new Position(nx, ny, now.second + 1));
            }
        }
    }
    public static void moveWall(int index){
        for(int i = 6; i >= 0; i--){
            for(int j = 0; j < 8; j++){
                map[index][i+1][j] = map[index-1][i][j];
            }
        }
    }

    static class Position{
        int x;
        int y;
        int second;
        public Position(int x, int y, int second){
            this.x = x;
            this.y = y;
            this.second = second;
        }
    }
}
