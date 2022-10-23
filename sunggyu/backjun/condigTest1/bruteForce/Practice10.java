package sunggyu.backjun.condigTest1.bruteForce;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/14889
//스타트와 링크
/*
    n은 최대 20인 짝수
    n/2를 선택하는 모든 경우의 수를 탐색하여 최소 값을 찾는다.
    최대 경우의 수 184756
    184756 * 100 = 18475600
*/
public class Practice10{
    static int N;
    static int[][] MAP;
    static int MIN = Integer.MAX_VALUE;
    static boolean[] comboList;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(bf.readLine());
        MAP = new int[N][N];
        for(int i = 0; i < N; i++){
            String[] split = bf.readLine().split(" ");
            for(int j = 0; j < N; j++){
                MAP[i][j] = Integer.parseInt(split[j]);
            }
        }

        comboList = new boolean[N];
        combo(0,0);
        System.out.println(MIN);
        bw.flush();
        bw.close();
    }

    public static void combo(int depth, int start){
        if(depth == N/2){
            int teamValue = getTeamValue();
            MIN = Math.min(MIN, teamValue);
            return;
        }

        for(int i = start; i < N; i++){
            comboList[i] = true;
            combo(depth+1, i+1);
            comboList[i] = false;
        }
    }

    public static int getTeamValue(){
        int teamA = 0;
        int teamB = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(comboList[i] && comboList[j]){
                    teamA += MAP[i][j];
                }
                if(!comboList[i] && !comboList[j]){
                    teamB += MAP[i][j];
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
