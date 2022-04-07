package sunggyu.algorism.condigTest1.bfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1697
//숨바꼭질
/*
*/
public class Bfs1{
    static int N;
    static int K;
    static boolean[] visit = new boolean[100001];
    static int[] list = new int[100001];
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nk = bf.readLine().split(" ");
        N = Integer.parseInt(nk[0]);
        K = Integer.parseInt(nk[1]);
        bfs();
        System.out.println(list[K]);
        bw.flush();
        bw.close();
    }

    public static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        int[] position = {N, 0};
        queue.add(position);
        while(!queue.isEmpty()){
            int[] nowPosition = queue.poll();
            int n = nowPosition[0];
            int depth = nowPosition[1];
            if(!visit[n]){
                visit[n] = true;
                list[n] = depth;
                int minusIndex = n -1;
                if(canVisit(minusIndex)){
                    int[] newPosition = {minusIndex, depth+1};
                    queue.add(newPosition);
                }

                int plusIndex = n + 1;
                if(canVisit(plusIndex)){
                    int[] newPosition = {plusIndex, depth+1};
                    queue.add(newPosition);
                }

                int mulitipleIndex = n * 2;
                if(canVisit(mulitipleIndex)){
                    int[] newPosition = {mulitipleIndex, depth+1};
                    queue.add(newPosition);
                }
            }
        }
    }

    public static boolean canVisit(int n){
        if(n < 0 || n >= visit.length) return false;

        return true;
    }
}
