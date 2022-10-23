package sunggyu.backjun.condigTest1.graph;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/7562
//나이트의 이동
/*
*/
public class Graph8{
    public static class Night{
        int X;
        int Y;
        int TARGET_X;
        int TARGET_Y;
        int[][] MAP;
        boolean[][] visit;
        int N;
        //동남서북
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};

        public Night(int x, int y, int nx, int ny, int[][] map){
            X = x;
            Y = y;
            TARGET_X = nx;
            TARGET_Y = ny;
            MAP = map;
            N = map.length;
            visit = new boolean[N][N];
        }

        public void bfs(){
            Queue<int[]> queue = new LinkedList<>();
            int[] nowPosition = {X, Y, 0};
            queue.add(nowPosition);
            while(!queue.isEmpty()){
                int[] position = queue.poll();
                int x = position[0];
                int y = position[1];
                int count = position[2];
                if(!visit[x][y]){
                    visit[x][y] = true;
                    MAP[x][y] = count;
                    for(int d = 0; d < 4; d++){
                        int nx = x + directions[d][0]+directions[d][0];
                        int ny = y + directions[d][1]+directions[d][1];
    
                        int right = (d+1) % 4;
                        int left = (d+3) % 4;
    
                        int leftX = nx + directions[left][0];
                        int leftY = ny + directions[left][1];
                        if(canVisit(leftX, leftY)){
                            int[] leftPosition = {leftX, leftY, count+1};
                            queue.add(leftPosition);
                        }
                        int rightX = nx + directions[right][0];
                        int rightY = ny + directions[right][1];
                        if(canVisit(rightX, rightY)){
                            int[] rightPosition = {rightX, rightY, count+1};
                            queue.add(rightPosition);
                        }
                    }
                }
            }
        }

        public boolean canVisit(int x, int y){
            if(x < 0 || x >= N || y < 0 || y >= N) return false;

            return true;
        }

        public int getMove(){
            bfs();

            return MAP[TARGET_X][TARGET_Y];
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Night> list = new ArrayList<>();
        int t = Integer.parseInt(bf.readLine());
        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(bf.readLine());
            int[][] map = new int[n][n];
            String[] xy = bf.readLine().split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);

            String[] nxy = bf.readLine().split(" ");
            int nx = Integer.parseInt(nxy[0]);
            int ny = Integer.parseInt(nxy[1]);
            list.add(new Night(x, y, nx, ny, map));
        }

        list.forEach(o -> System.out.println(o.getMove()));

        bw.flush();
        bw.close();
    }
}
