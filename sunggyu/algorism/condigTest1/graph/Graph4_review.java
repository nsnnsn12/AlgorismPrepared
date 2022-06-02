package sunggyu.algorism.condigTest1.graph;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1707
//이분 그래프
/*
    이분그래프란?
    정점이 2개의 그룹으로 나누어지는 것

    노드가 두 그룹을 번갈아가면서 끝까지 방문하면 이분그래프이다.
    bfs를 이용하여 서로 다른 그룹으로 방문 표시.
    서로 연결된 노드가 같은 그룹인 경우 false
*/
public class Graph4_review{
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(bf.readLine());
        String[] result = new String[t];
        for(int i = 0; i < t; i++){
            String[] ve = bf.readLine().split(" ");
            int v = Integer.parseInt(ve[0])+1;
            int e = Integer.parseInt(ve[1]);
            String[] nodeInfo = new String[e];
            for(int j = 0; j < e; j++){
                nodeInfo[j] = bf.readLine();
            }
            result[i] = getResult(v,e,nodeInfo);
        }
        for(String str : result){
            bw.write(str+"\n");
        }
        bw.flush();
        bw.close();
    }

    public static String getResult(int v, int e, String[] nodeInfo){
        int[] visited = new int[v];
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < v; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < e; i++){
            String[] ab = nodeInfo[i].split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i = 1; i < v; i++){
            if(visited[i] == 0){
                if(!bfs(graph, visited, i)) return "NO";
            }

        }
        return "YES";
    }

    public static boolean bfs(List<List<Integer>> graph, int[] visited, int start){
        visited[start] = 1;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(start);
        while(!deque.isEmpty()){
            int selected = deque.poll();
            for(int i = 0; i < graph.get(selected).size(); i++){
                int index = graph.get(selected).get(i);
                if(visited[index] == 0){
                    visited[index] = visited[selected] == 1 ? 2 : 1;
                    deque.add(index);
                    continue;
                }

                if(visited[index] == visited[selected]) return false;
            }
        }
        return true;
    }

    
}
