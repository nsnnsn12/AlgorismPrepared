package sunggyu.backjun.condigTest1.bfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/14226
//이모티콘
/*
    각 n개의 클립보드마다 bfs를 이용하여 완전탐색을 한다.
    완전 탐색을 하면서 최단 시간을 갱신한다.
*/
public class Bfs3_review{
    static int S;
    static int[] list;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        S = Integer.parseInt(bf.readLine())+1;
        list = new int[S];
        Arrays.fill(list, -1);
        list[1] = 0;
        for(int i = 1; i < S; i++){
            visited = new boolean[S];
            bfs(i);
        }

        System.out.println(list[S-1]);
        bw.flush();
        bw.close();
    }

    public static void bfs(int clipBoard){
        Deque<int[]> deque = new ArrayDeque<>();

        visit(clipBoard+clipBoard, clipBoard, deque, list[clipBoard]+2);
        visit(clipBoard-1, clipBoard, deque, list[clipBoard]+2);
        while(!deque.isEmpty()){
            int[] info = deque.poll();
            int index = info[0];
            int second = info[1];
            visit(index + clipBoard, index, deque, second+1);
            visit(index - 1, index, deque, second+1);
        }
    }

    public static void visit(int nextIndex, int index, Deque<int[]> deque, int second){
        if(canVisit(nextIndex)){
            int[] info = {nextIndex, second};
            deque.add(info);
            visited[nextIndex] = true;
            if(list[nextIndex] > second || list[nextIndex] == -1){
                list[nextIndex] = second;
            }
        }
    }

    public static boolean canVisit(int index){
        if(index <= 0 || index >= S) return false;
        if(visited[index]) return false;
        return true;
    }

}
