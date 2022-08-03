package sunggyu.algorism.condigTest2.graph;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/16940
//BFS 스페셜 저지
/*
*/
public class Graph4{
    static BufferedReader bf;
    static BufferedWriter bw;
    static int[] list;
    static int N;
    static List<List<Integer>> graph = new ArrayList<>();
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
        list = new int[N];
        for(int i =0; i < N; i++){
            list[i] = Integer.parseInt(split[i]);
        }
        int result = 0;
        if(bfs()) result = 1;
        System.out.println(result);
        bw.flush();
        bw.close();
    }

    public static boolean bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(list[0]);
        int index = 1;
        while(!queue.isEmpty()){
            int value = queue.poll();
            List<Integer> childs = graph.get(value);
            
            if(childs.size() == 0) continue;
            for(int i = 0; i < childs.size(); i++){
                if(!childs.contains(list[index])){
                    return false;
                }
                queue.add(list[index]);
                index++;
                if(index == list.length) return true;
            }
        }

        return true;
    }
}
