package sunggyu.algorism.greedy.silver1;
import java.util.*;
import java.io.*;
//https://www.acmicpc.net/problem/1080
//행렬
public class Greedy6 {
    //동일한 부분은 짝수번 뒤집어야 하고
    //다른 부분은 홀수번 뒤집어야 한다.

    //3 * 3의 해당하는 모든 부분을 뒤집는다는 것은
    //잘 못 뒤집은 부분을 다시 원복시켜야 한다는 뜻
    //좌측 상단에서 우측 하단으로 동일하지 않은 부분을 찾는다고 했을 때
    //동일하지 않은 부분을 찾는대로 뒤집어 주는 것이 최단 횟수를 찾는 방법
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] split = bf.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int[][] map = new int[n][m];
        boolean[][] check = new boolean[n][m];
        for(int x = 0; x < n; x++){
            char[] list = bf.readLine().toCharArray();
            for(int y = 0; y < m; y++){
                map[x][y] = list[y] - '0';
            }
        }

        for(int x = 0; x < n; x++){
            char[] list = bf.readLine().toCharArray();
            for(int y = 0; y < m; y++){
                if(map[x][y] == list[y] - '0'){
                    check[x][y] = true;
                }
            }
        }

        int result = 0;
        if(n >= 3 || m >= 3){
            for(int x = 0; x < n-2; x++){
                for(int y = 0; y < m-2; y++){
                    if(!check[x][y]){
                        result++;
                        reverseCheck(check, x, y);
                    }
                }
            }

            for(int x = 0; x < n; x++){
                for(int y = 0; y < m; y++){
                    if(!check[x][y]){
                        result = -1;
                        break;
                    }
                }
            }

        }else{
            for(int x = 0; x < n; x++){
                for(int y = 0; y < m; y++){
                    if(!check[x][y]){
                        result = -1;
                        break;
                    }
                }
            }
        }

        System.out.println(result);

        bw.flush();
        bw.close();
    }

    public static void reverseCheck(boolean[][] check, int x, int y){
        for(int i = x; i < x+3; i++){
            for(int j = y; j < y+3; j++){
                if(check[i][j]){
                    check[i][j] = false;
                }else{
                    check[i][j] = true;
                }
            }
        }
    }
}
