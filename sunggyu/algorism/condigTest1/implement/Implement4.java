package sunggyu.algorism.condigTest1.implement;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/14499
//주사위 굴리기
/*
    핵심
    명령에 의해 움직였을 때 주사위의 위치와 주사위의 바닥면과 윗면

    주사위는 6개의 면이 있다.

*/
public class Implement4{
    static int n;
    static int m;
    static int k;
    static int[][] map;
    static int[] orders;
    //동서북남
    int[][] directions = {{0,1}, {0,-1}, {-1,0},{1,0}};
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nmxyk = bf.readLine().split(" ");
        n = Integer.parseInt(nmxyk[0]);
        m = Integer.parseInt(nmxyk[1]);
        int x = Integer.parseInt(nmxyk[2]);
        int y = Integer.parseInt(nmxyk[3]);
        k = Integer.parseInt(nmxyk[4]);

        map = new int[n][m];
        for(int i = 0; i < n; i++){
            String[] split = bf.readLine().split(" ");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(split[j]);
            }
        }
        orders = new int[k];
        String[] split = bf.readLine().split(" ");
        for(int i = 0; i < k; i++){
            orders[i] = Integer.parseInt(split[i]);
        }

        Dice dice = new Dice(x, y, n, m, map);
        for(int i = 0; i < k; i++){
            boolean result = dice.move(orders[i]);
            if(result){
                bw.write(dice.out()+"\n");
            }
        }

        bw.flush();
        bw.close();
    }

    public static class Dice{
        int[] sides = new int[6];
        //동서북남
        int left = 3;
        int right = 2;
        int up = 1;
        int down = 4;
        int bottom = 0;
        int top = 5;
        //동서북남
        int[][] directions = {{0,1}, {0,-1}, {-1,0},{1,0}};
        int x;
        int y;
        int n;
        int m;
        int[][] map;
        public Dice(int x, int y, int n, int m, int[][] map){
            this.x = x;
            this.y = y;
            this.n = n;
            this.m = m;
            this.map = map;
        }
        public boolean canMove(int nx, int ny){
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) return false;
            return true;
        }
        public boolean move(int o){
            int nx = x + directions[o-1][0];
            int ny = y + directions[o-1][1];

            if(canMove(nx, ny)){
                x = nx;
                y = ny;
                roll(o);
                copy();

                return true;
            }

            return false;
        }

        public int out(){
            return sides[top];
        }

        public void copy(){
            if(map[x][y] == 0){
                map[x][y] = sides[bottom];
            }else{
                sides[bottom] = map[x][y];
                map[x][y] = 0;
            }
        }

        public void roll(int o){
            int tempBottom = bottom;
            int tempTop = top;
            int tempLeft = left;
            int tempRight = right;
            int tempUp = up;
            int tempDown = down;
            
            switch (o) {
                case 1: //동
                bottom = tempRight;
                top = tempLeft;
                left = tempBottom;
                right = tempTop;
                break;
                case 2: //서
                bottom = tempLeft;
                top = tempRight;
                left = tempTop;
                right = tempBottom;
                break;
                case 3: //북
                bottom = tempUp;
                top = tempDown;
                up = tempTop;
                down = tempBottom;
                break;
                case 4: //남
                bottom = tempDown;
                top = tempUp;
                up = tempBottom;
                down = tempTop;
                break;
                default:
                    break;
            }
        }
    }
    
}
