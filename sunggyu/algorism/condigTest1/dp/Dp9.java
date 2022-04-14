package sunggyu.algorism.condigTest1.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/2193
//이친수
/*
    주의!!
    값이 큰데 int로 계산해서 틀림.
    
    1.0으로 시작하지 않는다.
    2.1이 두번 연속으로 나오지 않는다.

    N자리 이친수의 갯수를 구하라.

    0으로 시작하는 경우의 수는 2개
    1로 시작하는 경우의 수는 1개
*/
public class Dp9{
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        long[] indexOfOne = new long[n];
        long[] indexOfZero = new long[n];
        indexOfOne[0] = 1L;
        indexOfZero[0] = 0L;

        for(int i = 1; i < n; i++){
            indexOfZero[i] = indexOfOne[i-1] + indexOfZero[i-1];
            indexOfOne[i] = indexOfZero[i-1];
        }
        long result = indexOfOne[n-1] + indexOfZero[n-1];
        System.out.println(result);
        bw.flush();
        bw.close();
    }
    
    
}
