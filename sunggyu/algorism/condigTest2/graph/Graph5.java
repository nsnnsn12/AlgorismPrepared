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
    static int index = 0;
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
        if(dfs(1)){
            result = 1;
        }
        if(visitedLog[0] != 1){
            result = 0;
        }

        System.out.println(result);
        bw.flush();
        bw.close();
    }

    public static boolean dfs(int value){
        //System.out.println(value+" "+index);
        List<Integer> childs = graph.get(value);
        int size = childs.size() - 1;
        if(value == 1) size++;
        index++;
        for(int i = 0; i < size; i++){
            int nextValue = binarySearch(visitedLog[index], childs, 0, childs.size()-1);
            if(nextValue == -1) return false;
            if(!dfs(nextValue)) return false;
        }
        return true;
    }

    public static int binarySearch(int value, List<Integer> list, int startIndex, int endIndex){
        if(startIndex > endIndex) return -1;
        int mid = (startIndex + endIndex) / 2;
        if(list.get(mid) == value) return value;
        if(list.get(mid) > value){
            return binarySearch(value, list, startIndex, mid-1);
        }else{
            return binarySearch(value, list, mid+1, endIndex);
        }
    }
}
