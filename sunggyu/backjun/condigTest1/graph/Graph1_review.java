package sunggyu.backjun.condigTest1.graph;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/13023
//ABCDE
/*
    dfs를 이용하여 depth가 5에 도달한다면 만족
    n의 최댓값은 2000
    2000 * 2000 = 4000000(400만)
    dfs로 완전 탐색 가능
*/
public class Graph1_review{
    static int N;
    static int M;
    static int result;
    static List<List<Integer>> graph = new ArrayList<>(); 
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = bf.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
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
        for(int i = 0; i < N; i++){
            visited[i] = true;
            dfs(1, i);
            visited[i] = false;
        }

        System.out.println(result);
        bw.flush();
        bw.close();
    }

    public static void dfs(int depth, int selected){
        if(result == 1) return;
        if(depth == 5){
            result = 1;
            return;
        }

        for(int i = 0; i < graph.get(selected).size(); i++){
            int index = graph.get(selected).get(i);
            if(!visited[index]){
                visited[index] = true;
                dfs(depth+1, index);
                visited[index] = false;
            }
        }
    }
}
