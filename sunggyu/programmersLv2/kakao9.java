package sunggyu.programmersLv2;

import java.util.*;
//https://programmers.co.kr/learn/courses/30/lessons/17679
//[1차] 프렌즈4블록
class kakao9 {
    /*
        최대 map의 크기는 900개
        
        1. 이번 라운드에 터질 갯수를 카운트한다.
        2. 터트린다.
        3. 빈자리를 채운다.
    */
    String[][] map;
    boolean[][] visited;
    int answer;
    int n;
    int m;
    public int solution(int m, int n, String[] board) {
        this.n = n;
        this.m = m;
        map = new String[m][n];
        visited = new boolean[m][n];
        for(int i  = 0; i < m; i++){
            char[] list = board[i].toCharArray();
            for(int j = 0; j < n; j++){
                map[i][j] = list[j]+"";
            }
        }
        while(true){
            if(!canPop()) break;
            pop();
            rebase();
        }
        return answer;
    }
    
    public void rebase(){
        for(int i = 0; i < n; i++){
            String str = "";
            for(int j = m-1; j >= 0; j--){
                if(!map[j][i].equals("")){
                    str += map[j][i];
                    map[j][i] = "";
                }
            }
            
            for(int j = 0; j < str.length(); j++){
                map[m-j-1][i] = str.charAt(j)+"";
            }
        }
    }
    
    public void pop(){
        for(int i  = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j]){
                    answer++;
                    visited[i][j] = false;
                    map[i][j] = "";
                }
            }
        }
    }
    
    public boolean canPop(){
        boolean result = false;
        for(int i  = 0; i < m-1; i++){
            for(int j = 0; j < n-1; j++){
                if(isMatched(i, j)){
                    result = true;
                    visit(i, j);
                }
            }
        }
        return result;
    }
    
    public boolean isMatched(int x, int y){
        String str = map[x][y];
        if(str.equals("")) return false;
        if(!map[x+1][y].equals(str)) return false;
        if(!map[x][y+1].equals(str)) return false;
        if(!map[x+1][y+1].equals(str)) return false;
        return true;
    }
    
    public void visit(int x, int y){
        visited[x][y] = true;
        visited[x+1][y] = true;
        visited[x][y+1] = true;
        visited[x+1][y+1] = true;
    }
}