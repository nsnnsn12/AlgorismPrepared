package sunggyu.codingTest.ssg2022;
import java.util.*;
class Ssg4 {
    /*
    */
    int[][] direction = {{1,0},{0,1},{-1,0},{0,-1}};
    int[][] map = new int[6][6];
    public String[] solution(int[][] macaron) {
        String[] answer = {};
        for(int i = 0; i < macaron.length; i++){
            drop(macaron[i]);
        }
        return answer;
    }

    public void drop(int[] macaron){
        int x = macaron[0];
        int y = searchPosition(x);
        int color = macaron[1];
        map[x][y] = color;
        while(canPop()){
            sort();
        }
    }

    public void sort(){
        
    }

    public int searchPosition(int position){
        for(int i = 0; i < 6; i++){
            if(map[position][i] == 0){
                return i;
            }
        }
        return 0;
    }

    public boolean canPop(){
        int count = 0;
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 6; j++){
                if(map[i][j] != 0){
                    count += pop(i, j, map[i][j]);
                }
            }
        }
        if(count > 0) return true;
        return false;
    }

    public int pop(int i, int j, int color){
        int popCount = 0;
        boolean[][] visited = new boolean[6][6];
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[] xy = {i,j};
        queue.add(xy);

        while(!queue.isEmpty()){
            xy = queue.poll();
            int x = xy[0];
            int y = xy[1];

            if(visited[x][y]){
                continue;
            }

            count++;
            visited[x][y] = true;

            for(int d = 0; d < 4; d++){
                int nx = direction[d][0] + x;
                int ny = direction[d][1] + y;
                if(canVisit(nx, ny) && map[nx][ny] == color){
                    int[] nxy = {nx, ny};
                    queue.add(nxy);
                }
            }
        }

        if(count >= 3){
            popCount++;
            for(int x = 0; x < 6; x++){
                for(int y = 0; y < 6; y++){
                    if(visited[x][y]){
                        map[x][y] = 0;
                    }
                }
            }
        }
        return popCount;
    }

    public boolean canVisit(int x, int y){
        if(x < 0 || x >= 6 || y < 0 || y >= 6){
            return false;
        }

        return true;
    }

}
