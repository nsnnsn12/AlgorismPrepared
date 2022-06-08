package sunggyu.algorism.condigTest2.bruteforce.recursion;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
//https://www.acmicpc.net/problem/16197
//두 동전
/*
    최대 크기는 400

    버튼을 10번 이상 누르면 떨어진다.
    상하좌우 4가지 방향에 대해 10개의 순열을 만드는 모든 경우의 수를 구한다.
    경우의 수를 실행시켜 최솟값을 구한다.
    1048576
*/
public class Recursion6{
    static BufferedReader bf;
    static BufferedWriter bw;
    static int N;
    static int M;
    static char[][] map;
    static int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    static int[] permutation = new int[10];
    static int[][] coin = new int[2][2];
    static int min = 10;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] split = bf.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        map = new char[N][M];
        int index = 0;
        for(int i = 0 ; i < N; i++){
            char[] chars = bf.readLine().toCharArray();
            for(int j = 0; j < M; j++){
                map[i][j] = chars[j];
                if(map[i][j] == 'o'){
                    coin[index][0] = i;
                    coin[index][1] = j;
                    index++;
                }
            }
        }
        per(0);
        if(min == 10){
            min = -1;
        }else{
            min++;
        }
        System.out.println(min);
        bw.flush();
        bw.close();
    }

    public static void per(int depth){
        if(depth == 10){
            move(0, coin[0][0], coin[0][1], coin[1][0], coin[1][1]);
            return;
        }

        for(int i = 0; i < 4; i++){
            permutation[depth] = i;
            per(depth+1);
        }
    }

    public static void move(int depth, int x1, int y1, int x2, int y2){
        if(depth >= min){
            return;
        }

        int d = permutation[depth];
        int[] direction = directions[d];
        
        int nx1 = x1 + direction[0];
        int ny1 = y1 + direction[1];

        int nx2 = x2 + direction[0];
        int ny2 = y2 + direction[1];

        if(!canVisit(nx1, ny1) && !canVisit(nx2, ny2)){
            return;
        }

        if(!canVisit(nx1, ny1) || !canVisit(nx2, ny2)){
            min = Math.min(min, depth);
            return;
        }

        if(map[nx1][ny1] == '#'){
            nx1 = x1;
            ny1 = y1;
        }

        if(map[nx2][ny2] == '#'){
            nx2 = x2;
            ny2 = y2;
        }

        move(depth+1, nx1, ny1, nx2, ny2);
    }

    public static boolean canVisit(int x, int y){
        if(x < 0 || x >= N || y < 0 || y >= M) return false;
        return true;
    }
}
