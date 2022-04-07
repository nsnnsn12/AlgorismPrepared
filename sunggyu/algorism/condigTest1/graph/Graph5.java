package sunggyu.algorism.condigTest1.graph;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/2667
//단지번호붙이기
/*
*/
public class Graph5{
    static int N;
    static int map[][];
    static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(bf.readLine());
        map = new int[N][N];
        for(int i = 0; i < N; i++){
            char[] list = bf.readLine().toCharArray();
            for(int j = 0; j < N; j++){
                map[i][j] = (int)(list[j] - '0');
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 1){
                    result.add(bfs(i,j));
                }
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        result.forEach(System.out::println);
        bw.flush();
        bw.close();
    }

    public static int bfs(int i, int j){
        int  count = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[] xy = {i,j};
        queue.add(xy);
        while(!queue.isEmpty()){
            int[] xy2 = queue.poll();
            int x = xy2[0];
            int y = xy2[1];
            if(map[x][y] == 1){
                count++;
                map[x][y] = 0;
                for(int[] direct : directions){
                    int nx = x + direct[0];
                    int ny = y + direct[1];
                    if(canVisit(nx, ny)){
                        int[] nxy = {nx, ny};
                        queue.add(nxy);
                    }
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
