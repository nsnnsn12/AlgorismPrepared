package sunggyu.backjun.condigTest2.bfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/14502
//연구소
/*
    map의 최대크기는 64
    64C3 = 41664
    41664 * 64 = 2666496

    안전영역의 최댓값을 구하라. 
    0은 빈 칸, 1은 벽, 2는 바이러스

    1. 빈칸의 대한 모든 경우의 수를 뽑는다.
    2. 벽을 세운다.
    3. 바이러스 전염의 대해 시뮬레이션한다.
    4. 안전영역을 확인한다.
    5. 모든 경우의 수만큼 2-5번을 반복한다.
*/
public class Bfs3{
    static BufferedReader bf;
    static BufferedWriter bw;
    static int[][] map;
    static int N;
    static int M;
    static List<Point> emptyPointList = new ArrayList<>();
    static int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    static int result;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = bf.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);
        map = new int[N][M];
        for(int i = 0; i < N; i++){
            String[] split = bf.readLine().split(" ");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(split[j]);
                if(map[i][j] == 0){
                    emptyPointList.add(new Point(i, j));
                }
            }
        }

        simulation(0, 0, new int[3]);

        System.out.println(result);
        bw.flush();
        bw.close();
    }

    public static void simulation(int depth, int startIndex, int[] selected){
        if(depth == 3){
            int safetyBoundary = getSafetyBoundary(selected);
            result = Math.max(result, safetyBoundary);
            return;
        }

        for(int i = startIndex; i < emptyPointList.size(); i++){
            selected[depth] = i;
            simulation(depth+1, i + 1, selected);
        }
    }

    public static int getSafetyBoundary(int[] selected){
        int[][] copyMap = copyMap();
        for(int i = 0; i < 3; i++){
            Point point = emptyPointList.get(selected[i]);
            copyMap[point.x][point.y] = 1;
        }

        spreadVirus(copyMap);
        
        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(copyMap[i][j] == 0) count++;
            }
        }
        return count;
    }

    public static void spreadVirus(int[][] copyMap){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(copyMap[i][j] == 2){
                    spread(i, j, copyMap);
                }
            }
        }
    }

    public static void spread(int x, int y, int[][] copyMap){
        Queue<int[]> queue =  new LinkedList<>();
        for(int i = 0; i < 4; i++){
            int nx = x + directions[i][0];
            int ny = y + directions[i][1];
            queue.add(new int[]{nx, ny});
        }

        while(!queue.isEmpty()){
            int[] position = queue.poll();
            int positionX = position[0];
            int positionY = position[1];
            if(!canVisit(positionX, positionY, copyMap)) continue;
            copyMap[positionX][positionY] = 3;
            for(int i = 0; i < 4; i++){
                int nx = positionX + directions[i][0];
                int ny = positionY + directions[i][1];
                queue.add(new int[]{nx, ny});
            }

        }
    }

    public static boolean canVisit(int x, int y, int[][] copyMap){
        if(x < 0 || x >= N || y < 0 || y >= M) return false;
        if(copyMap[x][y] == 1 || copyMap[x][y] == 2 || copyMap[x][y] == 3) return false;
        return true;
    }

    public static int[][] copyMap(){
        int[][] copyMap = new int[N][M];
        for(int i = 0; i < N; i++){
            copyMap[i] = Arrays.copyOf(map[i], M);
        }

        return copyMap;
    }

    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
