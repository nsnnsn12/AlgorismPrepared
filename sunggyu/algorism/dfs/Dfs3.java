package sunggyu.algorism.dfs;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/2668
//숫자고르기
/*
    각각 연결된 것을 따라 끝과 처음이 같아야 한다.
*/
public class Dfs3{
    public static int n;
    public static int[] list;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bf.readLine());
        list = new int[n];
        for(int i = 0; i < n; i++){
            list[i] = Integer.parseInt(bf.readLine());
        }
        bw.flush();
        bw.close();
    }
}