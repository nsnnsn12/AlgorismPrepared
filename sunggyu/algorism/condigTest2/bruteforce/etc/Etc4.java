package sunggyu.algorism.condigTest2.bruteforce.etc;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/1208
//부분수열의 합 2
/*
    부분수열이란 원 수열의 항의 일부분만을 딴 수열
    ex) 1, 4, 0, 3, 7, 2, 5, 10 -> 1, 4, 7, 10

    원 수열의 순서가 변하지는 않는다.

    최대갯수는 40개
    완전탐색을 사용할 경우
    모든 조합의 경우의 수가 필요
    40C1
    40C2
    40C3
    ...
*/
public class Etc4{
    static BufferedReader bf;
    static BufferedWriter bw;    
    static int N;
    static int S;
    static int[] list;
    static int result;
    static int count;
    static int length;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        /*
         * String[] split =bf.readLine().split(" ");
            N = Integer.parseInt(split[0]);
            S = Integer.parseInt(split[1]);
            split = bf.readLine().split(" ");
            list = new int[N];
            for(int i = 0; i < N; i++){
                list[i] = Integer.parseInt(split[i]);
            }
            for(int i = 0; i < list.length; i++){
                dfs(i+1, list[i]);
            }
            System.out.println(result);
         */
        length =Integer.parseInt(bf.readLine());
        getNumberOfCases(0);
        System.out.println(count);
        bw.flush();
        bw.close();
    }

    public static void dfs(int startIndex, int sum){
        if(sum == S){
            result++;
        }

        for(int i = startIndex; i < list.length; i++){
            sum += list[i];
            dfs(i + 1, sum);
            sum -= list[i];
        }
    }
    public static void getNumberOfCases(int startIndex){
        for(int i = startIndex; i < length; i++){
            count++;
            getNumberOfCases(i + 1);
        }
    }
}
