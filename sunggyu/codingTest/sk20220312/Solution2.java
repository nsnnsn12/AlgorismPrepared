package sunggyu.codingTest.sk20220312;

public class Solution2 {
    int[][] map;
    boolean clockwise;
    int n;
    int[][] direction1 = {{0,1}, {1,0},{0,-1},{-1,0}};
    int[][] direction2 = {{1,0},{0,1}, {-1,0}, {0,-1}};
    public int[][] solution(int n, boolean clockwise) {
        this.n = n;
        this.clockwise = clockwise;
        map = new int[n][n];
        //홀수면 가운데로 끝남.
        //짝수면 4개로 끝남
        int count = n / 2;
        int startNumber = 1;
        int endNumber = n - 1;
        int count2 = n-1;
        for(int i = 0; i < count; i++){
            mapSetting(i, i, startNumber, endNumber, count2);
            startNumber = endNumber + 1;
            count2 -= 2;
            endNumber = endNumber + count2;
        }

        if(n % 2 !=0){
            map[count][count] = endNumber + 1;
        }

        return map;
    }

    public void mapSetting(int x, int y, int startNumber, int endNumber, int count){
        int[][] direction;
        if(clockwise){
            direction = direction1;
        }else{
            direction = direction2;
        }

        for(int d = 0; d < 4; d++){
            int dx = direction[d][0];
            int dy = direction[d][1];
            int selectNumber = startNumber;
            for(int i = 0; i < count; i++){
                if(selectNumber > endNumber){
                    selectNumber = startNumber;
                }
                map[x][y] = selectNumber;
                x += dx;
                y += dy;
                selectNumber++;
            }
        }
    }
}
