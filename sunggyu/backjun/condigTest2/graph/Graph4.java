package sunggyu.backjun.condigTest2.graph;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/16940
//BFS 스페셜 저지
/*
    그래프가 트리 구조이기 때문에 부모 노드의 값을 빼주어야 한다.

    노드의 갯수 10만개
    간선의 갯수 10만개 - 1

    이진 탐색 구현 시 주의해야 할 것
    이진탐색은 재귀를 이용하여 구현된다. 고로 재귀함수 호출 시 return을 기입해야 한다.
    0/2는 가능하다.
    startIndex와 endIndex는 사이즈가 아닌 인덱스다.
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
            Collections.sort(graph.get(i+1));
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
        if(list[0] != 1) return false;
        queue.add(list[0]);
        int index = 1;
        while(!queue.isEmpty()){
            int value = queue.poll();
            List<Integer> childs = graph.get(value);
            int size = childs.size();
            if(size == 0) continue;

            if(value != 1) size -= 1;
            for(int i = 0; i < size; i++){
                if(!binarySearch(0, childs.size()-1, list[index], childs)) return false;
                queue.add(list[index]);
                index++;
                if(index == list.length) return true;
            }
        }

        return true;
    }

    public static boolean binarySearch(int startIndex, int endIndex, int value, List<Integer> list){
        if(startIndex > endIndex) return false;
        int mid = (startIndex + endIndex) / 2;
        if(list.get(mid).equals(value)) return true;
        if(list.get(mid) > value){
            return binarySearch(startIndex, mid-1, value, list);
        }else{
            return binarySearch(mid+1, endIndex, value, list);
        }
    }
}
