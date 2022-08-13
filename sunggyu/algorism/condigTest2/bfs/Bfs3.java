package sunggyu.algorism.condigTest2.bfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/14502
//연구소
/*
    map의 최대크기는 64
    64C3 = 41664
    41664 * 64 = 2666496

    안전영역의 최댓값을 구하라. 

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
    static List<Point> emptyList = new ArrayList<>();
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
                    emptyList.add(new Point(i, j));
                }
            }
        }
        bw.flush();
        bw.close();
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
