package sunggyu.algorism.recursion;

import java.util.*;
//https://www.acmicpc.net/problem/15651
//N과 M(3)
public class NM3 {
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
        permutation(0);

        System.out.println(sb);
    }

    public static void permutation(int depth){
        if(depth == m){
            sb.append(result).append("\n");
            return;
        }

        for(int i = 0; i < n; i++){
            int value = i+1;
            result[depth*2] = (char)(value+'0');
            permutation(depth+1);
        }
    }
}
