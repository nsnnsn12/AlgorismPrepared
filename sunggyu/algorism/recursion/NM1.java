package sunggyu.algorism.recursion;

import java.util.*;
//https://www.acmicpc.net/problem/15649
//N과 M(1)
public class NM1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] split = str.split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        boolean[] selectFlag = new boolean[n];
        int[] list = new int[m];
        List<Integer> list2 = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list2.add(i+1);
        }
        String result = "";
        permutation(n, m, 0, selectFlag, list, list2, result);
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
}
