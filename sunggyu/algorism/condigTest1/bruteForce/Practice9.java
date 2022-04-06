package sunggyu.algorism.condigTest1.bruteForce;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/14501
//퇴사
/*
*/
public class Practice9{
    static int[][] tpList;
    static int[] maxList;
    static int N;
    static boolean[] visit;
    static int result;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(bf.readLine());
        tpList = new int[N][2];
        for(int i = 0; i < N; i++){
            String[] split = bf.readLine().split(" ");
            tpList[i][0] = Integer.parseInt(split[0]);
            tpList[i][1] = Integer.parseInt(split[1]);
        }
        maxList = new int[N];
        visit = new boolean[N];
        for(int i = 0; i < N; i++){
            dfs(i);
        }
        System.out.println(result);
        bw.flush();
        bw.close();
    }

    public static void dfs(int depth){
        int cost = tpList[depth][1];
        int length = depth + tpList[depth][0]-1;
        if(length >= N) return;

        int max = 0;
        for(int i = length+1; i < N; i++){
            if(!visit[i]){
                dfs(i);
            }
            max = Math.max(max, maxList[i]);
        }
        maxList[depth] = cost + max;
        result = Math.max(maxList[depth], result);
    }
}
