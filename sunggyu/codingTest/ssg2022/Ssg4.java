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
            //printMap(i+1);
        }
        return answer;
    }
    
    public void printMap(int index){
        System.out.println(index+"번 드롭");
        for(int i = 0; i < 6; i++){
            for(int j  =0; j < 6; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void drop(int[] macaron){
        int y = macaron[0] - 1;
        int x = searchPosition(y);
        int color = macaron[1];
        map[x][y] = color;
        while(isPoped()){
            sort();
            printMap(1);
        }
    }

    public void sort(){
        int[] list = new int[6];
        for(int y = 0; y < 6; y++){
            int count = 0;
            for(int x = 0; x < 6; x++){
                if(map[x][y] != 0) list[count++] = map[x][y];
            }
            for(int x = 0; x < count; x++){
                map[x][y] = list[x];
            }
        }
    }

    public int searchPosition(int position){
        for(int i = 0; i < 6; i++){
            if(map[i][position] == 0){
                return i;
            }
        }
        return 0;
    }

    public boolean isPoped(){
        boolean result = false;
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 6; j++){
                if(map[i][j] != 0){
                    if(getPopCount(i, j, map[i][j]) >= 3) result = true;
                }
            }
        }
        return result;
    }

    public int getPopCount(int i, int j, int color){
        int count = 0;
        boolean[][] visited = new boolean[6][6];
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
            pop(visited);
        }
        return count;
    }

    public void pop(boolean[][] visited){
        for(int x = 0; x < 6; x++){
            for(int y = 0; y < 6; y++){
                if(visited[x][y]){
                    map[x][y] = 0;
                }
            }
        }
    }

    public boolean canVisit(int x, int y){
        if(x < 0 || x >= 6 || y < 0 || y >= 6){
            return false;
        }

        return true;
    }

}
