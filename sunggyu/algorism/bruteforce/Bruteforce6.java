package sunggyu.algorism.bruteforce;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/15661
//링크와 스타트
//두 팀에 인원수는 같지 않아도 된다.
/*
    1 19
    2 18
    ..
    10 10
    20C1 = 20
    20C2 = 190
    20C3 = 1140
    20C4 = 4845
    20C5 = 15504
    20C6 = 38760
    20C7 = 77520
    20C8 = 125970
    20C9 = 167960
    20C10 = 184756
    총 경우의 수 대략 60만
*/

public class Bruteforce6{
    public static int N;
    public static int[][] map;
    public static boolean[] check;
    public static int min = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(bf.readLine());
        map = new int[N][N];
        check = new boolean[N];
        for(int i = 0; i < N; i++){
            String[] split = bf.readLine().split(" ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        for(int i = 1; i <= N/2; i++){
            if(min == 0) break;

            simulation(0, 0, i);
        }

        System.out.println(min);
        bw.flush();
        bw.close();
    }

    public static void simulation(int depth, int start, int number){
        if(min == 0){
            return;
        }
        if(depth == number){
            int diffTeamValue = getDiffTeamValue();
            min = min < diffTeamValue ? min : diffTeamValue;
            return;
        }

        for(int i = start; i < N; i++){
            check[i] = true;
            simulation(depth+1, i+1, number);
            check[i] = false;
        }
    }

    public static int getDiffTeamValue(){
        int result = 0;
        List<Integer> teamA = new ArrayList<>();
        List<Integer> teamB = new ArrayList<>();
        for(int i = 0; i < N; i++){
            if(check[i]){
                teamA.add(i);
            }else{
                teamB.add(i);
            }
        }
        int teamAValue = getTeamValue(teamA);
        int teamBValue = getTeamValue(teamB);

        result = teamAValue - teamBValue;
        result = result < 0 ? result * -1 : result;
        return result;
    }

    public static int getTeamValue(List<Integer> team){
        int result = 0;
        int n = team.size();
        if(n == 1) return 0;

        return result;
    }

}
