package sunggyu.algorism.dfsbfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/16234
//인구 이동
//최대 맵의 크기는 250
//인구 이동이 발생하는 일수가 2000번보다 적다고 하니
//최대 경우의 수는 250 * 2000 = 500000

public class DfsBfs6{
    public static int N;
    public static int L;
    public static int R;
    public static int[][] map;
    public static int sum;
    public static int count;
    public static int[][] tempMap;
    public static int unitedCount;
    public static List<Integer> unitedInfo;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nlr = bf.readLine().split(" ");
        N = Integer.parseInt(nlr[0]);
        L = Integer.parseInt(nlr[1]);
        R = Integer.parseInt(nlr[2]);

        map = new int[N][N];

        for(int i = 0; i < N; i++){
            String[] split = bf.readLine().split(" ");
            for(int j = 0; j < N;j ++){
                map[i][j] = Integer.parseInt(split[j]);
            }
        }
        int moveCount = 0;
        while(canUnited()){
            move();
            moveCount++;
        }

        // for(int i = 0; i < N; i++){
        //     for(int j = 0; j < N;j ++){
        //         System.out.print(tempMap[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        // for(int i = 0; i < N; i++){
        //     for(int j = 0; j < N;j ++){
        //         System.out.print(map[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        System.out.println(moveCount);

        bw.flush();
        bw.close();
    }

    public static boolean canUnited(){
        boolean result = false;
        tempMap = new int[N][N];
        unitedInfo = new ArrayList<>();
        unitedCount = 1;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N;j ++){
                sum = 0;
                count = 0;
                if(tempMap[i][j] == 0){
                    //dfs
                    dfs(i, j);
                    int man = 0;
                    if(sum != 0){
                        man = sum/count;
                    }
                    unitedInfo.add(man);
                    unitedCount++;
                    if(count > 1){
                        result = true;
                    }
                }
            }
        }
        return result;
    }

    public static void move(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N;j ++){
                int united = tempMap[i][j] - 1;
                map[i][j] = unitedInfo.get(united);
            }
        }
    }

    //dfs를 이용해 조건에 맞는 인접한 지역의 인원과 count를 센다
    public static void dfs(int x, int y){
        tempMap[x][y] = unitedCount;
        count++;
        sum += map[x][y];

        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int[] direction : directions){
            int nx = x + direction[0];
            int ny = y + direction[1];

            if(canMove(x, y, nx, ny)){
                dfs(nx, ny);
            }
        }   

    }

    public static boolean canMove(int x, int y, int nx, int ny){
        if(nx < 0 || nx >= N || ny < 0 || ny >= N){
            return false;
        }

        if(tempMap[nx][ny] != 0){
            return false;
        }

        int beforeCountry = map[x][y];
        int afterCountry = map[nx][ny];

        int distance = beforeCountry - afterCountry;
        distance = distance < 0 ? distance * -1 : distance;

        //L명 이상, R명 이하
        if(distance < L || distance > R){
            return false;
        }

        return true;
    }
}
