package sunggyu.algorism.condigTest1.bfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/13549
//숨바꼭질 3
/*
    x - 1 -> 1초
    x + 1 -> 1초
    x * 2 -> 0초

    x * 2에 대해서 깊이 우선 탐색 후 나머지 너비 우선 탐색
    위에 조건이 만족할 수 있는 이유는?
    x - 1, x + 1 보다 x * 2의 값이 크기 때문에
*/
public class Bfs4{
    static int LENGTH = 100001;
    static int[] seconds = new int[LENGTH];
    static boolean[] visited = new boolean[LENGTH];
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nk = bf.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        
        bfs(n);

        System.out.println(seconds[k]);
        bw.flush();
        bw.close();
    }

    public static void bfs(int n){
        Queue<int[]> queue = new LinkedList<>();
        int[] info = {n, 0};
        queue.add(info);
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int nowPoint = now[0];
            int nowSecond = now[1];
            if(!canVisit(nowPoint)) continue;
            if(visited[nowPoint]) continue;

            visited[nowPoint] = true;
            seconds[nowPoint] = nowSecond;
            if(nowPoint != 0) dfs(nowPoint * 2, nowSecond, queue);

            int[] plus = {nowPoint+1, nowSecond + 1};
            queue.add(plus);

            int[] minus = {nowPoint-1, nowSecond + 1};
            queue.add(minus);
        }
    }

    public static void dfs(int point, int second, Queue<int[]> queue){
        if(!canVisit(point)) return;
        int[] info = {point, second};
        queue.add(info);
        dfs(point * 2, second, queue);
    }

    public static boolean canVisit(int point){
        if(point < 0 || point >= LENGTH) return false;
        return true;
    }
}
