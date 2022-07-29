package sunggyu.algorism.condigTest2.graph;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/16947
//서울 지하철 2호선
/*
    노드갯수 == 간선갯수 => 1개의 사이클(순환)이 존재하는 그래프
    노드갯수 == 간선갯수 - 1 => 트리 그래프
    
    
    dfs의 탐색 경로는 트리와 동일하다.
    트리와 동일한 이유는 이미 방문한 노드의 대해서 다시 방문하지 않기 때문이다.

    부모 노드로 돌아가지 않는다.
    부모 노드로 돌아가지 않고 재방문하는 경우가 있는가?
    1. 순환 그래프 상에서 처음과 끝이 만나는 경우

    고로 dfs를 이용한 탐색 후 남는 간선은 사이클의 처음과 끝을 잇는 간선이다.

    지선과 순환선 사이의 거리를 구하라.
    순환그래프의 속한 노드를 찾는다.
    순환그래프의 속하지 않은 노드와 순환 노드간의 거리를 찾는다.

    dfs를 이용하여 트리 간선 정보를 구함.
    주어진 간선 정보와 비교하여 남는 간선을 찾는다.
    남는 간선이 처음과 끝을 잇는 간선이다.
*/
public class Graph2{
    static BufferedReader bf;
    static BufferedWriter bw;    
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[][] visitedEdge;
    static int N;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(bf.readLine());
        init();


        String[] nodeInfos = new String[N];
        for(int i = 0; i < N; i++){
            nodeInfos[i] = bf.readLine();
        }

        setGraph(nodeInfos);
        System.out.println();
        //graph.stream().forEach(list -> System.out.println(list.toString()));
        dfs(new Node(1, 0));

        bw.flush();
        bw.close();
    }

    public static void init(){
        visited = new boolean[N+1];
        visitedEdge = new boolean[N+1][N+1];
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }
    }

    public static void dfs(Node node){
        visitedEdge[node.nodeNo][node.beforeNo] = true;
        visitedEdge[node.beforeNo][node.nodeNo] = true;
        visited[node.nodeNo] = true;

        List<Integer> childs = graph.get(node.nodeNo);
        for(int i = 0; i < childs.size(); i++){
            int nodeNo = childs.get(i);
            if(!visited[nodeNo]){
                dfs(new Node(nodeNo, node.nodeNo));
            }
            if(nodeNo != node.beforeNo && visited[nodeNo]){
                System.out.println(String.format("startIndex : %d, endIndex : %d", node.nodeNo, nodeNo));
            }
        }
    }

    public static void setGraph(String[] nodeInfos){
        for(int i = 0; i < N; i++){
            String[] split = nodeInfos[i].split(" ");
            int nodeNo = Integer.parseInt(split[0]);
            int targetNo = Integer.parseInt(split[1]);
            graph.get(nodeNo).add(targetNo);
            graph.get(targetNo).add(nodeNo);
        }
    }

    public static class Node{
        int beforeNo;
        int next;
        int nodeNo;
        public Node(int nodeNo, int beforeNo){
            this.nodeNo = nodeNo;
            this.beforeNo = beforeNo;
        }
    }
}
