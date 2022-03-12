package sunggyu.algorism.greedy;
import java.util.*;
import java.io.*;
//https://www.acmicpc.net/problem/1080
//행렬
public class Greedy6 {
    //해당 문제의 한계점
    //무조건 3 * 3을 뒤집어야 한다.
    //
    //3*3을 한 번 다 뒤집었을 때 성공하려면 a와 b가 서로 대칭을 이루어야 한다.
    //두번 뒤집으면 원래 상태
    //250 * 250 = 62500
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
