package sunggyu.algorism.condigTest1.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1463
//1로 만들기
/*

    bottomUp은 통과
    topDown은 시간초과

    dp를 사용할 때는 최대한 bottomUp 사용
*/
public class Dp1{
    static boolean[] visit;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        int[] list = new int[n+1];
        visit = new boolean[n+1];
        visit[1] = true;
        //topDown(n, list);
        bottomUp(list);
        System.out.println(list[n]);
        bw.flush();
        bw.close();
    }

    public static void bottomUp(int[] list){
        for(int i = 2; i < list.length; i++){
            int min = list[i-1];
            if(i % 2 == 0){
                int temp = list[i / 2];
                min = Math.min(min, temp);
            }

            if(i % 3 == 0){
                int temp = list[i/3];
                min = Math.min(min, temp);
            }

            list[i] = min + 1;
        }
    }

    public static int topDown(int n, int[] list){
        if(visit[n]){
            return list[n];
        }

        int min = topDown(n-1, list) + 1;

        if(n % 2 == 0){
            int temp = topDown(n / 2, list) + 1;
            min = Math.min(min, temp);
        }

        if(n % 3 == 0){
            int temp = topDown(n / 3, list) + 1;
            min = Math.min(min, temp);
        }

        visit[n] = true;
        list[n] = min;

        return min;
    }

    
}
