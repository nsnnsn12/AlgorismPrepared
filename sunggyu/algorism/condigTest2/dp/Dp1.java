package sunggyu.algorism.condigTest2.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/11048
//이동하기
/*
    단순 bfs로 푸는 경우 메모리 초과
    왜? 재방문으로 인해 queue의 메모리가 초과

    오른쪽, 아래, 대각선으로 이동한다.
    대각선으로 이동할 이유는 없다
    왜? 오른쪽과 아래로 이동하는 것만으로 대각선에 해당하는 칸을 방문할 수 있기 때문이다.
    고로 map[x][y]을 방문한다고 했을 때 거치는 경우의 수는 2개이다.
    위 : map[x-1][y], 아래 : map[x][y-1]

    dp를 풀 때의 핵심은 현재 인덱스의 유효값을 어떻게 구할 것인가?
*/
public class Dp1 {
    static BufferedReader bf;
    static BufferedWriter bw;
    static int N;
    static int M;
    static int[][] map;
    static int[][] dp;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = bf.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);
        map = new int[N+1][M+1];
        dp = new int[N+1][M+1];
        for(int i = 1; i <= N; i++){
            String[] split = bf.readLine().split(" ");
            for(int j = 1; j <= M; j++){
                map[i][j] = Integer.parseInt(split[j-1]);
            }
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + map[i][j];
            }
        }

        System.out.println(dp[N][M]);
        bw.flush();
        bw.close();
    }
}


