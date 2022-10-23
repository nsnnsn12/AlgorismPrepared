package sunggyu.backjun.condigTest2.graph;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/12946
//육각 보드
/*
    변을 공유하고 있다면 같은 색깔을 칠할 수 없다.
    노드의 갯수는 최대 250개

    1. 그래프를 만든다.
    2. 인접한 그래프 중 동일하지 않은 색을 선택한다.
*/
public class Graph3{
    static BufferedReader bf;
    static BufferedWriter bw;
    static int N;
    static int[][] directions = {{0,1},{0,-1},{1,0},{-1,0},{-1,1},{1,-1}};
    static boolean[][] map;
    static int[][] colors;
    static int max = 0;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(bf.readLine());
        map = new boolean[N][N];
        colors = new int[N][N];
        for(int i = 0; i < N; i++){
            char[] list = bf.readLine().toCharArray();
            for(int j = 0; j < N; j++){
                if(list[j] == 'X'){
                    map[i][j] = true;
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] && colors[i][j] == 0){
                    bfs(i, j);
                }
            }
        }

        for(int i = 0; i < N; i++){
            System.out.println();
            for(int j = 0; j < N; j++){
                System.out.print(colors[i][j]+" ");

            }
        }
        System.out.println();
        System.out.println(max);
        bw.flush();
        bw.close();
    }

    public static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        while(!queue.isEmpty()){
            int[] info = queue.poll();
            int nx = info[0];
            int ny = info[1];

            if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if(colors[nx][ny] != 0) continue;

            colors[nx][ny] = findColor(nx, ny);
            max = Math.max(colors[nx][ny], max);
            for(int[] direction : directions){
                queue.add(new int[]{direction[0] + nx, direction[1] + ny});
            }
        }
    }

    public static int findColor(int x, int y){
        for(int i = 1; i <= N*N; i++){
            boolean flag = true;
            for(int[] direction : directions){
                int nx = direction[0] + x;
                int ny = direction[1] + y;
                if(!canVisit(nx, ny, i)){
                    flag = false;
                }
            }

            if(flag) return i;
        }
        return -1;
    }

    public static boolean canVisit(int x, int y, int color){
        if(x < 0 || x >= N || y < 0 || y >= N) return true;
        if(colors[x][y] != color) return true;
        return false;
    }


    
}
