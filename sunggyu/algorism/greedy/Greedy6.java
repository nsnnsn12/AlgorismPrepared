package sunggyu.algorism.greedy;
import java.util.*;
import java.io.*;
//https://www.acmicpc.net/problem/1080
//행렬
public class Greedy6 {
    //동일한 부분은 짝수번 뒤집어야 하고
    //다른 부분은 홀수번 뒤집어야 한다.

    //3 * 3 부분행렬을 선택하면 3 * 3은 다 카운트가 한 번씩 올라가는 것.
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] split = bf.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int[][] map = new int[n][m];


        bw.flush();
        bw.close();
    }
}
