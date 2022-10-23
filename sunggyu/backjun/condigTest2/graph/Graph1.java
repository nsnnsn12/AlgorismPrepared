package sunggyu.backjun.condigTest2.graph;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/16929
//Two Dots
/*
    map의 최대 크기 50 * 50
    bfs를 이용하여 인접한 점이 4개 이상인 경우
    사이클이 존재하는지 찾음
    사이클이란 곧 모든 연결된 노드들이 2개 이상의 인접한 노드를 지니고 있어야 함.

    무한루프를 돌면서 인접한 노드가 2개 이상이 아닌 노드들을 다 제외시킴
    bfs를 이용하여 4개 이상 인접 노드가 존재하는지 찾음
    250 * 4 = 인접한 노드를 방문
    1000 * 1000 = 1000000
*/
public class Graph1{
    static BufferedReader bf;
    static BufferedWriter bw;    
    static int N;
    static int M;
    static char[][] map;
    static boolean[][] visited;
    static boolean[][] notExisted;
    static int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String result = "No";
        String[] split = bf.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        map = new char[N][M];
        visited = new boolean[N][M];
        notExisted = new boolean[N][M];
        for(int i = 0; i < N; i++){
            map[i] = bf.readLine().toCharArray();
        }

        setExist();

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j] && !notExisted[i][j]){
                    if(bfs(i, j)){
                        result = "Yes";
                        break;
                    }
                }
            }
        }
        System.out.println(result);
        bw.flush();
        bw.close();
    }

    public static void setExist(){
        int count = 0;
        while(true){
            count = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(!notExisted[i][j]){
                        if(!isExist(i, j)){
                            notExisted[i][j] = true;
                            count++;
                        }
                    }
                }
            }


            if(count == 0) break;
        }
    }

    public static boolean isExist(int x, int y){
        int count = 0;
        for(int[] direction : directions){
            int nx = direction[0] + x;
            int ny = direction[1] + y;
            if(canVisit(nx, ny, map[x][y])) count++;
        }

        if(count > 1) return  true;
        return false;
    }

    public static boolean canVisit(int x, int y, char value){
        if(x < 0 || x >= N || y < 0 || y >= M) return false;
        if(notExisted[x][y]) return false;
        if(map[x][y] != value) return false;
        return true;
    }

    public static boolean bfs(int x, int y){
        char value = map[x][y];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        int count = 0;
        while(!queue.isEmpty()){
            Node nowNode = queue.poll();
            if(!canVisit(nowNode)) continue;
            if(map[nowNode.x][nowNode.y] != value) continue;
            visited[nowNode.x][nowNode.y] = true;
            count++;
            if(count >= 4) return true;
            for(int[] direction : directions){
                int nx = direction[0] + nowNode.x;
                int ny = direction[1] + nowNode.y;
                queue.add(new Node(nx, ny));
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
        if(notExisted[x][y]) return false;

        return true;
    }

    public static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
