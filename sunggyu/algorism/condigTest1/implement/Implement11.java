package sunggyu.algorism.condigTest1.implement;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/16967
//배열 복원하기
/*
    1. 겹치지 않는 부분을 추출한다.
    2. 겹치지 않는 부분을 이용하여 원래 값을 복원한다.
    1,2번을 반복하여 원래 배열을 복원한다.

*/
public class Implement11{
    static int h;
    static int w;
    static int x;
    static int y;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] hwxy = bf.readLine().split(" ");
        h = Integer.parseInt(hwxy[0]);
        w = Integer.parseInt(hwxy[1]);
        x = Integer.parseInt(hwxy[2]);
        y = Integer.parseInt(hwxy[3]);

        int[][] map = new int[h+x][w+y];
        for(int i = 0; i < map.length; i++){
            String[] split = bf.readLine().split(" ");
            for(int j = 0; j < map[0].length; j++){
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        int[][] baseMap = new int[h][w];
        boolean[][] visited = new boolean[h][w];
        for(int i = 0; i < x; i++){
            for(int j = 0; j < w; j++){
                baseMap[i][j] = map[i][j];
                visited[i][j] = true;
            }
        }

        for(int i = 0; i < h; i++){
            for(int j = 0; j < y; j++){
                baseMap[i][j] = map[i][j];
                visited[i][j] = true;
            }
        }
        
        //원래 값 복원
        for(int i = x; i < h; i++){
            for(int j = y; j < w; j++){
                int base = map[i][j] - baseMap[i-x][j-y];
                baseMap[i][j] = base;
            }
        }
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                bw.append(baseMap[i][j]+" ");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
