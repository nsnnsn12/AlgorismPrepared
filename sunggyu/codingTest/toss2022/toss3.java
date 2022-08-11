import java.util.*;
class toss3 {
    /*
        요구체력과 사용체력이 존재
        요구체력 : 현재 남아있는 체력의 최소치
        사용체력 : 소모되는 체력치

        요구체력 >= 사용체력

        던전은 하루에 한 번 탐험가능

        한 유저가 하루동안 최대한 탐험할 수 있는 경우의 수를 리턴하라

        던전의 최대갯수는 8
        8! = 40320
        고로 완전탐색 가능
    */
    int N;
    boolean[] visited;
    int[][] dungeons;
    int max;
    public int solution(int k, int[][] dungeons) {
        this.dungeons = dungeons;
        int stamina = k;
        int answer = -1;
        N = dungeons.length;
        visited = new boolean[N];
        for(int i = 0; i < N; i++){
            visited[i] = true;
            int count = dfs(stamina, i, 0);
            //System.out.println(count);
            answer = Math.max(answer, count);
            visited[i] = false;
        }
        return answer;
    }

    public int dfs(int stamina, int index, int depth){
        int[] dungeon = dungeons[index];
        int required = dungeon[0];
        int cost = dungeon[1];
        if(stamina < required) return depth;
        if(depth == N-1) return N;
        stamina -= cost;
        int max = 0;
        for(int i = 0; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                int value = dfs(stamina, i, depth + 1);
                max = Math.max(max, value);
                visited[i] = false;
            }
        }

        return max;
    }
}