package sunggyu.backjun.condigTest1.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/2193
//이친수
/*
    n의 끝자리의 갯수를 구한다.
    0은 0과 1이 가능
    1은 0만 가능

    주의!!
    값이 큰데 int로 계산해서 틀림.
*/
public class Dp9_review{
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bf.readLine());
        long[][] countOfnumbers = new long[n][2];
        countOfnumbers[0][1] = 1L;
        for(int i = 1; i < n; i++){
            countOfnumbers[i][0] = countOfnumbers[i-1][0] + countOfnumbers[i-1][1];
            countOfnumbers[i][1] = countOfnumbers[i-1][0];
        }
        long result = countOfnumbers[n-1][0] + countOfnumbers[n-1][1];
        System.out.println(result);
        bw.flush();
        bw.close();
    }
    
    
}
