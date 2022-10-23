package sunggyu.backjun.condigTest2.bruteforce.recursion;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
//https://www.acmicpc.net/problem/2580
//스도쿠
/*
    가로줄을 기준으로 방문한 적이 없어야 한다.
    세로줄을 기준으로 방문한 적이 없어야 한다.
    3 * 3을 기준으로 방문한 적이 없어야 한다.
*/
public class Recursion9{
    static BufferedReader bf;
    static BufferedWriter bw;
    static int[][] map = new int[9][9];
    static boolean[][] xVisited = new boolean[9][9];
    static boolean[][] yVisited = new boolean[9][9];
    static boolean[][] squareVisited = new boolean[9][9];
    static boolean flag;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i  = 0; i < 9; i++){
            String[] split = bf.readLine().split(" ");
            for(int j = 0; j < 9; j++){
                map[i][j] = Integer.parseInt(split[j]);
                if(map[i][j] != 0){
                    int squareNo = getSquareNo(i, j);
                    squareVisited[squareNo][map[i][j]-1] = true;
                    xVisited[i][map[i][j]-1] = true;
                    yVisited[j][map[i][j]-1] = true;
                }
            }
        }
        System.out.println();
        ySelected(0);

        bw.flush();
        bw.close();
    }

    public static void ySelected(int y) throws Exception{
        if(flag) return;
        if(y == 9){
            flag = true;
            for(int i  = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    bw.write(map[i][j] + " ");
                }
                bw.write("\n");
            }
            return;
        }
        //세로를 채우는 여러가지 경우의 수가 존재한다.
        xSeleted(0, y);
    }
    public static int getSquareNo(int x, int y){
        int result = 0;
        if(3 <= x && x < 6){
            result = 3;
        }

        if(6 <= x){
            result = 6;
        }

        if(3 <= y && y < 6){
            result += 1;
        }

        if(6 <= y){
            result += 2;
        }
        return result;
    }

    public static void xSeleted(int x, int y) throws Exception{
        if(flag) return;
        if(x == 9){
            ySelected(y+1);
            return;
        }
        int squareNo = getSquareNo(x, y);
        if(map[x][y] == 0){
            for(int i = 0; i < 9; i++){
                if(!xVisited[x][i] && !yVisited[y][i] && !squareVisited[squareNo][i]){
                    xVisited[x][i] = true;
                    yVisited[y][i] = true;
                    squareVisited[squareNo][i] = true;
                    map[x][y] = i+1;

                    xSeleted(x+1, y);

                    map[x][y] = 0;
                    xVisited[x][i] = false;
                    yVisited[y][i] = false;
                    squareVisited[squareNo][i] = false;
                }
            }
        }else{
            xSeleted(x+1, y);
        }
    }
}
