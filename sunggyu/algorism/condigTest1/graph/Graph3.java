package sunggyu.algorism.condigTest1.graph;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/11724
//연결 요소의 개수
/*
*/
public class Graph3{
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = bf.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        visit = new boolean[n];
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++){
            String[] split = bf.readLine().split(" ");
            int a = Integer.parseInt(split[0])-1;
            int b = Integer.parseInt(split[1])-1;

            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            if(!visit[i]){
                count++;
                dfs(i);
            }
        }

        System.out.println(count);
        bw.flush();
        bw.close();
    }

    public static void dfs(int node){
        if(!visit[node]){
            visit[node] = true;
            for(int i = 0; i < graph.get(node).size(); i++){
                int nextNode = graph.get(node).get(i);
                dfs(nextNode);
            }
        }
    }
}
