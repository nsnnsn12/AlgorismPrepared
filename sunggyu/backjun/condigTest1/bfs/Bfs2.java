package sunggyu.backjun.condigTest1.bfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/13913
//숨바꼭질4
/*
*/
public class Bfs2{
    static int N;
    static int K;
    static boolean[] visit = new boolean[100001];
    static int[][] list = new int[100001][2];
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nk = bf.readLine().split(" ");
        N = Integer.parseInt(nk[0]);
        K = Integer.parseInt(nk[1]);
        bfs();
        System.out.println(list[K][0]);
        List<Integer> relation = new ArrayList<>();
        relation.add(K);
        int beforeIndex = K;
        while(N != beforeIndex){
            relation.add(list[beforeIndex][1]);
            beforeIndex = list[beforeIndex][1];
        }
        Collections.reverse(relation);
        relation.forEach(r -> System.out.print(r+" "));
        bw.flush();
        bw.close();
    }

    public static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        int[] position = {N, 0, N};
        queue.add(position);
        while(!queue.isEmpty()){
            int[] nowPosition = queue.poll();
            int n = nowPosition[0];
            int depth = nowPosition[1];
            int beforeIndex = nowPosition[2];

            if(!visit[n]){
                visit[n] = true;
                list[n][0] = depth;
                list[n][1] = beforeIndex;

                int minusIndex = n -1;
                move(queue, minusIndex, depth, n);

                int plusIndex = n + 1;
                move(queue, plusIndex, depth, n);


                int mulitipleIndex = n * 2;
                move(queue, mulitipleIndex, depth, n);

            }
        }
    }

    public static void move(Queue<int[]> queue, int index, int depth, int beforeIndex){
        if(canVisit(index)){
            int[] newPosition = {index, depth+1, beforeIndex};
            queue.add(newPosition);
        }
    }

    public static boolean canVisit(int n){
        if(n < 0 || n >= visit.length) return false;

        return true;
    }
}
