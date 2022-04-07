package sunggyu.algorism.condigTest1.graph;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/2178
//미로 탐색
/*
*/
public class Graph6{
    static int N;
    static int M;
    static int map[][];
    static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = bf.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);
        map = new int[N][M];

        for(int i = 0; i < N; i++){
            char[] list = bf.readLine().toCharArray();
            for(int j = 0; j < M; j++){
                map[i][j] = (int)(list[j]-'0');
            }
        }

        bfs(0,0);

        System.out.println(map[N-1][M-1]);
        bw.flush();
        bw.close();
    }

    public static void bfs(int i , int j){
        Queue<int[]> queue = new LinkedList<>();
        int[] ij = {i,j, 0};
        queue.add(ij);

        while(!queue.isEmpty()){
            int[] xy = queue.poll();
            int x = xy[0];
            int y = xy[1];
            int depth = xy[2];
            if(map[x][y] == 1){
                map[x][y] = depth + 1;
                for(int[] direct : directions){
                    int nx = direct[0] + x;
                    int ny = direct[1] + y;
                    if(canVisit(nx, ny)){
                        int[] nxy = {nx,ny, map[x][y]};
                        queue.add(nxy);
                    }
                }
            }
        }
    }

    public static boolean canVisit(int x, int y){
        if(x < 0 || x >= N || y < 0 || y >= M) return false;
        return true;
    }
}
