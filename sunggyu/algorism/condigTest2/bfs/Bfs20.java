package sunggyu.algorism.condigTest2.bfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/2234
//성곽
/*
    1 : 서
    2 : 북
    4 : 동
    8 : 남
    남동북서
*/
public class Bfs20{
    static BufferedReader bf;
    static BufferedWriter bw;
    static int N;
    static int M;
    static int[][] map;
    static int[][] visited;
    static int[][] directions = {{0,-1},{-1,0},{0,1},{1,0}};
    static int maxArea = 0;
    static int area = 0;
    static List<Integer> areas = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = bf.readLine().split(" ");
        N = Integer.parseInt(nm[1]);
        M = Integer.parseInt(nm[0]);
        map = new int[N][M];
        visited = new int[N][M];
        for(int i = 0; i < N; i++){
            String[] split = bf.readLine().split(" ");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(split[j]);
            }
        }
        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(visited[i][j] == 0){
                    count++;
                    areas.add(bfs(new Node(i, j), count));
                    maxArea = Math.max(maxArea, areas.get(count-1));
                }
            }
        }
        area = maxArea;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                int roomIndex = visited[i][j];
                int value = map[i][j];
                for(int k = 0; k < 4; k++){
                    if(((value & (1 << k)) == (1 << k))){
                        int nx = directions[k][0] + i;
                        int ny = directions[k][1] + j;
                        if(canVisit(nx, ny) && visited[nx][ny] != roomIndex){
                            area = Math.max(area, areas.get(roomIndex-1) + areas.get(visited[nx][ny]-1));
                        }
                    }
                }
            }
        }
        System.out.println(count);
        System.out.println(maxArea);
        System.out.println(area);
        bw.flush();
        bw.close();
    }
    static int bfs(Node node, int index){
        int result = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(!canVisit(now)) continue;
            
            visited[now.x][now.y] = index;
            result++;
            for(int i = 0; i < 4; i++){
                int value = map[now.x][now.y];
                if((value & (1 << i)) != (1 << i)){
                    int nx = directions[i][0] + now.x;
                    int ny = directions[i][1] + now.y;
                    queue.add(new Node(nx, ny));
                }
            }
        }

        return result;
    }

    static boolean canVisit(Node node){
        if(node.x < 0 || node.x >= N || node.y < 0 || node.y >= M) return false;
        if(visited[node.x][node.y] != 0) return false;
        return true;
    }

    static boolean canVisit(int x, int y){
        if(x < 0 || x >= N || y < 0 || y >= M) return false;
        return true;
    }
    static class Node{
        int x,y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
