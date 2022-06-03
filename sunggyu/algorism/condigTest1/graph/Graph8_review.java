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
        bw.flush();
        bw.close();
    }

    public static int getMoveCount(int n, int[] now, int[] next){
        int[][] map = new int[n][n];

        return 0;
    }
}
