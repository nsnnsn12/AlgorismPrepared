package sunggyu.backjun.condigTest2.bruteforce.Permutation;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/14889
//스타트와 링크
/*
    N은 최대 20
    20C10 => 184756 대략 18만

    1,2,3,4,5,6

    123, 456

    1. 모든 조합의 경우의 수를 탐색한다.
    2. 경우의 수에 해당하는 값을 구한다.
*/
public class Permutation3{
    static BufferedReader bf;
    static BufferedWriter bw;
    static int N;
    static int[][] map;
    static boolean[] teams;
    static int[] teamA;
    static int[] teamB;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(bf.readLine());
        map = new int[N][N];
        for(int i = 0; i < N; i++){
            String[] split = bf.readLine().split(" ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        teams = new boolean[N];
        teamA = new int[N/2];
        teamB = new int[N/2];
        teams[0] = true;
        combo(1, 1);

        System.out.println(min);
        bw.flush();
        bw.close();
    }

    public static void combo(int depth, int startIndex){
        if(depth == N / 2){
            min = Math.min(min, getTeamValue());
            return;
        }

        for(int i = startIndex; i < N; i++){
            teams[i] = true;
            combo(depth + 1, i+1);
            teams[i] = false;
        }
    }

    public static int getTeamValue(){
        int teamA = 0;
        int teamB = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(teams[i] && teams[j]){
                    teamA += map[i][j];
                }
                if(!teams[i] && !teams[j]){
                    teamB += map[i][j];
                }
            }
        }
        //System.out.println(teamA);
        //System.out.println(teamB);
        int diff = teamA - teamB;
        diff = diff > 0 ? diff : diff * -1;
        return diff;
    }
}
