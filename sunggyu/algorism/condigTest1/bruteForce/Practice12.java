package sunggyu.algorism.condigTest1.bruteForce;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/2529
//부등호
/*
    k의 범위는 2 ≤ k ≤ 9
    숫자의 갯수는 k + 1이므로 최대 10개
    10개의 대한 순열은 대략 400백만개
    400만개의 대해 부등호가 올바른지 확인하려면 10번의 탐색 필요
    400백만 * 10 = 4000천만
    완전탐색 가능
*/
public class Practice12{
    static int N;
    static char[] list;
    static int K;
    static boolean[] visit = new boolean[10];
    static char[] perList;
    static long MAX = Long.MIN_VALUE;
    static long MIN = Long.MAX_VALUE;
    static String MAX_STR;
    static String MIN_STR;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(bf.readLine());
        K = N + 1;
        list = new char[N];
        perList = new char[K];
        String[] split = bf.readLine().split(" ");
        for(int i = 0; i < N; i++){
            list[i] = split[i].charAt(0);
        }

        per(0);

        System.out.println(MAX_STR);
        System.out.println(MIN_STR);
        bw.flush();
        bw.close();
    }

    public static void per(int depth){
        if(depth == K){
            if(isValid()){
                String strNumber = new String(perList);
                long value = Long.parseLong(strNumber);
                if(value > MAX){
                    MAX = value;
                    MAX_STR = strNumber;
                }

                if(value < MIN){
                    MIN = value;
                    MIN_STR = strNumber;
                }

            }
            return;
        }
        for(int i = 0; i < 10; i++){
            if(!visit[i]){
                visit[i] = true;
                perList[depth] = (char)(i+'0');
                per(depth + 1);
                visit[i] = false;
            }
        }
    }

    public static boolean isValid(){
        int a = perList[0]-'0';
        for(int i = 1; i < K; i++){
            char c = list[i-1];
            int b = perList[i] - '0';
            if(!isValid2(c, a, b)){
                return false;
            }
            a = b;
        }
        return true;
    }

    public static boolean isValid2(char c, int a, int b){
        if(c == '<'){
            if(a < b) return true;
        }else{
            if(a > b) return true;
        }

        return false;
    }

    
}
