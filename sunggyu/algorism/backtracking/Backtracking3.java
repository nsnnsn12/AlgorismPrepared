package sunggyu.algorism.backtracking;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/18290
//NM과 K (1)
//최대 격자 칸의 갯수는 100개 최대로 뽑을 수 있는 수는 4개
//100 C 4 = 최대 경우의 수는 3921225
//완전 탐색 가능
public class Backtracking3{
    public static int[][] map;
    public static int n;
    public static int m;
    public static int k;
    public static List<int[]> comboList = new ArrayList<>();
    public static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nmk = bf.readLine().split(" ");
        n = Integer.parseInt(nmk[0]);
        m = Integer.parseInt(nmk[1]);
        k = Integer.parseInt(nmk[2]);

        map = new int[n][m];
        for(int i = 0; i < n; i++){
            String[] split = bf.readLine().split(" ");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(split[j]);
            }
        }
        combo(0,0);
        System.out.println(max);

        bw.flush();
        bw.close();
    }

    public static void combo(int depth, int start){
        if(depth == k){
            int sum = getSumValue();
            max = max > sum ? max : sum;
            return;
        }

        for(int i = start; i < n*m; i++){
            int x = 0;
            int y = 0;
            if(i != 0){
                x = i / m;
                y = i % m;
            }
            int[] xy ={x, y};
            if(canSelect(xy)){
                comboList.add(xy);
                combo(depth+1, i+1);
                comboList.remove(comboList.size()-1);
            }
        }
    }
    public static int getSumValue(){
        int result = 0;
        for(int[] xy : comboList){
            int x = xy[0];
            int y = xy[1];
            result += map[x][y];
        }
        return result;
    }
    public static boolean canSelect(int[] xy){
        int x = xy[0];
        int y = xy[1];
        for(int[] direction : directions){
            int nx = x + direction[0];
            int ny = y + direction[1];
            for(int[] nxy : comboList){
                if(nxy[0] == nx && nxy[1] == ny){
                    return false;
                }
            }
        }
        return true;
    }
}
