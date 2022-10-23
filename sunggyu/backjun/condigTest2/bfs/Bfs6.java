package sunggyu.backjun.condigTest2.bfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/16946
//벽 부수고 이동하기 4
/*
*/
public class Bfs6{
    static BufferedReader bf;
    static BufferedWriter bw;
    static int N;
    static int M;
    static int[][] map;
    static int[][] result;
    static int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    static List<Integer> sizeInfo = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] split = bf.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        map = new int[N][M];
        result = new int[N][M];
        for(int i = 0; i < N; i++){
            char[] mapInfo = bf.readLine().toCharArray();
            for(int j = 0; j < M; j++){
                if(mapInfo[j] == '1'){
                    map[i][j] = -1;
                }
            }
        }

        sizeInfo.add(0);
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0){
                    int size = dfs(i,j, sizeInfo.size());
                    sizeInfo.add(size);
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == -1){
                    int size = getSize(i,j) % 10;
                    result[i][j] = size;
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                bw.write(result[i][j]+"");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    public static int getSize(int x, int y){
        Set<Integer> set = new HashSet<>();
        int total = 1;
        for(int i = 0; i < 4; i++){
            int nx = directions[i][0] + x;
            int ny = directions[i][1] + y;
            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if(map[nx][ny] == -1) continue;
            int index = map[nx][ny];
            if(set.contains(index)) continue;
            int size = sizeInfo.get(index);
            total += size;
            set.add(index);
        }
        return total;
    }

    public static int dfs(int x, int y, int value){
        if(!canVisit(x, y)) return 0;
        map[x][y] = value;
        int result = 1;
        for(int i = 0; i < 4; i++){
            int nx = directions[i][0] + x;
            int ny = directions[i][1] + y;
            result += dfs(nx, ny, value);
        }

        return result;
    }

    public static boolean canVisit(int x, int y){
        if(x < 0 || x >= N || y < 0 || y >= M) return false;
        if(map[x][y] != 0) return false;
        return true;
    }
}
