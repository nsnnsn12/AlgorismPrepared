package sunggyu.backjun.condigTest2.bruteforce.recursion;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
//https://www.acmicpc.net/problem/16198
//에너지 모으기
/*
*/
public class Recursion7{
    static BufferedReader bf;
    static BufferedWriter bw;
    static int N;
    static int[] list;
    static boolean[] visited;
    static int max;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(bf.readLine());
        list = new int[N];
        visited = new boolean[N];
        String[] split = bf.readLine().split(" ");
        for(int i = 0; i < N; i++){
            list[i] = Integer.parseInt(split[i]);
        }
        per(0, 0);
        System.out.println(max);
        bw.flush();
        bw.close();
    }

    public static void per(int depth, int energe){
        if(depth == N-2){
            max = Math.max(max, energe);
            return;
        }

        for(int i = 1; i < N-1; i++){
            if(!visited[i]){
                visited[i] = true;
                int value = list[getLeftIndex(i-1)] * list[getRightIndex(i+1)];
                per(depth+1, energe + value);
                visited[i] = false;
            }
        }

    }

    public static int getRightIndex(int index){
        for(int i = index; i < N; i++){
            if(!visited[i]){
                return i;
            }
        }
        return 0;
    }

    public static int getLeftIndex(int index){
        for(int i = index; i >= 0; i--){
            if(!visited[i]){
                return i;
            }
        }
        return 0;
    }
}
