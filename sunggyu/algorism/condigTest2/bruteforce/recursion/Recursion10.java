package sunggyu.algorism.condigTest2.bruteforce.recursion;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
//https://www.acmicpc.net/problem/4574
//스도미노쿠
/*
    도미노 쌍은 중복해서 사용하면 안 된다.
    총 도미노 쌍의 갯수
    8*9 = 72
    1,2 == 2,1
    72 /2 = 36

    1 + 2 = 3
    1 + 3 = 4
    1 + 4 = 5
    3 + 2 = 5

    1. 스도쿠의 조건을 만족시켜야 한다.
    2. 도미노의 쌍이 중복되어서는 안 된다.
*/
public class Recursion10{
    static BufferedReader bf;
    static BufferedWriter bw;
    static int[][] map;
    static boolean[][] xVisited;
    static boolean[][] yVisited;
    static boolean[][] squareVisited;
    static boolean[][] dominoVisited;
    static boolean flag;
    static int count = 1;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            int n = Integer.parseInt(bf.readLine());
            if(n == 0) break;
            map = new int[9][9];
            for(int i = 0; i < n; i++){
                String[] split = bf.readLine().split(" ");
                setMap(split[0], split[1]);
                setMap(split[2], split[3]);
            }

            String[] split = bf.readLine().split(" ");
            for(int i = 1; i <= 9; i++){
                setMap(i, split[i-1]);
            }

            for(int i  = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    System.out.print(map[i][j]+" ");
                }
                System.out.println();
            }

            resolve();
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void setMap(String strValue, String position){
        int value = Integer.parseInt(strValue);
        char[] xy = position.toCharArray();
        int x = (int)(xy[0] - 'A');
        int y = (int)(xy[1] - '0') - 1;
        map[x][y] = value;
    }

    public static void setMap(int value, String position){
        char[] xy = position.toCharArray();
        int x = (int)(xy[0] - 'A');
        int y = (int)(xy[1] - '0') - 1;
        map[x][y] = value;
    }

    public static void resolve(){
        xVisited = new boolean[9][9];
        yVisited = new boolean[9][9];
        squareVisited = new boolean[9][9];
        dominoVisited = new boolean[9][9];
        flag = false;
        for(int i  = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(map[i][j] != 0){
                    int squareNo = getSquareNo(i, j);
                    squareVisited[squareNo][map[i][j]-1] = true;
                    xVisited[i][map[i][j]-1] = true;
                    yVisited[j][map[i][j]-1] = true;
                    dominoVisited[i][j] = true;
                    dominoVisited[j][i] = true;
                }
            }
        }
        selected(0, 0);
    }
    public static void selected(int x, int y){
        if(flag) return;
        if(x == 9){
            //출력
            flag = true;
            sb.append("Puzzle "+count+"\n");
            count++;
            for(int i  = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
            return;
        }

        if(y == 9){
            selected(x+1, 0);
        }

        int squareNo = getSquareNo(x, y);
        if(map[x][y] == 0){
            for(int i = 0; i < 9; i++){
                if(!xVisited[x][i] && !yVisited[y][i] && !squareVisited[squareNo][i]){
                    xVisited[x][i] = true;
                    yVisited[y][i] = true;
                    squareVisited[squareNo][i] = true;
                    map[x][y] = i+1;

                    selected(x, y+1);

                    map[x][y] = 0;
                    xVisited[x][i] = false;
                    yVisited[y][i] = false;
                    squareVisited[squareNo][i] = false;
                }
            }
        }else{
            selected(x, y+1);
        }
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

    public static boolean canVisit(int x, int y, int i, int squareNo){
        if(!xVisited[x][i] && !yVisited[y][i] && !squareVisited[squareNo][i]){
            return true;
        }
        return false;
    }
}
