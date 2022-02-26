package sunggyu.algorism.recursion;

import java.util.*;
//https://www.acmicpc.net/problem/15665
//N과 M(11)
public class NM11 {
    public static int n;
    public static int m;
    public static char[] result;
    public static StringBuilder sb;
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
        int beforeIndex = -1;
        for(int i = 0; i < n; i++){
            if(beforeIndex >= 0 && list[i] == list[beforeIndex]){
                continue;
            }
            perList[depth] = list[i];
            permutation(depth+1);
            beforeIndex = i;
        }
    }
}
