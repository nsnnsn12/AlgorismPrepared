package sunggyu.programmersLv2;

import java.util.*;
//https://school.programmers.co.kr/learn/courses/30/lessons/1829
//카카오프렌즈 컬러링북
class kakao19 {
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    boolean[][] visited;
    int[][] picture;
    int numberOfArea;
    int maxSizeOfOneArea;
    int N;
    int M;
    public int[] solution(int m, int n, int[][] picture) {
        M = m;
        N = n;
        this.picture = picture;
        visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && picture[i][j] != 0){
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, search(i, j, 0, picture[i][j]));
                }
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public int search(int x, int y, int sizeOfOneArea, int target){
        if(!canVisit(x,y) || visited[x][y] || picture[x][y] != target) return sizeOfOneArea;
        visited[x][y] = true;
        sizeOfOneArea++;
        
        int sum = 0;
        for(int[] direct : directions){
            int nx = direct[0] + x;
            int ny = direct[1] + y;
            sum += search(nx, ny, sizeOfOneArea, target) - sizeOfOneArea;
        }
        
        return sizeOfOneArea + sum;
    }
    
    public boolean canVisit(int x, int y){
        if(x < 0 || x >= M || y < 0 || y >= N) return false;
        return true;
    }
}