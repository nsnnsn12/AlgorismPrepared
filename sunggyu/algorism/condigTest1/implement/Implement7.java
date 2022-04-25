package sunggyu.algorism.condigTest1.implement;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/14503
//로봇청소기
/*
*/
public class Implement7{
    static int n;
    static int m;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = bf.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        String[] xyd = bf.readLine().split(" ");
        int x = Integer.parseInt(xyd[0]);
        int y = Integer.parseInt(xyd[1]);
        int d = Integer.parseInt(xyd[2]);

        map = new int[n][m];
        for(int i = 0; i < n; i++){
            String[] split = bf.readLine().split(" ");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        Robot robot = new Robot(x, y, d, map);
        while(true){
            if(robot.canClean()){
                robot.clean();
            }
            //왼쪽 방향 탐색
            for(int i = 0; i < 4; i++){
                //빈공간 탐색 성공 시 움직임
                if(robot.search()){
                    robot.move();
                    break;
                }
            }
            //청소하지 않은 빈공간을 찾은 경우
            if(robot.canClean()) continue;

            //그렇지 못 한 경우
            if(robot.canBackward()){
                robot.backwordMove();
                continue;
            }

            break;
        }

        System.out.println(robot.count);
        bw.flush();
        bw.close();
    }

    static class Robot{
        int x;
        int y;
        int d;
        int[][] map;
        int count;
        //북0 동1 남2 서3
        int[][] direction = {{-1,0},{0,1},{1,0},{0,-1}};
        public Robot(int x, int y, int d, int[][] map){
            this.x = x;
            this.y = y;
            this.d = d;
            this.map = map;
        }

        public boolean canClean(){
            if(map[x][y] == 0) return true;

            return false;
        }

        public void clean(){
            map[x][y] = 2;
            count++;
        }

        public boolean search(){
            d = (d+3) % 4;
            int nx = direction[d][0] + x;
            int ny = direction[d][1] + y;
            if(canMoveAndClean(nx, ny)){
                return true;
            }

            return false;
        }

        public void move(){
            x = direction[d][0] + x;
            y = direction[d][1] + y;
        }

        public boolean canMoveAndClean(int x, int y){
            int n = map.length;
            int m = map[0].length;
            if(x < 0 || x >= n || y < 0 || y >= m) return false;
            if(map[x][y] != 0) return false;

            return true;
        }

        public boolean canBackward(){
            int nd = (d + 2) % 4;
            int nx = direction[nd][0] + x;
            int ny = direction[nd][1] + y;

            int n = map.length;
            int m = map[0].length;
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) return false;
            if(map[nx][ny] == 1) return false;

            return true;
        }

        public void backwordMove(){
            int nd = (d + 2) % 4;
            x = direction[nd][0] + x;
            y = direction[nd][1] + y;
        }
    }
}
