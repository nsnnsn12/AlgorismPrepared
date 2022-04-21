package sunggyu.algorism.condigTest1.implement;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/16926
//배열 돌리기 1
/*
*/
public class Implement2{
    static int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nmr = bf.readLine().split(" ");
        int n = Integer.parseInt(nmr[0]);
        int m = Integer.parseInt(nmr[1]);
        int r = Integer.parseInt(nmr[2]);

        int[][] map = new int[n][m];
        for(int i = 0; i < n; i++){
            String[] split = bf.readLine().split(" ");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(split[j]);
            }
        }
        for(int i = 0; i < r; i++){
            map = turnLeft(map);
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        bw.flush();
        bw.close();
    }

    public static int[][] turnLeft(int[][] map){
        int[] firstNM = {0,0};
        int[] lastNM = {map.length, map[0].length};
        int[][] tempMap = new int[lastNM[0]][lastNM[1]];
        while(true){
            if(firstNM[0] >= lastNM[0] || firstNM[1] >= lastNM[1]) break;

            swap(map, tempMap, firstNM, lastNM);
            firstNM[0]++;
            firstNM[1]++;
            lastNM[0]--;
            lastNM[1]--;
        }

        return tempMap;
    }

    public static void swap(int[][] map, int[][] tempMap, int[] firstNM, int[] lastNM){
        int nowX = firstNM[0];
        int nowY = firstNM[1];
        int startX = firstNM[0];
        int startY = firstNM[1];
        int endX = lastNM[0];
        int endY = lastNM[1];

        for(int[] direct : directions){
            while(true){
                int nx = nowX + direct[0];
                int ny = nowY + direct[1];
                if(nx < startX || nx >= endX || ny < startY || ny >= endY){
                    break;
                }
                tempMap[nowX][nowY] = map[nx][ny];
                nowX = nx;
                nowY = ny;
            }
        }
    }
}
