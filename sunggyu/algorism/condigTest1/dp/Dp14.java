package sunggyu.algorism.condigTest1.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/2225
//합분해
/*
    0부터 N까지의 정수 K개를 더해서 그 합이 N이 되는 경우의 수를 구하라
    덧셈 순서가 바뀐 경우도 다른 경우로 센다.
    한 개의 수를 여러 번 쓸 수도 있다.

    0이 존재하고 n 보다 작은 정수를 이용하기 때문에 모든 정수는 n을 만들 수 있다.

    n을 만든다고 할 때 n/2+1 이상인 값은 한 번만 뽑을 수 있다.

    답을 1,000,000,000으로 나눈 나머지를 출력한다.
    점화식
    f(K) = f(K-0) + ... f(K-K)
    1 <= n,k <= 200
*/
public class Dp14{
    public static final int MOD = 1000000000;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nk = bf.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[][] map = new int[n+1][k];
        for(int i = 0; i < k; i++){
            map[0][i] = 1;
            map[1][i] = i+1;
        }

        for(int i = 2; i < n+1; i++){
            map[i][0] = 1;
            for(int j = 1; j < k; j++){
                int sum = 0;
                for(int a = 0; a <= i; a++){
                    int index = a - i;
                    index = index < 0 ? index * -1 : index;
                    sum = sum(sum, map[index][j-1]);
                }
                map[i][j] = sum;
            }
        }
        System.out.println(map[n][k-1]);
        bw.flush();
        bw.close();
    }

    public static int sum(int a, int b){
        return ((a % MOD) + (b % MOD)) % MOD;
    }
    
    
}
