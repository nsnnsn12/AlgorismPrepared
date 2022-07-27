package sunggyu.algorism.condigTest2.graph;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/16929
//Two Dots
/*
    map의 최대 크기 50 * 50
    bfs를 이용하여 인접한 점이 4개 이상인 경우
    사이클이 존재하는지 찾음
    사이클이란 곧 모든 연결된 노드들이 2개 이상의 인접한 노드를 지니고 있어야 함.
*/
public class Graph1{
    static BufferedReader bf;
    static BufferedWriter bw;    
    static int N;
    static int M;
    static char[][] map;
    static boolean[][] visited;
    static int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] split = bf.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        map = new char[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++){
            map[i] = bf.readLine().toCharArray();
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j]){

                }
            }
        }

        bw.flush();
        bw.close();
    }

    public static boolean bfs(int x, int y){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y, map[x][y]));
        int count = 0;
        while(!queue.isEmpty()){
            Node nowNode = queue.poll();
            if(canVisit(nowNode)) continue;
            visited[nowNode.x][nowNode.y] = true;
            count++;

            for(int[] direct : directions){

            }
        }

        if(count >= 4) return true;

        return false;
    }

    public static boolean canVisit(Node node){
        int x = node.x;
        int y = node.y;
        if(x < 0 || x >= N || y < 0 || y >= M) return false;
        if(visited[x][y]) return false;

        return true;
    }

    public static class Node{
        int x;
        int y;
        char value;
        public Node(int x, int y, char value){
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
}
