package sunggyu.algorism.condigTest1.graph;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/11724
//연결 요소의 개수
/*
    dfs를 이용하여 탐색
*/
public class Graph3_review{
    static int N;
    static int M;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = bf.readLine().split(" ");
        N = Integer.parseInt(nm[0])+1;
        M = Integer.parseInt(nm[1]);
        for(int i = 0; i < N; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < M; i++){
            String[] ab = bf.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        visited = new boolean[N];
        int result = 0;
        for(int i = 1; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                result++;
                dfs(i);
            }
        }
        System.out.println(result);
        bw.flush();
        bw.close();
    }

    public static void dfs(int selected){
        for(int i = 0; i < graph.get(selected).size(); i++){
            int index = graph.get(selected).get(i);
            if(!visited[index]){
                visited[index] = true;
                dfs(index);
            }
        }
    }

}
