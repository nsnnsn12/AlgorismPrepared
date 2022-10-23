package sunggyu.backjun.condigTest1.graph;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1260
//DFS와 BFS
/*
    먼저 탐색한 것의 대한 탐색 여부 처리를 명확히 해야 함
*/
public class Graph2{
    static int N;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visit;
    static List<Integer> dfsResult = new ArrayList<>();
    static List<Integer> bfsResult = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nmv = bf.readLine().split(" ");
        N = Integer.parseInt(nmv[0]);
        int m = Integer.parseInt(nmv[1]);
        int v = Integer.parseInt(nmv[2]);
        for(int i = 0; i < N; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++){
            String[] split = bf.readLine().split(" ");
            int a = Integer.parseInt(split[0])-1;
            int b = Integer.parseInt(split[1])-1;
            graph.get(a).add(b);
            graph.get(b).add(a);

        }

        for(int i = 0; i < N; i++){
            Collections.sort(graph.get(i));
        }
        visit = new boolean[N];
        dfs(v-1);

        visit = new boolean[N];
        bfs(v-1);
        dfsResult.forEach(n -> System.out.print(n+1 + " "));
        System.out.println();
        bfsResult.forEach(n -> System.out.print(n+1 + " "));
        bw.flush();
        bw.close();
    }

    public static void dfs(int v){
        if(!visit[v]){
            dfsResult.add(v);
            visit[v] = true;
            for(int i = 0; i < graph.get(v).size(); i++){
                int nextNode = graph.get(v).get(i);
                if(!visit[nextNode]){
                    dfs(nextNode);
                }
            }
        }
    }

    public static void bfs(int v){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        //bfs 핵심
        while(!queue.isEmpty()){
            int node = queue.poll();
            if(!visit[node]){
                visit[node] = true;
                bfsResult.add(node);

                for(int i = 0; i < graph.get(node).size(); i++){
                    int nextNode = graph.get(node).get(i);
                    queue.add(nextNode);
                }
            }
        }
    }
}
