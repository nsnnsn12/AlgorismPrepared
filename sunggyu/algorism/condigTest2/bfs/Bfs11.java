package sunggyu.algorism.condigTest2.bfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/6087
//레이저 통신
/*
    최소갯수의 거울을 설치하여 두개의 포인트를 연결시켜라
    거울은 레이저를 90도 회전시킬 수 있다.

    거울을 최소로 사용한다는 것은 방향을 최대한 적게 튼다는 것을 의미한다.
    방향을 틀었던 횟수를 저장하고 횟수가 적은 경우 다시 방문한다.
    이전 방향의 대한 정보를 가지고 있어야 한다.
    
    주의할 점
    방향을 틀었던 횟수가 동일하더라도 현재 어떤 방향이냐에 따란 추후 방향을 트는 것이 결정된다.
*/
public class Bfs11{
    static BufferedReader bf;
    static BufferedWriter bw;
    static int[][] map;
    static int[][][] rotatinoCounts;
    static int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    static int N;
    static int M;
    static Position startPosition;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nm = bf.readLine().split(" ");
        M = Integer.parseInt(nm[0]);
        N = Integer.parseInt(nm[1]);
        map = new int[N][M];
        rotatinoCounts = new int[4][N][M];
        for(int i = 0; i < N; i++){
            char[] list = bf.readLine().toCharArray();
            for(int j = 0; j < M; j++){
                if(list[j] == '*'){
                    map[i][j] = 1;
                }

                if(list[j] == 'C'){
                    map[i][j] = 2;
                    startPosition = new Position(i, j, 0, 0);
                }
            }
        }
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < N; j++){
                Arrays.fill(rotatinoCounts[i][j], Integer.MAX_VALUE);
            }
        }

        bfs();

        System.out.println(result);
        bw.flush();
        bw.close();
    }
    
    public static void bfs(){
        Queue<Position> queue = new LinkedList<>();
        for(int i = 0; i < 4; i++){
            rotatinoCounts[i][startPosition.x][startPosition.y] = 0;
        }

        for(int i = 0; i < 4; i++){
            int nx = startPosition.x + directions[i][0];
            int ny = startPosition.y + directions[i][1];
            queue.add(new Position(nx, ny, i, 0));
        }

        while(!queue.isEmpty()){
            Position now = queue.poll();
            if(!canVisit(now))  continue;
            rotatinoCounts[now.direct][now.x][now.y] = now.rotatinoCount;
            if(map[now.x][now.y] == 2) result = Math.min(result, now.rotatinoCount);

            for(int i = 0; i < 4; i++){
                int nx = now.x + directions[i][0];
                int ny = now.y + directions[i][1];
                if(i == now.direct){
                    queue.add(new Position(nx, ny, i, now.rotatinoCount));
                }else{
                    queue.add(new Position(nx, ny, i, now.rotatinoCount + 1));
                }
            }
        }
    }

    static boolean canVisit(Position position){
        if(position.x < 0 || position.x >= N || position.y < 0 || position.y >= M) return false;
        if(map[position.x][position.y] == 1) return false;
        if(rotatinoCounts[position.direct][position.x][position.y] <= position.rotatinoCount) return false;
        return true;
    }

    static class Position{
        int x;
        int y;
        int direct;
        int rotatinoCount;
        public Position(int x, int y, int direct, int rotatinoCount){
            this.x = x;
            this.y = y;
            this.direct = direct;
            this.rotatinoCount = rotatinoCount;
        }
    }
}
