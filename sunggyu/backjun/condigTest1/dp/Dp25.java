package sunggyu.backjun.condigTest1.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/2133
//타일 채우기
/*
    n이 홀수인 경우는 타일로 채울 수 없다.
    
    길이가 2인 경우를 기준으로의 모든 경우의 수
    n3List[i] = n3List[i-2] * 3;

    그외 길이가 2의 배수인 경우
    n3List[i] += n3List[j] * 2;
*/
public class Dp25{
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        long result = 0;
        if(n % 2 == 0){
            result = getResult(n + 1);
        }

        System.out.println(result);
        bw.flush();
        bw.close();
    }

    public static long getResult(int n){
        long[] n3List = new long[n];
        n3List[0] = 1;
        n3List[1] = 0;
        n3List[2] = 3;
        for(int i = 4; i < n; i+=2){
            n3List[i] = n3List[i-2] * 3;
            for(int j = i-4; j >= 0; j -= 2){
                n3List[i] += n3List[j] * 2;
            }
        }
        return n3List[n-1];
    }
}