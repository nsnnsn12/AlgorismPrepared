package sunggyu.algorism.condigTest1.bruteForce;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/3085
//사탕 게임
/*
    사탕의 색이 다른 인접한 두 칸이 무조건 존재한다.
    행과 열을 탐색하여 가장 긴 연속부분을 찾는다.

    모든 좌표를 기준으로 교체한다고 했을 때 250번
    모든 열과 행을 체크하는데 500번
    250 * 500 = 125000

*/
public class Practice2{
    static int n;
    static char[][] map;
    static int max = 0;
    static int[][] directions = {{1,0},{0,1}};
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());
        map = new char[n][n];

        for(int i = 0; i < n; i++){
            char[] charList = bf.readLine().toCharArray();
            for(int j = 0; j < n; j++){
                map[i][j] = charList[j];
            }
        }

        max = Math.max(getMaxRowCount(), max);
        max = Math.max(getMaxColumnCount(), max);

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int[] direct : directions){
                    int nx = i + direct[0];
                    int ny = j + direct[1];
                    if(canSwap(i, j, nx, ny)){
                        swap(i,j, nx, ny);
                        max = Math.max(getMaxRowCount(), max);
                        max = Math.max(getMaxColumnCount(), max);
                        swap(nx,ny,i,j);
                    }
                }
            }
        }
        System.out.println(max);
        bw.flush();
        bw.close();
    }

    public static boolean canSwap(int x, int y, int nx, int ny){
        if(nx >= n || nx == 0 || ny >= n || ny == 0) return false;
        if(map[x][y] == map[nx][ny]) return false;
        return true;
    }

    public static void swap(int x, int y, int nx, int ny){
        char temp = map[x][y];
        map[x][y] = map[nx][ny];
        map[nx][ny] = temp;
    }



    public static int getMaxRowCount(){
        int result = 0;
        for(int i = 0; i < n; i++){
            int maxLegth = 1;
            char eqauls = map[i][0];
            for(int j = 1; j < n; j++){
                if(eqauls == map[i][j]){
                    maxLegth++;
                }else{
                    result = Math.max(result, maxLegth);
                    maxLegth = 1;
                    eqauls = map[i][j];
                }
            }
            result = Math.max(result, maxLegth);
        }

        return result;
    }
    public static int getMaxColumnCount(){
        int result = 0;
        for(int i = 0; i < n; i++){
            int maxLegth = 1;
            char eqauls = map[0][i];
            for(int j = 1; j < n; j++){
                if(eqauls == map[j][i]){
                    maxLegth++;
                }else{
                    result = Math.max(result, maxLegth);
                    maxLegth = 1;
                    eqauls = map[j][i];
                }
            }
            result = Math.max(result, maxLegth);
        }

        return result;
    }
}
