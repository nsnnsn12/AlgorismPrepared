package sunggyu.algorism.condigTest1.bruteForce;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/15661
//링크와 스타트
/*
    n은 최대 20인 짝수
    팀의 인원이 서로 동일하지 않아도 되고 최소 1명이어야 한다.
    n이 10일 경우
    1명을 선택하면 9명은 자동적으로 선택
*/
public class Practice11{
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
        for(int i = 0; i < N / 2; i++){
            combo(0,0, i+1);
        }

        System.out.println(MIN);
        bw.flush();
        bw.close();
    }

    public static void combo(int depth, int start, int selected){
        if(depth == selected){
            int teamValue = getTeamValue();
            MIN = Math.min(MIN, teamValue);
            return;
        }

        for(int i = start; i < N; i++){
            comboList[i] = true;
            combo(depth+1, i+1, selected);
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
