package sunggyu.algorism.condigTest1.graph;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/7562
//나이트의 이동
/*
*/
public class Graph8_review{
    static int[][] directions = {{0,1},{-1,0},{0,-1},{1,0}};
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(bf.readLine());
        int[] results = new int[t];
        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(bf.readLine());
            String[] split = bf.readLine().split(" ");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            int[] now = {x,y};

            split = bf.readLine().split(" ");
            x = Integer.parseInt(split[0]);
            y = Integer.parseInt(split[1]);
            int[] next = {x,y};
            results[i] = getMoveCount(n, now, next);
        }

        for(int i : results){
            bw.write(i+"\n");
        }
        bw.flush();
        bw.close();
    }

    public static int getMoveCount(int n, int[] now, int[] next){
        int[][] map = new int[n][n];
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(now);
        map[now[0]][now[1]] = 1;

        while(!deque.isEmpty()){
            if(map[next[0]][next[1]] != 0) break;
            int[] xy = deque.poll();
            int second = map[xy[0]][xy[1]];
            for(int i = 0; i < 4; i++){
                int nx = directions[i][0] * 2;
                int ny = directions[i][1] * 2;
                nx += xy[0];
                ny += xy[1];
                int[] left = getLeftPoint(nx, ny, i);
                int[] right = getRightPoint(nx, ny, i);

                if(canVisit(left, n, map)){
                    map[left[0]][left[1]] = second+1;
                    deque.add(left);
                }

                if(canVisit(right, n, map)){
                    map[right[0]][right[1]] = second+1;
                    deque.add(right);
                }
            }
        }
        return map[next[0]][next[1]]-1;
    }

    public static boolean canVisit(int[] xy, int n, int[][] map){
        if(xy[0] < 0 || xy[0] >= n || xy[1] < 0 || xy[1] >= n) return false;
        if(map[xy[0]][xy[1]] != 0) return false;
        return true;
    }

    public static int[] getLeftPoint(int x, int y, int index){
        int leftIndex = (index+1) % 4;
        int[] result = {x + directions[leftIndex][0], y + directions[leftIndex][1]};

        return result;
    }

    public static int[] getRightPoint(int x, int y, int index){
        int rightIndex = (index+3) % 4;
        int[] result = {x + directions[rightIndex][0], y + directions[rightIndex][1]};

        return result;
    }
}
