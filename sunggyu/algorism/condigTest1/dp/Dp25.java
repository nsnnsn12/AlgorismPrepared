package sunggyu.algorism.condigTest1.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/2133
//타일 채우기
/*
    n이 홀수인 경우는 타일로 채울 수 없다.
    2 * n의 경우의 수를 먼저 구한다.
    2개인 경우는 3개이다.

*/
public class Dp25{
    public static long[] n2List;
    public static long result = 0L;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        if(n % 2 == 0){
            getResult(n);
        }

        System.out.println(result);
        bw.flush();
        bw.close();
    }

    public static void getResult(int n){
        n2List = new long[n];
        n2List[0] = 1;
        for(int i = 1; i < n; i++){
            if(i-2 < 0){
                n2List[i] = 2;
            }else{
                n2List[i] = n2List[i-2];
                n2List[i] += n2List[i-1];
            }
        }
        char[] list = new char[n/2];
        dfs(0, n/2, list);
        result++;
    }

    public static void dfs(int depth, int n, char[] list){
        if(depth == n){
            //System.out.println(new String(list));
            test(list);
            return;
        }

        for(int i = 0; i < 2; i++){
            list[depth] = (char)(i+'0');
            dfs(depth+1, n, list);
        }
    }

    public static void test(char[] list){
        long sum = 1L;
        char first = list[0];
        int count = 1;
        for(int i = 1; i < list.length; i++){
            if(list[i] == first){
                count++;
            }else{
                first = list[i];
                sum *= n2List[count*2-1];
                count = 1;
            }
        }
        sum *= n2List[count*2-1];
        result += sum-1;
    }
}