package sunggyu.algorism.condigTest1.implement;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/16926
//배열 돌리기 1
/*
*/
public class Implement2{
    //동남서북
    static int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    static int n;
    static int m;
    static int r;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nmr = bf.readLine().split(" ");
        n = Integer.parseInt(nmr[0]);
        m = Integer.parseInt(nmr[1]);
        r = Integer.parseInt(nmr[2]);

        map = new int[n][m];
        for(int i = 0; i < n; i++){
            String[] split = bf.readLine().split(" ");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        rotate();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                bw.write(map[i][j] + " ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    
    public static void rotate(){
        List<List<Integer>> sidesOfRectangle = getSidesOfRectangle();
        Scope scope = new Scope(0, 0, n, m);
        for(List<Integer> sides : sidesOfRectangle){
            swap(scope, sides);
            scope.next();
        }
    }

    public static void swap(Scope scope, List<Integer> sides){
        int nowX = scope.startX;
        int nowY = scope.satrtY;
        int nowIndex = r;
        for(int[] direct : directions){
            while(true){
                int nx = nowX + direct[0];
                int ny = nowY + direct[1];
                if(nx < scope.startX || nx >= scope.endX || ny < scope.satrtY || ny >= scope.endY){
                    break;
                }
                map[nowX][nowY] = sides.get(nowIndex % sides.size());
                nowIndex++;
                nowX = nx;
                nowY = ny;
            }
        }

    }

    public static List<List<Integer>> getSidesOfRectangle(){
        List<List<Integer>> sidesOfRectangle = new ArrayList<>();
        Scope scope = new Scope(0, 0, n, m);

        while(true){
            if(!scope.isValid()) break;
            List<Integer> sides = getSide(scope);
            scope.next();
            sidesOfRectangle.add(sides);
        }

        return sidesOfRectangle;
    }

    public static List<Integer> getSide(Scope scope){
        int nowX = scope.startX;
        int nowY = scope.satrtY;
        List<Integer> sides = new ArrayList<>();
        //sides.add(map[nowX][nowY]);
        for(int[] direct : directions){
            while(true){
                int nx = nowX + direct[0];
                int ny = nowY + direct[1];
                if(nx < scope.startX || nx >= scope.endX || ny < scope.satrtY || ny >= scope.endY){
                    break;
                }
                sides.add(map[nowX][nowY]);
                nowX = nx;
                nowY = ny;
            }
        }

        return sides;

    }

    public static class Scope{
        int startX;
        int satrtY;
        int endX;
        int endY;

        public Scope(int startX, int startY, int endX, int endY){
            this.startX = startX;
            this.satrtY = startY;
            this.endX = endX;
            this.endY = endY;
        }

        public boolean isValid(){
            if(startX >= endX || satrtY >= endY) return false;
            return true;
        }

        public void next(){
            startX++;
            satrtY++;
            endX--;
            endY--;
        }
    }
}
