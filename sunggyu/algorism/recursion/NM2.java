package sunggyu.algorism.recursion;

import java.util.*;
//https://www.acmicpc.net/problem/15650
//N과 M(2)
public class NM2 {
    public static StringBuilder sb;
    public static int n;
    public static int m;
    public static boolean[] selectFlag;
    public static char[] result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        String str = sc.nextLine();
        String[] split = str.split(" ");
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);
        selectFlag = new boolean[n];
        result = new char[2*m];
        for(int i = 1; i < 2*m; i+=2){
            result[i] = ' ';
        }
        combination(0, 0);
        System.out.print(sb);
    }

    public static void combination(int depth, int start){
        if(m == depth){
            sb.append(result).append("\n");
            return;
        }

        for(int i = start; i < n; i++){
            int value = i+1;
            result[depth*2] =(char)(value+'0');
            combination(depth+1, i+1);
        }
    }
}
