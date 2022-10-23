package sunggyu.backjun.condigTest2.bfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/9376
//탈옥
/*
    2개의 좌표가 존재한다.
    2개의 좌표가 최소한의 문을 열고 밖으로 갈 수 있는 문의 갯수는?
    최소한은 어떤 조건을 만족하는가?
*/
public class Bfs16{
    static BufferedReader bf;
    static BufferedWriter bw;
    static int T;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(bf.readLine());
        for(int i = 0; i < T; i++){
            String[] nm = bf.readLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            int[][] map = new int[n][m];
            Node[] prisoners = new Node[2];
            for(int x = 0; x < n; x++){
                char[] list = bf.readLine().toCharArray();
                for(int y = 0; y < m; y++){
                    if(list[y] == '*'){
                        map[x][y] = 2;
                    }

                    if(list[y] == '#'){
                        map[x][y] = 1;
                    }

                    if(list[y] == '$'){
                        map[x][y] = 1;
                        if(prisoners[0] == null){
                            prisoners[0] = new Node(x,y,0);
                        }else{
                            prisoners[1] = new Node(x,y,0);
                        }
                    }
                }
            }

            Test test = new Test(map, prisoners);
            test.minDistance();
        }
        bw.flush();
        bw.close();
    }

    static class Test{
        int[][] map;
        int[][] minPassedDoorCount;
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        Node[] prisoners;
        int N;
        int M;

        public Test(int[][] map, Node[] prisoners){
            this.map = map;
            this.prisoners = prisoners;
            this.N = map.length;
            this.M = map[0].length;

            minPassedDoorCount = new int[map.length][map[0].length];

            for(int i = 0; i < N; i++){
                Arrays.fill(minPassedDoorCount[i], Integer.MAX_VALUE);
            }
        }

        public int minDistance(){
            int result = 0;
            Queue<Node> queue = new LinkedList<>();
            queue.add(prisoners[0]);
            while(!queue.isEmpty()){
                Node node = queue.poll();
                if(!canVisit(node)) continue;
                if(map[node.x][node.y] == 1) node.passedCount++;
                if(minPassedDoorCount[node.x][node.y] <= node.passedCount) continue;

                minPassedDoorCount[node.x][node.y] = node.passedCount;

                for(int[] direction : directions){
                    int nx = direction[0] + node.x;
                    int ny = direction[1] + node.y;
                    queue.add(new Node(nx, ny, node.passedCount));
                }
            }
            return result;
        }

        private boolean canVisit(Node node){
            if(node.x < 0 || node.x >= N || node.y < 0 || node.y >= M) return false;
            if(map[node.x][node.y] == 2) return false;
            return true;
        }
    }

    static class Node{
        int x;
        int y;
        int passedCount;

        public Node(int x, int y, int passedCount){
            this.x = x;
            this.y = y;
            this.passedCount = passedCount;
        }
    }
}
