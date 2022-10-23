package sunggyu.backjun.condigTest2.bruteforce.recursion;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
//https://www.acmicpc.net/problem/14888
//연산자 끼워넣기
/*
    N의 최대 갯수는 11개
    연산자는 N - 1개이므로 최대 10개
    10개 연산자의 대한 순열이므로 10팩토리얼이지만
    연산자 종류는 4개이므로 중복되는 순열을 제거하면 완전 탐색 가능.
*/
public class Recursion4{
    static BufferedReader bf;
    static BufferedWriter bw;
    static int N;
    static int[] list;
    static char[] calc;
    static char[] selected;
    static char[] calcTypes = {'+','-','*','/'};
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(bf.readLine());
        list = new int[N];
        String[] split = bf.readLine().split(" ");
        for(int i = 0 ; i < N; i++){
            list[i] = Integer.parseInt(split[i]);
        }
        calc = new char[N-1];
        selected = new char[N-1];
        visited = new boolean[N-1];
        split = bf.readLine().split(" ");
        int index = 0;
        for(int i = 0;  i < 4; i++){
            int count = Integer.parseInt(split[i]);
            for(int j = 0; j < count; j++){
                calc[index] = calcTypes[i];

                index++;
            }
        }
        per(0);
        System.out.println(max);
        System.out.println(min);
        bw.flush();
        bw.close();
    }

    public static void per(int depth){
        if(depth == N - 1){
            int value = getCalcValue();
            min = Math.min(min, value);
            max = Math.max(max, value);
            return;
        }
        int beforeIndex = -1;
        for(int i = 0; i < N - 1; i++){
            if(beforeIndex >= 0 && calc[i] == calc[beforeIndex]){
                continue;
            }
            if(!visited[i]){
                selected[depth] = calc[i];
                visited[i] = true;
                per(depth+1);
                visited[i] = false;
                beforeIndex = i;
            }
        }
    }

    public static int getCalcValue(){
        int result = list[0];
        for(int i = 0; i < selected.length; i++){
            result = calc(result, list[i+1], selected[i]);
        }

        return result;
    }

    public static int calc(int a, int b, char type){
        int result = a;
        switch(type){
            case '+':
            result += b;
            break;

            case '-':
            result -= b;
            break;

            case '*':
            result *= b;
            break;

            case '/':
            if(result < 0){
                result *= -1;
                result /= b;
                result *= -1;
            }else if(result == 0){
                break;
            }else{
                result /= b;
            }
            break;

            default:
            break;
        }

        return result;
    }
}
