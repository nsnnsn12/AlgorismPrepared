package sunggyu.backjun.condigTest1.bruteForce;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1476
//날짜 계산
/*

*/
public class Practice3{
    static int E = 15;
    static int S = 28;
    static int M = 19;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] esm = bf.readLine().split(" ");
        int e = Integer.parseInt(esm[0]);
        int s = Integer.parseInt(esm[1]);
        int m = Integer.parseInt(esm[2]);
        int index = 1;
        if(e % E == 0) e = 0;
        if(s % S == 0) s = 0;
        if(m % M == 0) m = 0;
        while(true){
            if(eqauls(index, e, s, m)){
                break;
            }
            index++;
        }
        System.out.println(index);
        bw.flush();
        bw.close();
    }

    public static boolean eqauls(int n, int e, int s, int m){
        if(n % E != e) return false;
        if(n % S != s) return false;
        if(n % M != m) return false;

        return true;
    }
}
