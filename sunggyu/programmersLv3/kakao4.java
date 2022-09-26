package sunggyu.programmersLv3;

//https://school.programmers.co.kr/learn/courses/30/lessons/67259
//경주로 건설
import java.util.*;
class kakao4 {
    int[][][] minValues;
    int N;
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    int[][] board;
    int answer = Integer.MAX_VALUE;
    public int solution(int[][] board) {
        this.board = board;
        N = board.length;
        minValues = new int[4][N][N];
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < N; j++){
                Arrays.fill(minValues[i][j], Integer.MAX_VALUE);
            }
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0,0, 0));
        queue.add(new Node(0,0,0, 2));
        
        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(!canVisit(now)) continue;
            minValues[now.direction][now.x][now.y] = now.value;
            if(now.x == N-1 && now.y == N-1){
                answer = Math.min(answer, now.value);
                continue;
            }
            
            for(int i = 0; i < 4; i++){
                int nx = now.x + directions[i][0];
                int ny = now.y + directions[i][1];
                queue.add(new Node(nx, ny, now.value, i, now.direction));
            }
            
        }
        return answer;
    }
    
    public boolean canVisit(Node now){
        if(now.x < 0 || now.x >= N || now.y < 0 || now.y >= N) return false;
        if(board[now.x][now.y] == 1) return false;
        if(minValues[now.direction][now.x][now.y] <= now.value) return false;
        return true;
    }

    static class Node{
        int x;
        int y;
        int value;
        int direction;
        public Node(int x, int y, int value, int direction){
            this.x = x;
            this.y = y;
            this.value = value;
            this.direction = direction;
        }
        
        public Node(int x, int y, int value, int nowDireciton, int beforeDirecion){
            this.x = x;
            this.y = y;
            this.value = value;
            this.direction = nowDireciton;
            calcValue(beforeDirecion);
        }
        
        public void calcValue(int beforeDirecion){
            if(beforeDirecion < 2 && direction < 2){
                value += 100;
                return;
            }
            if(beforeDirecion > 1 && direction > 1){
                value += 100;
                return;
            }
            
            value += 600;
            return;
        }
    }
}