package sunggyu.algorism.condigTest2.bruteforce.Permutation;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/2529
//부등호
/*
    0~9까지를 모두 고르는 순열 경우의 수는 대략 360만

*/
public class Permutation1{
    static BufferedReader bf;
    static BufferedWriter bw;
    static long max = 0L;
    static long min = Long.MAX_VALUE;
    static String minStr;
    static String maxStr;
    static int N;
    static String[] inequalites;
    static char[] list;
    static boolean[] visited = new boolean[10];
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(bf.readLine());
        inequalites = bf.readLine().split(" ");
        list = new char[N+1];
        
        per(0, 0);
        System.out.println(maxStr);
        System.out.println(minStr);
        bw.flush();
        bw.close();
    }

    public static void per(int depth, int beforeValue){
        if(depth == N + 1){
            String str = new String(list);
            long value = Long.parseLong(str);
            if(max < value){
                maxStr = str;
                max = value;
            }

            if(min > value){
                minStr = str;
                min = value;
            }

            return;
        }

        for(int i = 0; i < 10; i++){
            if(canVisit(i, depth, beforeValue)){
                visited[i] = true;
                list[depth] = (char)(i+'0');
                per(depth+1, i);
                visited[i] = false;
            }
        }
    }

    public static boolean canVisit(int value, int depth, int beforeValue){
        if(!visited[value]){
            if(depth == 0) return true;
            String str = inequalites[depth-1];
            if(str.equals("<") && beforeValue < value) return true;
            if(str.equals(">") && beforeValue > value) return true;
        }
        return false;
    }
}
