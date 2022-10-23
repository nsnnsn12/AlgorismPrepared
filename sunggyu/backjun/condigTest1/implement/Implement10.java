package sunggyu.backjun.condigTest1.implement;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/16931
//겉넓이 구하기
/*
    총 넓이 100 * 100 = 10000
    10000 * 100 = 1000000
    최대 탐색 횟수는 백만개
    상하좌우 탐색 시 *4니까 400만개
*/
public class Implement10{
    static int n;
    static int m;
    static int[][] map;
    static int totalCount;
    static int max = Integer.MIN_VALUE;
    static int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = bf.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        totalCount = n * m * 2;
        map = new int[n][m];
        for(int i = 0; i < n; i++){
            String[] split = bf.readLine().split(" ");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(split[j]);
                if(map[i][j] > max) max = map[i][j];
            }
        }
        //System.out.println();
        getAreaByDepth();
        System.out.println(totalCount);
        bw.flush();
        bw.close();
    }

    public static void getAreaByDepth(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int count = 0;
                for(int[] direct : directions){
                    int nx = i + direct[0];
                    int ny = j + direct[1];
                    if(canVisit(nx,ny)){
                        if(map[i][j] > map[nx][ny]) count+= map[i][j] - map[nx][ny];
                    }else{
                        count += map[i][j];
                    }
                }
                //System.out.print(count+" ");
                totalCount += count;
            }
            //System.out.println();
        }
    }

    public static boolean canVisit(int x, int y){
        if(x < 0 || x>= n || y < 0 || y >= m) return false;
        return true;
    }
}
