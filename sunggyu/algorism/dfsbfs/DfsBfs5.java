package sunggyu.algorism.dfsbfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/18428
//감시 피하기
//36개 중 3개의 조합을 뽑는 경우의 수는 7,140
//완전 탐색 가능

public class DfsBfs5{
    public static int n;
    public static String[][] map;
    public static List<int[]> teacherPositions;
    public static int count;
    public static String result = "NO";
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        teacherPositions = new ArrayList<>();
        n = Integer.parseInt(bf.readLine());
        map = new String[n][n];

        for(int i = 0; i < n; i++){
            String[] split = bf.readLine().split(" ");
            for(int j = 0; j < n; j++){
                map[i][j] = split[j];
                if(map[i][j].equals("T")){
                    int[] xy = {i,j};
                    teacherPositions.add(xy);
                }
            }
        }

        combo(0,0);
        //System.out.println(teacherPositions.size());
        System.out.println(result);
        System.out.println(count);
        bw.flush();
        bw.close();
    }

    public static void combo(int depth, int start){
        if(result.equals("YES")){
            return;
        }

        if(depth == 3){
            if(canHide()){
                result = "YES";
            }
            count++;
            return;
        }

        for(int i = start; i < n*n; i++){
            int x = 0;
            int y = 0;
            if(i != 0){
                x = i / n;
                y = i % n;
            }

            if(map[x][y].equals("X")){
                map[x][y] = "B";
                combo(depth + 1, i + 1);
                map[x][y] = "X";
            }
        }
    }

    public static boolean canHide(){
        for(int[] teacherPosition : teacherPositions){
            if(findStudent(teacherPosition)){
                return false;
            }
        }
        return true;
    }

    public static boolean findStudent(int[] teacherPosition){
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int[] direction : directions){
            if(canFind(teacherPosition, direction)){
                return true;
            }
        }
        return false;
    }

    public static boolean canFind(int[] teacherPosition, int[] direction){
        int x = teacherPosition[0];
        int y = teacherPosition[1];
        boolean block = false;
        while(true){
            x += direction[0];
            y += direction[1];
            if(!canMove(x, y)){
                break;
            }

            if(map[x][y].equals("B")){
                block = true;
            }

            if(map[x][y].equals("S")){
                if(block){
                    return false;
                }else{
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean canMove(int x, int y){
        if(x < 0 || x >= n || y < 0 || y >= n){
            return false;
        }

        return true;
    }


}
