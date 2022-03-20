package sunggyu.algorism.dfsbfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/14502
//연구소
//최대 크기의 맵은 64개
//64개 중 3개의 조합을 뽑는 경우의 수는 41664
//41664 * 64 = 2,666,496
//고로 완전 탐색 가능

public class DfsBfs2 {
    public static int[][] map;
    public static int n;
    public static int m;
    public static int maxCount = 0;
    public static int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
    public static List<int[]> viurs = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = bf.readLine().split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);
        map = new int[n][m];

        for(int i = 0; i < n; i++){
            String[] split2 = bf.readLine().split(" ");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(split2[j]);

            }
        }

        select(0, 0);

        System.out.println(maxCount);

        bw.flush();
        bw.close();
    }

    //조합
    public static void select(int depth, int start){
        if(depth == 3){
            int[][] copyMap = getCopyMap();
            
            simulation(copyMap);

            int count = getZeroCount(copyMap);
            maxCount = maxCount > count ? maxCount : count;
            return;
        }

        for(int i = start; i < n*m; i++){
            int x = 0;
            int y = 0;
            if(i != 0){
                x = i / m;
                y = i % m;
            }

            if(map[x][y] == 0){
                map[x][y] = 1;
                select(depth+1, start+1);
                map[x][y] = 0;
            }
        }
    }

    //감염되지 않은 지역 count
    public static int getZeroCount(int[][] copyMap){
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(copyMap[i][j] == 0){
                    count++;
                }
            }
        }

        return count;

    }

    //감염 시뮬레이션
    public static void simulation(int[][] copyMap){

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(copyMap[i][j] == 2){
                    for(int[] xy : direction){
                        infection(copyMap, i + xy[0], j + xy[1]);
                    }
                }
            }
        }
    }

    //재귀를 이용한 감염 처리
    public static void infection(int[][] copyMap, int x, int y){
        if(x < 0 || x >= n || y < 0 || y >= m){
            return;
        }

        if(copyMap[x][y] != 0){
            return;
        }

        copyMap[x][y] = 2;

        for(int i = 0; i < 4; i++){
            infection(copyMap, x+direction[i][0], y + direction[i][1]);
        }
    }

    //map copy
    public static int[][] getCopyMap(){
        int[][] copyMap = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                copyMap[i][j] = map[i][j];
            }
        }
        return copyMap;
    }
}
