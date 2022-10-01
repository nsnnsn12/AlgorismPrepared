package sunggyu.programmersLv3;

//https://school.programmers.co.kr/learn/courses/30/lessons/60059
//자물쇠와 열쇠
import java.util.*;
class kakao6 {
    /*
        모든 경우의 수
        20 * 20 = 400
        400 * 400 = 160000
        160000 * 4 = 640000
    */
    public int[][] map;
    public int N;
    public int[][] key;
    public boolean solution(int[][] key, int[][] lock) {
        this.key = key;
        boolean answer = true;
        N = lock.length;
        map = new int[N*3][N*3];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                map[i+N][j+N] = lock[i][j];
            }
        }
        for(int i = 0; i < 4; i++){
            if(match()) return true;
            rotation();
        }
        return false;
    }
    
    public boolean match(){
        for(int i = 0; i < N * 2; i++){
            for(int j = 0; j < N * 2; j++){
                if(simulation(i, j)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean simulation(int x, int y){
        int[][] copyMap = copy();
        for(int i = 0; i < key.length; i++){
            for(int j = 0; j < key.length; j++){
                if(key[i][j] == 1 && copyMap[i+x][j+y] == 1) return false;
                if(key[i][j] == 1){
                    copyMap[i+x][j+y] = 1;
                }
            }
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(copyMap[i+N][j+N] == 0){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public int[][] copy(){
        int[][] copyMap = new int[map.length][map.length];
        for(int i = 0; i < map.length; i++){
            copyMap[i] = Arrays.copyOf(map[i], map.length);
        }
        
        return copyMap;
    }
    
    
    public void rotation(){
        int[][] newMap = new int[map.length][map.length];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                newMap[i+N][j+N] = map[(N-j-1)+N][i+N];
            }
        }
        
        map = newMap;
    }
}