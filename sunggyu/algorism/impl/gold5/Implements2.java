package sunggyu.algorism.impl.gold5;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/14500
//테트로미노
/*
*/
public class Implements2{
    public static class Block{
        //0:동, 1:남, 2:서, 3:북
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        int x;
        int y;
        int[][] map;
        int n;
        int m;
        public Block(int x, int y, int[][] map, int n, int m){
            this.x = x;
            this.y = y;
            this.map = map;
            this.n = n;
            this.m = m;
        }

        public int typeA(){
            String[] directs = {"U","U","U"};
            int max = 0;
            for(int i = 0; i < 2; i++){
                int sum = getSumNumber(i, directs);
                max = max > sum ? max : sum;
            }

            return max;
        }

        public int typeB(){
            String[] directs = {"U","R","R"};
            int max = getSumNumber(0, directs);
            return max;
        }

        public int typeC(){
            String[][] directs = {{"U","U","L"}, {"U","U","R"}};
            int max = 0;
            for(int i = 0; i < 2; i++){
                for(int j = 0; j < 4; j++){
                    int sum = getSumNumber(j, directs[i]);
                    max = max > sum ? max : sum;
                }
            }

            return max;
        }

        public int typeD(){
            String[][] directs = {{"U","L","R"}, {"U","R","L"}};
            int max = 0;
            for(int i = 0; i < 2; i++){
                for(int j = 0; j < 2; j++){
                    int sum = getSumNumber(j, directs[i]);
                    max = max > sum ? max : sum;
                }
            }

            return max;
        }

        public int typeE(){
            String[] directs = {"U","U"};
            int max = 0;
            for(int i = 0; i < 4; i++){
                int sum = getSumNumber(i, directs);
                if(sum == 0) continue;

                int[] xy = getNewXY("U", i, x, y);
                xy = getNewXY("R", xy[2], xy[0], xy[1]);
                if(!canVisit(xy[0], xy[1])) continue;
                sum += map[xy[0]][xy[1]];

                max = max > sum ? max : sum;
            }

            return max;
        }



        public int getSumNumber(int d, String[] directs){
            int nx = x;
            int ny = y;
            int nd = d;
            int result = map[nx][ny];
            for(String direct : directs){
                int[] xy = getNewXY(direct, nd, nx, ny);
                nx = xy[0];
                ny = xy[1];
                nd = xy[2];
                if(!canVisit(nx, ny)) return 0;
                result += map[nx][ny];
            }
            return result;
        }

        public boolean canVisit(int x, int y){
            if(x < 0 || x >= n || y < 0 || y >= m) return false;
            return true;
        }

        public int[] getNewXY(String direct, int d, int x, int y){
            int[] xyd = new int[3];
            int nd = getNewDirect(direct, d);
            xyd[0] = x + directions[nd][0];
            xyd[1] = y + directions[nd][1];
            xyd[2] = nd;
            return xyd;
        }

        //0:동, 1:남, 2:서, 3:북
        public int getNewDirect(String direct, int d){
            switch (direct) {
                case "U":
                    return up(d);
                case "D":
                    return down(d);
                case "R":
                    return right(d);
                case "L":
                    return left(d);
            
                default:
                    break;
            }
            return 0;
        }
        public int up(int d){
            return d;
        }

        public int down(int d){
            int nd = d;
            if(nd >= 2){
                nd -= 2;
            }else{
                nd += 2;
            }
            return nd;
        }

        public int right(int d){
            int nd = (d+1) % 4;
            return nd;
        }

        public int left(int d){
            int nd = (d+3) % 4;
            return nd;
        }


    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = bf.readLine().split(" ");

        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[][] map = new int[n][m];

        for(int i = 0; i < n; i++){
            String[] split = bf.readLine().split(" ");
            for(int j = 0; j < m; j++){
                map[i][j] =Integer.parseInt(split[j]);
            }
        }

        Block block = new Block(0, 0, map, n, m);
        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                block.x = i;
                block.y = j;
                int a = block.typeA();
                max = max > a ? max : a;
                a = block.typeB();
                max = max > a ? max : a;
                a = block.typeC();
                max = max > a ? max : a;
                a = block.typeD();
                max = max > a ? max : a;
                a = block.typeE();
                max = max > a ? max : a;
            }
        }

        System.out.println(max);
        bw.flush();
        bw.close();
    }
}
