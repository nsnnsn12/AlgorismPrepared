package sunggyu.codingTest.sk20220312;
import java.math.*;
public class Solution3 {
    public BigInteger[][] map;
    public BigInteger[][] map2;
    public int width;
    public int height;
    public int solution(int width, int height, int[][] diagonals) {
        //대각선이 없을 경우의 최단거리는 width + height
        //왜? 좌측 하단에서 우측 상단으로 가는 최단거리는 오른쪽과 위쪽으로만 이동해야 하기 때문에
        //대각선이 존재하는 경우 width+height+1
        //왜? 대각선을 정확히 1번 이용해야 하기 때문에
        //대각선까지의 최단거리 경우의 수 * 대각선으로 부터 최단거리 경우의수
        //총 합은 대각선까지의 최단거리 경우의 수 * 대각선으로 부터 최단거리 경우의수 * (width+height+1)
        //각 좌표에 최단거리 경우의 수를 가지고 있는 map이 필요함
        BigInteger answer = new BigInteger("0");
        this.height = height;
        this.width = width;

        int n = diagonals.length;
        map = new BigInteger[width+1][height+1];
        map2 = new BigInteger[width+1][height+1];
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
            BigInteger d1 = map[x][y+1].multiply(map2[x+1][y]);
            BigInteger d2 = map[x+1][y].multiply(map2[x][y+1]);
            answer = answer.add(d1.add(d2));
        }
        int result = answer.remainder(new BigInteger("10000019")).intValue();
        System.out.println(result);
        return result;
    }

    public void mapSetting1(){
        for(int i = 0; i < width+1; i++){
            for(int j = 0; j < height+1; j++){
                BigInteger value = new BigInteger("1");
                if(i != 0 && j != 0){
                    value = map[i-1][j].add(map[i][j-1]);
                }
                map[i][j] = value;
            }
        }
    }

    public void mapSetting2(){
        for(int i = width; i >= 0; i--){
            for(int j = height; j >= 0; j--){
                BigInteger value = new BigInteger("1");
                if(i != width && j != height){
                    value = map2[i+1][j].add(map2[i][j+1]);
                }
                map2[i][j] = value;
            }
        }
    }
}
