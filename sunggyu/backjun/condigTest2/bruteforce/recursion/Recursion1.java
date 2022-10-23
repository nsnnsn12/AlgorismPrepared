package sunggyu.backjun.condigTest2.bruteforce.recursion;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/6603
//로또
/*
    k개의 숫자가 주어졌을 때 6개의 숫자를 고르는 모든 경우의 수를 출력하라.
    k가 14이였을 경우의 최대 갯수 1716
*/
public class Recursion1{
    static String[] list;
    static String[] result = new String[6];
    static int n;
    static BufferedReader bf;
    static BufferedWriter bw;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            String k = bf.readLine();
            if(k.equals("0")){
                break;
            }
            list = k.split(" ");
            n = list.length;
            combo(0, 1);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static void combo(int depth, int startIndex) throws Exception{
        if(depth == 6){
            String str = String.join(" ", result);
            bw.write(str+"\n");
            return;
        }

        for(int i = startIndex; i < n; i++){
            result[depth] = list[i];
            combo(depth+1, i+1);
        }
    }
}
