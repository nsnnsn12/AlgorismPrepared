package sunggyu.algorism.condigTest1.implement;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/16927
//배열 돌리기 2
/*
    sudo 코드
    1. 시계 방향으로 각 변의 리스트를 뽑는다.
    2. 리스트의 인덱스에 r을 더하여 rectangle에 넣는다.
*/
public class Implement3{
    static int n;
    static int m;
    static int r;
    static int[][] rectangle;
    //동남서북
    static int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nmr = bf.readLine().split(" ");
        n = Integer.parseInt(nmr[0]);
        m = Integer.parseInt(nmr[1]);
        r = Integer.parseInt(nmr[2]);
        rectangle = new int[n][m];

        for(int i = 0; i < n; i++){
            String[] split = bf.readLine().split(" ");
            for(int j = 0; j < m; j++){
                rectangle[i][j] = Integer.parseInt(split[j]);
            }
        }

        rotate();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                bw.write(rectangle[i][j] + " ");
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
        int nowY = scope.startY;
        int index = r;
        for(int[] direct : directions){
            while(true){
                if(!scope.canVisit(nowX, nowY)){
                    nowX -= direct[0];
                    nowY -= direct[1];
                    break;
                }
                rectangle[nowX][nowY] = sides.get(index % sides.size());
                index++;
                nowX += direct[0];
                nowY += direct[1];
            }
        }
    }

    public static List<List<Integer>> getSidesOfRectangle(){
        List<List<Integer>> getSidesOfRectangle = new ArrayList<>();
        Scope scope = new Scope(0, 0, n, m);
        while(true){
            if(!scope.isValid()) break;
            getSidesOfRectangle.add(getSides(scope));
            scope.next();
        }
        return getSidesOfRectangle;
    }

    public static List<Integer> getSides(Scope scope){
        List<Integer> sides = new ArrayList<>();
        int nowX = scope.startX;
        int nowY = scope.startY;
        for(int[] direct : directions){
            while(true){
                if(!scope.canVisit(nowX, nowY)){
                    nowX -= direct[0];
                    nowY -= direct[1];
                    break;
                }
                sides.add(rectangle[nowX][nowY]);
                nowX += direct[0];
                nowY += direct[1];
            }
        }
        return sides;
    }

    public static class Scope{
        int startX;
        int startY;
        int endX;
        int endY;
        public Scope(int startX, int startY, int endX, int endY){
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
        }

        public void next(){
            startX++;
            startY++;
            endX--;
            endY--;
        }

        public boolean isValid(){
            if(startX >= endX || startY >= endY) return false;
            return true;
        }

        public boolean canVisit(int x, int y){
            if(x < startX || x >= endX || y < startY || y >= endY) return false;
            return true;
        }
    }
}
