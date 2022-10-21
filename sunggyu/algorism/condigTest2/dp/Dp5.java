package sunggyu.algorism.condigTest2.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/11066
//파일 합치기
/*
*/
public class Dp5 {
    static BufferedReader bf;
    static BufferedWriter bw;
    static int T;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(bf.readLine());
        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(bf.readLine());
            String[] split = bf.readLine().split(" ");
            int[] list = new int[n];
            for(int j = 0; j < n; j++){
                list[j] = Integer.parseInt(split[j]);
            }
        }
        bw.flush();
        bw.close();
    }

    public static int getMinCost(int[] list){
        
        return 0;
    }
}


