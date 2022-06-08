package sunggyu.algorism.condigTest2.bruteforce.recursion;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
//https://www.acmicpc.net/problem/15658
//연산자 끼워넣기 (2)
/*
*/
public class Recursion5{
    static BufferedReader bf;
    static BufferedWriter bw;
    static int N;
    static int[] list;
    static int[] selected;
    static int[] calcType = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(bf.readLine());
        list = new int[N];
        selected = new int[N-1];
        String str = bf.readLine();
        setting(N, list, str);
        str = bf.readLine();
        setting(4, calcType, str);
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

        for(int i = 0; i < 4; i++){
            if(calcType[i] != 0){
                calcType[i]--;
                selected[depth] = i;
                per(depth+1);
                calcType[i]++;
            }
        }
    }

    public static void setting(int n, int[] list, String str){
        String[] split = str.split(" ");
        for(int i = 0; i < n; i++){
            list[i] = Integer.parseInt(split[i]);
        }
    }

    public static int getCalcValue(){
        int result = list[0];
        for(int i = 0; i < selected.length; i++){
            result = calc(result, list[i+1], selected[i]);
        }
        return result;
    }

    public static int calc(int a, int b, int type){
        int result = a;
        switch(type){
            case 0:
            result += b;
            break;

            case 1:
            result -= b;
            break;

            case 2:
            result *= b;
            break;

            case 3:
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
