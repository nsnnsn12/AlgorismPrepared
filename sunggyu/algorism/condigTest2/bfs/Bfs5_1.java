package sunggyu.algorism.condigTest2.bfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/2206
//벽 부수고 이동하기 리팩토링
/*
    벽을 부순 distance와
    부수지 않은 distance 2개의 visited log가 필요한 이유가 무엇인가?
    벽을 부수지 않은 경우의 대한 distance 기록이 필요하기 때문에
*/
public class Bfs5_1{
    static BufferedReader bf;
    static BufferedWriter bw;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        bw.flush();
        bw.close();
    }
}
