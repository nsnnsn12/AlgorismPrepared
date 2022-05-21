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
            int length = list.length;
            list[0] += maxList[i-1][0];
            list[length-1] += maxList[i-1][length-2];
            for(int j = 1; j < length-1; j++){
                list[j] += Math.max(maxList[i-1][j-1], maxList[i-1][j]);
            }
            maxList[i] = list;
        }

        int max = 0;
        for(int i = 0; i < maxList[n-1].length; i++){
            max = Math.max(max, maxList[n-1][i]);
        }

        System.out.println(max);
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