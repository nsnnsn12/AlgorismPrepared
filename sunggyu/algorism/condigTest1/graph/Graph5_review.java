package sunggyu.algorism.condigTest1.graph;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/2667
//단지번호붙이기
/*
*/
public class Graph5_review{
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> result = new ArrayList<>();
        N = Integer.parseInt(bf.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++){
            char[] list = bf.readLine().toCharArray();
            for(int j = 0; j < N; j++){
                map[i][j] = (int)(list[j]-'0');
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j] && map[i][j] != 0){
                    result.add(bfs(i,j));
                }
            }
        }

        bw.write(result.size()+"\n");
        Collections.sort(result);
        for(int i : result){
            bw.write(i+"\n");
        }
        bw.flush();
        bw.close();
    }

    public static int bfs(int x, int y){
        int count = 1;
        Deque<int[]> deque = new ArrayDeque<>();
        visited[x][y] = true;
        int value = map[x][y];
        int[] xy = {x,y};
        deque.add(xy);

        while(!deque.isEmpty()){
            int[] now = deque.poll();
            for(int i = 0; i < 4; i++){
                int nx = directions[i][0] + now[0];
                int ny = directions[i][1] + now[1];
                if(canVisit(nx, ny) && !visited[nx][ny] && value == map[nx][ny]){
                    count++;
                    visited[nx][ny] = true;
                    int[] nxy = {nx,ny};
                    deque.add(nxy);
                }

            }
        }

        return count;
    }

    public static boolean canVisit(int x, int y){
        if(x < 0 || x >= N || y < 0 || y >= N) return false;
        return true;
    }
}
