package sunggyu.algorism.condigTest2.graph;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/16964
//DFS 스페셜 저지
/*
*/
public class Graph5{
    static BufferedReader bf;
    static BufferedWriter bw;
    static int N;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] visitedLog;
    static int result = 0;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(bf.readLine());
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < N-1; i++){
            String[] split = bf.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        String[] split = bf.readLine().split(" ");
        visitedLog = new int[split.length];
        for(int i = 0; i < split.length; i++){
            visitedLog[i] = Integer.parseInt(split[i]);
        }
        dfs(1, 0, 0);

        System.out.println(result);
        bw.flush();
        bw.close();
    }

    public static void dfs(int value, int index, int beforeValue){
        System.out.println(String.format("value : %d, index : %d, before : %d", value, index, beforeValue));
        if(index == visitedLog.length) return;
        if(visitedLog[index] != value) return;
        if(index == visitedLog.length-1 && visitedLog[index] == value){
            result = 1;
            return;
        }
        index++;
        List<Integer> childs = graph.get(value);
        for(int i = 0; i < childs.size(); i++){
            if(!childs.get(i).equals(beforeValue)){
                dfs(childs.get(i), index, value);
            }
        }
    }
}
