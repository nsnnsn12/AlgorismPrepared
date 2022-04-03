package sunggyu.codingTest.sk20220312;
import java.math.*;
public class Solution3 {
    public int[][] map;
    public int[][] map2;
    public int width;
    public int height;
    public static final int MOD = 10000019;
    public int solution(int width, int height, int[][] diagonals) {
        //대각선이 없을 경우의 최단거리는 width + height
        //왜? 좌측 하단에서 우측 상단으로 가는 최단거리는 오른쪽과 위쪽으로만 이동해야 하기 때문에
        //대각선이 존재하는 경우 width+height+1
        //왜? 대각선을 정확히 1번 이용해야 하기 때문에
        //대각선까지의 최단거리 경우의 수 * 대각선으로 부터 최단거리 경우의수
        //총 합은 대각선까지의 최단거리 경우의 수 * 대각선으로 부터 최단거리 경우의수
        //각 좌표에 최단거리 경우의 수를 가지고 있는 map이 필요함
        int answer = 0;
        this.height = height;
        this.width = width;

        int n = diagonals.length;
        map = new int[width+1][height+1];
        map2 = new int[width+1][height+1];
        mapSetting1();
        mapSetting2();
        // for(BigInteger[] list: map){
        //     for(BigInteger l : list){
        //         System.out.print(l + " ");
        //     }
        //     System.out.println();
        // }

        // System.out.println();
        
        // for(BigInteger[] list: map2){
        //     for(BigInteger l : list){
        //         System.out.print(l + " ");
        //     }
        //     System.out.println();
        // }

        for(int[] d : diagonals){
            int x = d[0]-1;
            int y = d[1]-1;
            int d1 = modulerMultiple(map[x][y+1], map2[x+1][y]);
            int d2 = modulerMultiple(map[x+1][y], map2[x][y+1]);
            int sum = modulerSum(d1, d2);
            answer = modulerSum(answer, sum);
        }
        
        System.out.println(answer);
        return answer;
    }
    public int modulerSum(int a, int b){
        return ((a % MOD) + (b % MOD)) % MOD;
    }

    public int modulerMultiple(int a, int b){
        return ((a % MOD) * (b % MOD)) % MOD;
    }
    public void mapSetting1(){
        for(int i = 0; i < width+1; i++){
            for(int j = 0; j < height+1; j++){
                int value = 1;
                if(i != 0 && j != 0){
                    value = modulerSum(map[i-1][j], map[i][j-1]);
                }
                map[i][j] = value;
            }
        }
    }

    public void mapSetting2(){
        for(int i = width; i >= 0; i--){
            for(int j = height; j >= 0; j--){
                int value = 1;
                if(i != width && j != height){
                    value = modulerSum(map2[i+1][j], map2[i][j+1]);
                }
                map2[i][j] = value;
            }
        }
    }
}
