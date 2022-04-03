package sunggyu.algorism.bfs.gold5;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/2589
//보물섬
/*
    최대 맵의 크기는 250
    250번 각각의 대해 최단 거리를 잰다고 했을 때 250 * 250
    62500이므로 완전 탐색이 가능하다.
*/
public class Bfs5{
    public static int n;
    public static int m;
    public static char[][] map;
    public static boolean[][] visit;
    public static int[][] distance;
    public static Queue<int[]> queue;
    public static int[][] directions = {{0,1},{0,-1}, {1, 0}, {-1, 0}};
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] xy = bf.readLine().split(" ");
        n = Integer.parseInt(xy[0]);
        m = Integer.parseInt(xy[1]);
        map = new char[n][m];
        for(int i = 0; i < n; i++){
            char[] split = bf.readLine().toCharArray();
            for(int j = 0; j < m; j++){
                map[i][j] = split[j];
            }
        }

        int result = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 'L'){
                    visit = new boolean[n][m];
                    distance = new int[n][m];
                    queue  = new LinkedList<>();

                    visit(i, j, -1);
                    int maxDistance = getMaxDistance();
                    result = result > maxDistance ? result : maxDistance;
                }
            }
        }

        System.out.println(result);
        bw.flush();
        bw.close();
    }

    public static int getMaxDistance(){
        int max = 0;
        while(!queue.isEmpty()){
            int[] xy = queue.poll();
            int x = xy[0];
            int y = xy[1];
            for(int[] direction : directions){
                int nx = x + direction[0];
                int ny = y + direction[1];

                if(canMove(nx, ny)){
                    visit(nx, ny, distance[x][y]);
                    max = max > distance[x][y] + 1 ? max : distance[x][y]+1;
                }

            }
        }
        return max;
    }

    public static void visit(int x, int y, int d){
        visit[x][y] = true;
        distance[x][y] = d+1;
        int[] xy = {x,y};
        queue.add(xy);
    }

    public static boolean canMove(int x, int y){
        if(x < 0 || x >= n || y < 0 || y >= m){
            return false;
        }

        if(visit[x][y]) return false;

        if(map[x][y] == 'W') return false;

        return true;
    }
}
