package sunggyu.algorism.condigTest1.graph;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/13023
//ABCDE
/*
*/
public class Graph1{
    static int N;
    static int M;
    static boolean isFind;
    static List<List<Integer>> friends = new ArrayList<>();
    static boolean[] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = bf.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);
        visit = new boolean[N];
        for(int i = 0; i < N; i++){
            friends.add(new ArrayList<>());
        }
        for(int i = 0; i < M; i++){
            String[] split = bf.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            friends.get(a).add(b);
            friends.get(b).add(a);
        }
        for(int i = 0; i < N; i++){
            dfs(1, i);
        }
        System.out.println(isFind?1:0);
        bw.flush();
        bw.close();
    }

    public static void dfs(int depth, int node){
        if(isFind) return;
        if(depth == 5){
            isFind =true;
            return;
        }
        visit[node] = true;
        for(int i = 0; i < friends.get(node).size(); i++){
            int nextNode = friends.get(node).get(i);
            if(!visit[nextNode]){
                //System.out.println(nextNode);
                dfs(depth+1, nextNode);
            }
        }
        visit[node] = false;

    }

    
}
