package sunggyu.algorism.bfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/7576
//토마토
public class Bfs1{
    public static int n;
    public static int m;
    public static int[][] map;
    public static Queue<int[]> tomatos = new LinkedList<>();
    public static int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public static int endDay;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = bf.readLine().split(" ");
        m = Integer.parseInt(nm[0]);
        n = Integer.parseInt(nm[1]);
        map = new int[n][m];

        for(int i = 0; i < n; i++){
            String[] split = bf.readLine().split(" ");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(split[j]);
                if(map[i][j] == 1){
                    int[] xy = {i, j};
                    tomatos.add(xy);
                }
            }
        }

        simulation();


        if(!mapCheck()) endDay = -1;
        System.out.println(endDay);
        bw.flush();
        bw.close();
    }

    public static boolean mapCheck(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 0) return false;
            }
        }
        return true;
    }

    public static void simulation(){
        Queue<int[]> temp = new LinkedList<>();
        while(!tomatos.isEmpty()){
            int[] xy = tomatos.poll();
            for(int[] direction : directions){
                int nx = xy[0] + direction[0];
                int ny = xy[1] + direction[1];
                if(canMove(nx, ny)){
                    map[nx][ny] = 1;
                    int[] nxy = {nx, ny};
                    temp.add(nxy);
                }
            }
        }

        if(!temp.isEmpty()){
            endDay++;
            tomatos = temp;
            simulation();
        }
    }

    public static boolean canMove(int x, int y){
        if(x < 0 || x >= n || y < 0 || y >= m){
            return false;
        }

        if(map[x][y] != 0) return false;

        return true;
    }
}
