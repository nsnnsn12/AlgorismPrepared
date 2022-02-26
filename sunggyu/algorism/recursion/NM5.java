package sunggyu.algorism.recursion;

import java.util.*;
//https://www.acmicpc.net/problem/15654
//N과 M(5)
public class NM5 {
    public static int n;
    public static int m;
    public static char[] result;
    public static StringBuilder sb;
    public static boolean[] visit;
    public static int[] list;
    public static int[] perList;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nm = sc.nextLine();
        String strList = sc.nextLine();

        setting(nm, strList);
        permutation(0);

        System.out.print(sb);
    }

    public static void setting(String nm, String strList){
        String[] splitNm = nm.split(" ");
        String[] splitList = strList.split(" ");

        n = Integer.parseInt(splitNm[0]);
        m = Integer.parseInt(splitNm[1]);
        visit = new boolean[n];
        list = new int[n];
        perList = new int[m];
        sb = new StringBuilder();
        for(int i = 0; i  < n; i++){
            list[i] = Integer.parseInt(splitList[i]);
        }
        Arrays.sort(list);

    }

    public static void permutation(int depth){
        if(depth == m){
            for(int i : perList){
                sb.append(Integer.toString(i)).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < n; i++){
            if(!visit[i]){
                visit[i] = true;
                perList[depth] = list[i];
                permutation(depth+1);
                visit[i] = false;
            }
        }
    }
}
