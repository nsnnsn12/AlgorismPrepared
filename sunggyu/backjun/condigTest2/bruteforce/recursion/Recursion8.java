package sunggyu.backjun.condigTest2.bruteforce.recursion;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
//https://www.acmicpc.net/problem/9663
//N-Queen
/*
*/
public class Recursion8{
    static BufferedReader bf;
    static BufferedWriter bw;
    static int N;
    static boolean[] height;
    static boolean[] increase;
    static boolean[] decrease;
    static int count;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(bf.readLine());
        height = new boolean[N];
        int index = 1;
        if(N != 1){
            index = N * 2 - 1;
        }
        increase = new boolean[index];
        decrease = new boolean[index];
        dfs(0);
        System.out.println(count);
        bw.flush();
        bw.close();
    }

    public static void dfs(int width){
        if(width == N){
            count++;
            return;
        }

        for(int i = 0; i < N; i++){
            if(!height[i]){
                int dec = width + i;
                int inc = width - i + N - 1;
                if(!decrease[dec] && !increase[inc]){
                    decrease[dec] = true;
                    increase[inc] = true;
                    height[i] = true;
                    dfs(width+1);
                    height[i] = false;
                    decrease[dec] = false;
                    increase[inc] = false;
                }
            }
        }
    }
}
