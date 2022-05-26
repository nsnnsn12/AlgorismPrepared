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
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        int result = 0;
        long[] n2List = new long[n];
        long[] n3List = new long[n];
        n2List[0] = 1;
        for(int i = 1; i < n; i++){
            if(i-2 < 0){
                n2List[i] = 2;
            }else{
                n2List[i] = n2List[i-2];
                n2List[i] += n2List[i-1];
            }
        }
        if(n > 1){
            n3List[1] = 3;
            for(int i = 3; i < n; i+= 2){
                n3List[i] = n3List[i-2] * 3;
                n3List[i] += n2List[i-3] * 2;

            }
        }

        System.out.println(n3List[n-1]);
        bw.flush();
        bw.close();
    }
}