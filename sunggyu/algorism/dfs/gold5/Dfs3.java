package sunggyu.algorism.dfs.gold5;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/2668
//숫자고르기
/*
    아래 숫자를 기준으로 그래프를 그릴 때 노드가 서로 연결되어 있다는 의미는
    연결된 숫자가 위에 있다는 뜻이 된다.
    
    처음 시작과 끝이 동일하면 서로 집합을 이룬다는 의미
    각 노드별로 탐색한다 했을 때의 경우의 수 100* 100 = 10000
    각 노드별로 탐색 후 시작과 끝이 같은 수들을 visit 처리

*/
public class Dfs3{
    public static int n;
    public static List<List<Integer>> graph = new ArrayList<>();
    public static boolean[] visit;
    public static boolean[] result;
    public static int compare;
    public static boolean isFind;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());
        result = new boolean[n];
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < n; i++){
            int parent =Integer.parseInt(bf.readLine());
            parent--;
            graph.get(parent).add(i);
        }
        for(int i = 0; i < n; i++){
            isFind = false;
            visit = new boolean[n];
            compare = i;
            dfs(i);
        }

        int sum = 0;
        for(boolean b : result){
            if(b) sum++;
        }
        //System.out.println();
        System.out.println(sum);
        for(int i = 0; i < n; i++){
            if(result[i]){
                System.out.println(i+1);
            }
        }

        bw.flush();
        bw.close();
    }

    public static void dfs(int node){
        if(isFind) return;
        if(graph.get(node).size() == 0) return;
        if(visit[node]) return;

        //시작노드를 재방문하지 않기 위해 방문처리
        visit[node] = true;
        //연결된 모든 노드를 방문
        for(int i = 0; i < graph.get(node).size(); i++){
            int nextNode = graph.get(node).get(i);
            if(compare == nextNode){
                setting();
                isFind = true;
                return;
            }

            dfs(nextNode);
        }
        //원하는 경로의 도달했을 경우 
        //원하는 경로외의 방문처리를 없애기 위해 
        visit[node] = false; 
    }
    public static void setting(){
        for(int i = 0; i < n; i++){
            if(visit[i]){
                result[i] = true;
            }
        }
    }
}