package sunggyu.backjun.condigTest2.bruteforce.etc;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/2003
//수들의 합 2
/*

*/
public class Etc1{
    static BufferedReader bf;
    static BufferedWriter bw;
    static int N;
    static int M;
    static int[] list;
    static int result;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] split = bf.readLine().split(" ");
        N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);
        list = new int[N];
        split = bf.readLine().split(" ");
        for(int i = 0; i < N; i++){
            list[i] = Integer.parseInt(split[i]);
        }

        for(int i = 0; i < N; i++){
            int sum = 0;
            for(int j = i; j < N; j++){
                sum += list[j];
                if(sum == M) result++;
            }
        }
        System.out.println(result);
        bw.flush();
        bw.close();
    }
}
