package sunggyu.algorism.condigTest1.permutation;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/10971
//외판원 순회 2
/*
    도시의 수가 최대 10개이고
    각 도시를 한 번씩만 방문할 수 있다.
    도시를 방문하는 순서의 대한 모든 경우의 수를 구할 수 있다.
    
*/
public class Permutation5{
    static int N;
    static boolean[] visited;
    static int[][] map;
    static int[] perList;
    static long MIN = Long.MAX_VALUE;
    static long DISTANCE = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(bf.readLine());
        map = new int[N][N];
        visited = new boolean[N];
        perList = new int[N];
        for(int i = 0; i < N; i++){
            String[] split = bf.readLine().split(" ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(split[j]);
            }
        }

        per(0);

        System.out.println(MIN);
        bw.flush();
        bw.close();
    }

    public static void per(int depth){
        if(depth == N){
            int a = perList[depth-1];
            int b = perList[0];
            int distance = map[a][b];
            if(distance == 0) return;

            DISTANCE += distance;
            MIN = Long.min(MIN, DISTANCE);
            DISTANCE -= distance;
            return;
        }

        for(int i = 0; i < N; i++){
            if(!visited[i]){
                perList[depth] = i;
                int distance = 0;
                if(depth > 0){
                    int a = perList[depth-1];
                    int b = perList[depth];
                    distance = map[a][b];
                    if(distance == 0) continue;
                }
                DISTANCE += distance;
                visited[i] = true;
                per(depth+1);
                DISTANCE -= distance;
                visited[i] = false;
            }
        }
    }

    
}
