package sunggyu.algorism.recursion;

import java.util.*;
//https://www.acmicpc.net/problem/15649
//N과 M(1)
public class NM1 {
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
        permutation2(0);
        System.out.print(sb);
    }

    public static void permutation(int n, int m, int index, boolean[] selectFlag, int[] list, List<Integer> list2, String result){
        if(index == m){
            //프린트하고 리턴
            System.out.println(result);
            return;
        }
        int size = list2.size();
        for(int i = 0; i < size; i++){
            int value = list2.get(i);
            result += String.format("%d ", value);
            list[index] = value;
            list2.remove(i);
            permutation(n, m, index+1, selectFlag, list, list2, result);
            list2.add(value);
            Collections.sort(list2);
            result = result.substring(0, result.length()-2);
        }
    }

    public static void permutation2(int depth){
        if(depth == m){
            sb.append(result).append('\n');
            return;
        }
        for(int i = 0; i < n; i++){
            if(!selectFlag[i]){
                selectFlag[i] = true;
                int value = i+1;
                result[depth*2] = (char)(value+'0');
                permutation2(depth+1);
                selectFlag[i] = false;
            }
        }
    }
}
