package sunggyu.algorism.bfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/10026
//적록색약
public class Bfs2{
    public static int n;
    public static char[][] map;
    public static int[][] directions = {{1,0}, {-1,0}, {0,1},{0,-1}};
    public static boolean[][] visit;
    public static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());
        map = new char[n][n];
        for(int i = 0; i < n; i++){
            char[] split = bf.readLine().toCharArray();
            for(int j = 0; j < n; j++){
                map[i][j] = split[j];
            }
        }

        int rgb = getRgbCount(true);
        int rb = getRgbCount(false);

        System.out.println(rgb+" "+ rb);
        bw.flush();
        bw.close();
    }

    public static int getRgbCount(boolean isRgb){
        int rgb = 0;
        visit = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visit[i][j]){
                    visit[i][j] = true;
                    rgb++;

                    char color = map[i][j];
                    int[] xy = {i,j};
                    queue.add(xy);
                    simulation(color, isRgb);
                }
            }
        }

        return rgb;
    }

    public static void simulation(char color, boolean isRgb){
        while(!queue.isEmpty()){
            int[] xy = queue.poll();
            for(int[] direction : directions){
                int nx = xy[0] + direction[0];
                int ny = xy[1] + direction[1];
                if(canMove(nx, ny, color, isRgb)){
                    int[] nxy = {nx, ny};
                    visit[nx][ny] = true;
                    queue.add(nxy);
                }
            }
        }
    }

    public static boolean canMove(int x, int y, char color, boolean isRgb){
        if(x < 0 || x >= n || y < 0 || y >= n) return false;
        if(visit[x][y]) return false;

        if(isRgb && map[x][y] != color) return false;

        if(map[x][y] != color){
            if(map[x][y] == 'B' || color == 'B') return false;
        }

        return true;
    }

    
}
