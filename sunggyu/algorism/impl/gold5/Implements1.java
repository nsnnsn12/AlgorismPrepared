package sunggyu.algorism.impl.gold5;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/14503
//로봇 청소기
/*
*/
public class Implements1{
    public static class Robot{
        //서 : 0, 남 : 1, 동 : 2, 북 : 3
        int[][] directions = {{0,-1}, {1,0},{0,1},{-1,0}};
        int x;
        int y;
        int d;
        int[][] map;
        int cleanCount;
        boolean isBack;
        boolean shouldStop;

        public Robot(int x, int y, int d, int[][] map){
            this.x = x;
            this.y = y;
            this.d = d;
            this.map = map;
        }

        public void clean(){
            if(map[x][y] == 0){
                cleanCount++;
                map[x][y] = 2;
            }
        }

        public boolean canMove(){
            for(int i = 1; i <= 4; i++){
                int nd = (d + i) % 4;
                int nx = x + directions[nd][0];
                int ny = y + directions[nd][1];
                if(canVisit(nx, ny) && !isClean(nx,ny)){
                    this.x = nx;
                    this.y = ny;
                    d = nd;
                    return true;
                }

            }
            return false;
        }

        public boolean canVisit(int nx, int ny){
            int n = map.length;
            int m = map[0].length;
            if(nx < 0 || nx >=n || ny < 0 || ny >=m) return false;
            return true;
        }

        public boolean canBack(){
            int nd = d;
            if(nd >= 2){
                nd -= 2;
            }else{
                nd += 2;
            }
            int nx = x + directions[nd][0];
            int ny = y + directions[nd][1];
            if(canVisit(nx, ny) && !isWall(nx,ny)){
                this.x = nx;
                this.y = ny;
                return true;
            }
            return false;
        }

        public boolean isWall(int nx, int ny){
            if(map[nx][ny] == 1) return true;
            return false;
        }
        public boolean isClean(int nx, int ny){
            if(map[nx][ny] == 0) return false;

            return true;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = bf.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        String[] xyd = bf.readLine().split(" ");
        int x = Integer.parseInt(xyd[0]);
        int y = Integer.parseInt(xyd[1]);
        int d = Integer.parseInt(xyd[2]);
        int[][] map = new int[n][m];
        for(int i = 0; i < n; i++){
            String[] split = bf.readLine().split(" ");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(split[j]);
            }

        }

        Robot robot = new Robot(x, y, 3-d, map);
        //서 : 0, 남 : 1, 동 : 2, 북 : 3
        robot.clean();
        while(true){
            if(robot.canMove()){
                robot.clean();
                continue;
            }

            if(robot.canBack()){
                continue;
            }

            break;
        }

        System.out.println(robot.cleanCount);
        bw.flush();
        bw.close();
    }
}
