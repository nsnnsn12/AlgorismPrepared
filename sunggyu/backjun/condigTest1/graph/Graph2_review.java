package sunggyu.backjun.condigTest1.graph;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1260
//DFS와 BFS
/*
    노드의 갯수 1000
    1000 * 1000 = 1000000(100만)
    완전탐색 가능
*/
public class Graph2_review{
    static int N;
    static int M;
    static List<List<Integer>> graph = new ArrayList<>();
    static List<Integer> dfsList = new ArrayList<>();
    static List<Integer> bfsList = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nmv = bf.readLine().split(" ");
        N = Integer.parseInt(nmv[0])+1;
        M = Integer.parseInt(nmv[1]);
        int v = Integer.parseInt(nmv[2]);
        String[] nodeInfos = new String[M];
        for(int i = 0; i < M; i++){
            nodeInfos[i] = bf.readLine();
        }
        setGraph(nodeInfos);

        boolean[] visited = new boolean[N];
        dfsList.add(v);
        visited[v] = true;
        dfs(visited, v);

        visited = new boolean[N];
        bfsList.add(v);
        visited[v] = true;
        bfs(visited, v);
        for(int i : dfsList){
            bw.write(i+" ");
        }
        bw.write("\n");
        for(int i : bfsList){
            bw.write(i+" ");
        }
        bw.flush();
        bw.close();
    }

    public static void bfs(boolean[] visited, int v){
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(v);

        while(!deque.isEmpty()){
            int selected = deque.poll();
            for(int i = 0; i < graph.get(selected).size(); i++){
                int index = graph.get(selected).get(i);
                if(!visited[index]){
                    bfsList.add(index);
                    visited[index] = true;
                    deque.add(index);
                }
            }
        }

    }

    public static void dfs(boolean[] visited, int selected){
        if(dfsList.size() == N){
            return;
        }

        for(int i = 0; i < graph.get(selected).size(); i++){
            int index = graph.get(selected).get(i);
            if(!visited[index]){
                dfsList.add(index);
                visited[index] = true;
                dfs(visited, index);
            }
        }
    }
    public static void setGraph(String[] nodeInfos){
        for(int i  = 0; i < N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            String[] ab = nodeInfos[i].split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        graph.forEach(list -> Collections.sort(list));
        //graph.forEach(list -> System.out.println(list.toString()));
    }
}
