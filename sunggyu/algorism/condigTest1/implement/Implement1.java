package sunggyu.algorism.condigTest1.implement;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/16935
//배열 돌리기 3
/*
*/
public class Implement1{
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nmr = bf.readLine().split(" ");
        int n = Integer.parseInt(nmr[0]);
        int m = Integer.parseInt(nmr[1]);
        int r = Integer.parseInt(nmr[2]);
        int[] calcList = new int[r];
        int[][] map = new int[n][m];
        for(int i = 0; i < n; i++){
            String[] split = bf.readLine().split(" ");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(split[j]);
            }
        }
        if(r == 1){
            calcList[0] = Integer.parseInt(bf.readLine());
        }else{
            String[] split = bf.readLine().split(" ");
            for(int i = 0; i < r; i++){
                calcList[i] = Integer.parseInt(split[i]);
            }
        }

        for(int i : calcList){
            switch (i) {
                case 1:
                    one(map);
                    break;
                case 2:
                    two(map);
                    break;
                case 3:
                    map = three(map);
                    break;
                case 4:
                    map = four(map);
                    break;
                case 5:
                    
                    break;
                case 6:
                    
                    break;
            
                default:
                    break;
            }
        }
        
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[0].length; j++){
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        
        bw.flush();
        bw.close();
    }

    public static void one(int[][] map){
        int n = map.length;
        int m = map[0].length;
        for(int i = 0; i < n/2; i++){
            for(int j = 0; j < m; j++){
                int temp = map[i][j];
                map[i][j] = map[n-1-i][j];
                map[n-1-i][j] = temp;
            }
        }
    }

    public static void two(int[][] map){
        int n = map.length;
        int m = map[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m / 2; j++){
                int temp = map[i][j];
                map[i][j] = map[i][m-1-j];
                map[i][m-1-j] = temp;
            }
        }
    }

    public static int[][] three(int[][] map){
        int n = map.length;
        int m = map[0].length;

        int[][] temp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j <n; j++){
                temp[i][j] = map[n-1-j][i];
            }
        }

        return temp;
    }

    public static int[][] four(int[][] map){
        int n = map.length;
        int m = map[0].length;
        
        int[][] temp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j <n; j++){
                temp[i][j] = map[j][m-1-i];
            }
        }

        return temp;
    }
}
