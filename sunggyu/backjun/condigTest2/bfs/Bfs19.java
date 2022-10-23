package sunggyu.backjun.condigTest2.bfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/4991
//로봇 청소기
/*
    더러운 칸을 모두 깨끗한 칸으로 만드는데 필요한 이동 횟수의 최솟값을 구하라.


    1. bfs를 이용하여 더러운 칸 간의 모든 distance를 구한다.
    -> bfs는 두 노드 간의 최단거리를 알 수 있다.
    2. 모든 경로의 대한 경우의 수를 구한다.

*/
public class Bfs19{
    static BufferedReader bf;
    static BufferedWriter bw;
    static int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    static int N;
    static int M;
    static char[][] map;
    static int[][] connectedInfo;
    static List<Node> nodes;
    static int MIN = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[]mn = bf.readLine().split(" ");
        N = Integer.parseInt(mn[1]);
        M = Integer.parseInt(mn[0]);
        while(N != 0 && M != 0){
            map = new char[N][M];
            nodes = new ArrayList<>();
            Node robot = null;
            MIN = Integer.MAX_VALUE;

            for(int i = 0; i < N; i++){
                map[i] = bf.readLine().toCharArray();
                for(int j = 0; j < M; j++){
                    if(map[i][j] == 'o'){
                        robot = new Node(i, j, 0);
                    }

                    if(map[i][j] == '*'){
                        nodes.add(new Node(i, j, 0));
                    }
                }
            }
            nodes.add(0, robot);
            connectedInfo = new int[nodes.size()][nodes.size()];
            for(int i = 0; i < nodes.size(); i++){
                connect(i);
            }

            boolean[] visited = new boolean[nodes.size()];
            visited[0] = true;
            dfs(1, visited, 0, nodes.size(), 0);

            if(Integer.MAX_VALUE == MIN) MIN = -1;

            bw.write(String.valueOf(MIN));
            bw.newLine();

            mn = bf.readLine().split(" ");
            N = Integer.parseInt(mn[1]);
            M = Integer.parseInt(mn[0]);
        }
        bw.flush();
        bw.close();
    }

    public static void connect(int index){
        Queue<Node> queue = new LinkedList<>();
        queue.add(nodes.get(index));
        boolean[][] visited = new boolean[N][M];

        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(!canVisit(now)) continue;
            if(visited[now.x][now.y]) continue;

            visited[now.x][now.y] = true;

            if(map[now.x][now.y] == '*') connectedInfo[index][getNodeIndex(now)] = now.distance;

            for(int[] direction : directions){
                int nx = direction[0] + now.x;
                int ny = direction[1] + now.y;
                queue.add(new Node(nx, ny, now.distance+1));
            }
        }
    }

    public static int getNodeIndex(Node node){
        for(int i = 0; i < nodes.size(); i++){
            if(node.x == nodes.get(i).x && node.y == nodes.get(i).y){
                return i;
            }
        }
        return 0;
    }

    public static void dfs(int selectedCount, boolean[] visited, int distance, int depth, int selectedIndex){
        if(selectedCount == depth){
            MIN = Math.min(MIN, distance);
        }

        for(int i = 0; i < nodes.size(); i++){
            if(!visited[i] && connectedInfo[selectedIndex][i] != 0){
                visited[i] = true;
                dfs(selectedCount + 1, visited, distance + connectedInfo[selectedIndex][i], depth, i);
                visited[i] = false;
            }
        }
    }

    public static boolean canVisit(Node node){
        if(node.x < 0 || node.x >= N || node.y < 0 || node.y >= M) return false;
        if(map[node.x][node.y] == 'x') return false;
        return true;
    }

    static class Node{
        int x, y , distance;
        public Node(int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
