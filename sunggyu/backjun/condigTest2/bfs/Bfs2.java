package sunggyu.backjun.condigTest2.bfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/16948
//데스 나이트
/*
*/
public class Bfs2{
    static BufferedReader bf;
    static BufferedWriter bw;
    static int[][] directions = {{-2, -1}, {-2, 1}, {0, -2}, {0, 2}, {2, -1}, {2, 1}};
    static int N;
    static int[][] map;
    static int[] goal = new int[2];
    static int[] start = new int[2];
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(bf.readLine());
        map = new int[N][N];
        String[] split = bf.readLine().split(" ");
        start[0] = Integer.parseInt(split[0]);
        start[1] = Integer.parseInt(split[1]);
        goal[0] = Integer.parseInt(split[2]);
        goal[1] = Integer.parseInt(split[3]);
        for(int i = 0; i < N; i++){
            Arrays.fill(map[i], Integer.MAX_VALUE);
        }
        bfs();
        int result = -1;
        if(map[goal[0]][goal[1]] != Integer.MAX_VALUE){
            result = map[goal[0]][goal[1]];
        }

        System.out.println(result);
        bw.flush();
        bw.close();
    }

    public static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1], 0});
        while(!queue.isEmpty()){
            int[] info = queue.poll();
            int x = info[0];
            int y = info[1];
            int count = info[2];
            if(!canVisit(x, y, count)) continue;
            map[x][y] = count;
            for(int i = 0; i < 6; i++){
                int nx = x + directions[i][0];
                int ny = y + directions[i][1];
                queue.add(new int[]{nx, ny, count+1});
            }
        }
    }

    public static boolean canVisit(int x, int y, int count){
        if(x < 0 || x >= N || y < 0 || y >= N) return false;
        if(map[x][y] <= count) return false;
        return true;
    }
}
