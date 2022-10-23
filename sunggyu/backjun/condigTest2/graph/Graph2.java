package sunggyu.backjun.condigTest2.graph;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/16947
//서울 지하철 2호선
/*
    노드갯수 == 간선갯수 => 1개의 사이클(순환)이 존재하는 그래프
    노드갯수 == 간선갯수 - 1 => 트리 그래프
    
    
    dfs의 탐색 경로는 트리와 동일하다.
    트리와 동일한 이유는 이미 방문한 노드의 대해서 다시 방문하지 않기 때문이다.

    dfs로 순환이 존재하는 그래프를 탐색하는 경우 특징
    1. 트리가 일렬이 된다.
    1. 순환 그래프 탐색의 시작과 끝이 만나게 된다.

    로직
    1. 순환 그래프의 속한 노드를 찾는다.
    2. bfs를 이용하여 순환그래프로부터 떨어진 노드의 거리를 찾는다.

    간선의 최대 갯수 3000개
    노드당 bfs를 실행한다고 했을 때의 최악의 경우의 수는 3000 * 3000 = 9000000
*/
public class Graph2{
    static BufferedReader bf;
    static BufferedWriter bw;    
    static List<List<Integer>> graph = new ArrayList<>(); //그래프
    static List<Node> tree = new ArrayList<>(); //dfs를 이용한 탐색 경로
    static int N;
    static boolean[] visited;
    static boolean[] isCycleNode; //순환그래프에 속한 노드 여부
    static boolean isFirst = true;;
    static int[] distances;
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
        
        dfs(new Node(1, 0));
        
        for(int i = 1; i < N+1; i++){
            if(!isCycleNode[i]){
                distances[i] = bfs(i);
            }
        }

        for(int i = 1; i < distances.length; i++){
            bw.append(distances[i]+"").append(" ");
        }
        bw.flush();
        bw.close();
    }

    public static void init(){
        visited = new boolean[N+1];
        isCycleNode = new boolean[N+1];
        distances = new int[N+1];
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
            tree.add(new Node(i, 0));
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

    public static void dfs(Node node){
        if(!isFirst) return;
        int parentNo = node.beforeNo;
        int nodeNo = node.nodeNo;

        //재방문인 경우
        //고로 순환하는 그래프의 처음과 끝이 만난 경우
        if(visited[nodeNo]){
            int startIndex = nodeNo;
            int endIndex = parentNo;
            
            setCycle(startIndex, endIndex);
            isFirst = false;
            return;
        }

        visited[nodeNo] = true;
        //순환그래프를 dfs로 탐색하는 경우
        //일렬로 탐색하기 때문에 부모 노드의 정보만 있어도 순환 그래프의 속한 노드들을 알 수 있다.
        tree.get(nodeNo).beforeNo = parentNo;

        List<Integer> childs = graph.get(nodeNo);
        for(int i = 0; i < childs.size(); i++){
            int charildNo = childs.get(i);
            //부모 노드가 아닌 경우
            if(charildNo != parentNo){
                dfs(new Node(charildNo, nodeNo));
            }
        }
    }

    //부모노드를 확인하며 순환그래프의 속한 노드를 찾는다.
    public static void setCycle(int startIndex, int endIndex){
        isCycleNode[startIndex] = true;
        int beforeNo = endIndex;
        while(beforeNo != startIndex){
            isCycleNode[beforeNo] = true;
            beforeNo = tree.get(beforeNo).beforeNo;
        }
    }

    //bfs를 이용하여 현재 노드로 부터 순환노드까지의 최단거리를 탐색한다.
    public static int bfs(int node){
        visited = new boolean[N+1];
        int result = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{node, 0});
        while(!queue.isEmpty()){
            int[] info = queue.poll();
            int nowNode = info[0];
            int distances = info[1];
            if(isCycleNode[nowNode]){
                result = distances;
                break;
            }

            if(visited[nowNode]) continue;

            visited[nowNode] = true;

            List<Integer> childs = graph.get(nowNode);
            for(int i = 0; i < childs.size(); i++){
                queue.add(new int[]{childs.get(i), distances + 1});
            }
        }

        return result;
    }
    public static class Node{
        int beforeNo;
        int nodeNo;
        public Node(int nodeNo, int beforeNo){
            this.nodeNo = nodeNo;
            this.beforeNo = beforeNo;
        }
    }
}
