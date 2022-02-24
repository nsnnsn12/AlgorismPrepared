package sunggyu.algorism.recursion;

import java.util.*;
//https://www.acmicpc.net/problem/15652
//N과 M(4)
public class NM4 {
    public static int n;
    public static int m;
    public static char[] result;
    public static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] split = str.split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);
        result = new char[m*2];
        for(int i = 1; i < result.length; i +=2){
            result[i] = ' ';
        }

        sb = new StringBuilder();
        combination(0, 0);

        System.out.println(sb);
    }

    public static void combination(int depth, int start){
        if(depth == m){
            sb.append(result).append("\n");
            return;
        }

        for(int i = start; i < n; i++){
            int value = i+1;
            result[depth*2] = (char)(value+'0');
            combination(depth+1, i);
        }
    }
}
