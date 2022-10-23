package sunggyu.backjun.condigTest1.graph;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1707
//이분 그래프
/*
    한 정점을 기준으로 자식노드가 서로 연관 관계를 가지고 있는지만 확인
    테스트 케이스는 최대 5개
    한 테스트 케이스당 최대 2만개의 정점
*/
public class Graph4{
    public static class Graph{
        int n;
        List<List<Integer>> graph;
        boolean[] visit;
        boolean[] parts;
        boolean notBipartite;
        public Graph(int n, List<List<Integer>> graph){
            this.n = n;
            this.graph = graph;
            visit = new boolean[n];
            parts = new boolean[n];
        }

        public boolean notBipartite(){
            for(int i = 0; i < n; i++){
                if(!visit[i] && !notBipartite){
                    bfs(i);
                }
            }
            return notBipartite;
        }

        public void bfs(int v){
            Queue<Integer> queue = new LinkedList<>();
            queue.add(v);
            parts[v] = true;
            while(!queue.isEmpty() && !notBipartite){
                int node = queue.poll();
                boolean isValid = !parts[node];
                if(!visit[node]){
                    visit[node] = true;
                    
                    for(int i = 0; i < graph.get(node).size(); i++){
                        int nextNode = graph.get(node).get(i);
                        if(visit[nextNode]){
                            if(parts[nextNode] != isValid){
                                notBipartite = true;
                                break;
                            }
                        }else{
                            parts[nextNode] = isValid;
                            queue.add(nextNode);
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(bf.readLine());
        List<Graph> graphs = new ArrayList<>();
        for(int i = 0; i < t; i++){
            String[] ve = bf.readLine().split(" ");
            int v = Integer.parseInt(ve[0]);
            int e = Integer.parseInt(ve[1]);
            List<List<Integer>> graph = new ArrayList<>();
            for(int k = 0; k < v; k++){
                graph.add(new ArrayList<>());
            }
            for(int j = 0; j < e; j++){
                String[] split = bf.readLine().split(" ");
                int a = Integer.parseInt(split[0]) - 1;
                int b = Integer.parseInt(split[1]) - 1;
                graph.get(a).add(b);
                graph.get(b).add(a);
                
            }
            graphs.add(new Graph(v, graph));
        }

        graphs.forEach((o) -> {
            if(o.notBipartite()){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }
        });
        bw.flush();
        bw.close();
    }

    
}
