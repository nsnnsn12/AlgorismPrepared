package sunggyu.algorism.condigTest1.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1932
//정수 삼각형
/*
*/
public class Dp20{
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        int[][] maxList = new int[n][];
        maxList[0] = new int[1];
        maxList[0][0] = Integer.parseInt(bf.readLine());
        for(int i = 1; i < n; i++){
            int[] list = getList(bf.readLine());
        }
        bw.flush();
        bw.close();
    }

    public static int[] getList(String str){
        String[] split = str.split(" ");
        int[] list = new int[split.length];
        for(int i = 0; i < split.length; i++){
            list[i] = Integer.parseInt(split[i]);
        }

        return list;
    }
}