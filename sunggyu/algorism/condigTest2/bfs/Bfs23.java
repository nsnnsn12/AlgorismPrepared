package sunggyu.algorism.condigTest2.bfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/17142
//연구소 3
/*
    비활성 바이러스를 활성시킬 것인가 말것인가
    비활성 바이러스가 4방향으로 모두 움직이지 않는다면 해당 지점으로 움직일 필요가 없다.
    

    62500
    최대 시간
    252(바이러스를 선택할 수 있는 조합 수) * 250(bfs로 방문가능한 최대 수) * 250(bfs가 모든 지역을 방문했는지 확인)

    모든 바이러스를 선택할 수 있는 경우를 구한다.
    각 경우의 수에 맞게 시뮬레이션한다.

    bfs는 노드간 최단거리를 만족시킨다.
    최단거리를 어떻게 만족하는가?
*/
public class Bfs23{
    static BufferedReader bf;
    static BufferedWriter bw;
    static int N;
    static int M;
    static int[][] map;
    static List<Node> virus = new ArrayList<>();
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
                    virus.add(new Node(i, j, 0));
                }
            }
        }
        int[] selected = new int[M];
        dfs(0, selected, 0);
        
        result = result == Integer.MAX_VALUE ? -1 : result;
        System.out.println(result);
        bw.flush();
        bw.close();
    }

    public static void dfs(int depth, int[] selected, int startIndex){
        if(depth == M){
            result = Math.min(bfs(selected), result);
            return;
        }

        for(int i = startIndex; i < virus.size(); i++){
            selected[depth] = i;
            dfs(depth + 1, selected, i+1);
        }
    }

    public static int bfs(int[] selected){
        int result = 0;
        Queue<Node> queue = new LinkedList<>();
        for(int i = 0; i < selected.length; i++){
            queue.add(virus.get(selected[i]));
        }
        boolean[][] visited = new boolean[N][N];
        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(!canVisit(now, visited)) continue;

            visited[now.x][now.y] = true;
            if(map[now.x][now.y] != 2) result = Math.max(result, now.count);

            for(int[] direction : directions){
                int nx = now.x + direction[0];
                int ny = now.y + direction[1];
                queue.add(new Node(nx, ny, now.count+1));
            }

        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] != 1 && !visited[i][j]) return Integer.MAX_VALUE;
            }
        }

        return result;
    }



    public static boolean canVisit(Node node, boolean[][] visited){
        if(node.x < 0 || node.x >= N || node.y < 0 || node.y >= N) return false;
        if(map[node.x][node.y] == 1) return false;
        if(visited[node.x][node.y]) return false;
        return true;
    }

    static class Node{
        int x, y;
        int count;
        public Node(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
