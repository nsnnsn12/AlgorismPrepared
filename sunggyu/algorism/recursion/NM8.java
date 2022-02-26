package sunggyu.algorism.recursion;

import java.util.*;
//https://www.acmicpc.net/problem/15657
//N과 M(8)
public class NM8 {
    public static int n;
    public static int m;
    public static char[] result;
    public static StringBuilder sb;
    public static int[] list;
    public static int[] comboList;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nm = sc.nextLine();
        String strList = sc.nextLine();

        setting(nm, strList);
        combo(0, 0);

        System.out.print(sb);
    }

    public static void setting(String nm, String strList){
        String[] splitNm = nm.split(" ");
        String[] splitList = strList.split(" ");

        n = Integer.parseInt(splitNm[0]);
        m = Integer.parseInt(splitNm[1]);
        list = new int[n];
        comboList = new int[m];
        sb = new StringBuilder();
        for(int i = 0; i  < n; i++){
            list[i] = Integer.parseInt(splitList[i]);
        }
        Arrays.sort(list);

    }

    public static void combo(int depth, int start){
        if(depth == m){
            for(int i : comboList){
                sb.append(Integer.toString(i)).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i < n; i++){
            comboList[depth] = list[i];
            combo(depth+1, i);
        }
    }
}
