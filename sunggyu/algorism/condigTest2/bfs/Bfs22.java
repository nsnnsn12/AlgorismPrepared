package sunggyu.algorism.condigTest2.bfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/17141
//연구소 2
/*
    모든 빈칸에 바이러스를 퍼뜨리는 최소 시간을 구하라.

    모든 좌표를 기준으로 bfs를 돌았을 때의 시간
    62500
    최대 시간
    252(바이러스를 선택할 수 있는 조합 수) * 250(bfs로 방문가능한 최대 수) * 250(bfs가 모든 지역을 방문했는지 확인)
*/
public class Bfs22{
    static BufferedReader bf;
    static BufferedWriter bw;
    static int N;
    static int M;
    static List<Node> enablePoint = new ArrayList<>();
    static int[][] map;
    static int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = bf.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);
        map = new int[N][N];
        for(int i = 0; i < N; i++){
            String[] split = bf.readLine().split(" ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(split[j]);
                if(map[i][j] == 2){
                    enablePoint.add(new Node(i, j, 0));
                }
            }
        }

        dfs(0, new int[M], 0);
        if(result == Integer.MAX_VALUE) result = -1;
        System.out.println(result);
        bw.flush();
        bw.close();
    }

    static void dfs(int depth, int[] selected, int startIndex){
        if(depth == M){
            int count = bfs(selected);
            result = Math.min(count, result);
            return;
        }
        for(int i = startIndex; i < enablePoint.size(); i++){
            selected[depth] = i;
            dfs(depth + 1, selected, i + 1);
        }
    }

    static int bfs(int[] selected){
        int maxCount = 0;
        boolean[][] visited = new boolean[N][N];
        Queue<Node> queue = new LinkedList<>();
        for(int i = 0; i <selected.length; i++){
            Node node = enablePoint.get(selected[i]);
            queue.add(node);
        }

        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(!canVisit(now, visited)) continue;
            visited[now.x][now.y] = true;
            maxCount = Math.max(now.count, maxCount);

            for(int[] direction : directions){
                int nx = direction[0] + now.x;
                int ny = direction[1] + now.y;
                queue.add(new Node(nx, ny, now.count + 1));
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] != 1 && !visited[i][j]) return Integer.MAX_VALUE;
            }
        }

        return maxCount;
    }

    static boolean canVisit(Node node, boolean[][] visited){
        if(node.x < 0 || node.x >= N || node.y < 0 || node.y >= N) return false;
        if(map[node.x][node.y] == 1) return false;
        if(visited[node.x][node.y]) return false;
        return true;
    }

    static class Node{
        int x, y;
        int count;

        Node(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
