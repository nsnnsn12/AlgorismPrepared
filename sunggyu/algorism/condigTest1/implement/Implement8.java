package sunggyu.algorism.condigTest1.implement;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/15685
//드래곤커브
/*
    좌표 평면 위에서 오른쪽으로 가는 선분을 시계 방향으로 꺾으면 위로가게 된다.
    이와 같은 방법을 사용하면
    오른쪽 -> 위쪽
    위쪽 -> 왼쪽
    아래쪽 -> 오른쪽
    
*/
public class Implement8{
    static int[][] map;
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        map = new int[101][101];
        n = Integer.parseInt(bf.readLine());
        List<Dragon> dragons = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String[] split = bf.readLine().split(" ");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            //동북서남
            int d = Integer.parseInt(split[2]);
            int g = Integer.parseInt(split[3]);
            dragons.add(new Dragon(x, y, d, g, map));
        }

        dragons.forEach(dragon -> {
            dragon.create();
        });
        int count = 0;
        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                if(map[i][j] == 1 && map[i+1][j] == 1 && map[i][j+1] == 1 && map[i+1][j+1] == 1){
                    count++;
                }
            }
        }

        System.out.println(count);  
        bw.flush();
        bw.close();
    }

    static class Dragon{
        int x;
        int y;
        int d;
        int g;
        //동북서남
        int[][] directions = {{0,1},{-1,0},{0,-1},{1,0}};
        int[][] map;
        public Dragon(int x, int y, int d, int g, int[][] map){
            this.x = y;
            this.y = x;
            this.d = d;
            this.g = g;
            this.map = map;
        }

        public void create(){
            List<Integer> directList = getDirectList();
            map[x][y] = 1;
            for(int nd : directList){
                x += directions[nd][0];
                y += directions[nd][1];
                map[x][y] = 1;
            }
        }

        public List<Integer> getDirectList(){
            List<Integer> dList = new ArrayList<>();
            dList.add(d);
            for(int i = 0; i < g; i++){
                int size = dList.size()-1;
                for(int j = size; j >= 0; j--){
                    int nd = (dList.get(j) + 1) % 4;
                    dList.add(nd);
                }
            }
            return dList;
        }
    }
}
