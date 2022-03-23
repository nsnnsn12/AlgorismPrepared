package sunggyu.algorism.bruteforce;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/2502
//떡 먹는 호랑이

public class Bruteforce3{
    public static int D;
    public static int K;
    public static int a;
    public static int b;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] dk = bf.readLine().split(" ");
        D = Integer.parseInt(dk[0]);
        K = Integer.parseInt(dk[1]);
        for(int i = K / 2 + 1; i < K; i++){
            findAb(K, i, 2);
        }
        System.out.println(a);
        System.out.println(b);
        bw.flush();
        bw.close();
    }

    public static void findAb(int k , int n1, int depth){
        if(a != 0) return;
        if(depth == D){
            a = n1;
            b = k;
            return;
        }
        int n2 = k - n1;
        if(n1 > n2){
            findAb(n1, n2, depth+1);
        }
    }
    
}
