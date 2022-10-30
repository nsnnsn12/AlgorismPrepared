package sunggyu.backjun.condigTest2.dp;
import java.io.*;
import java.util.*;

//https://www.acmicpc.net/problem/1495
//기타리스트(해설 봤음)
/*
    공연에서 n개의 곡을 연주한다.
    곡이 시작하기 전 볼륨을 바꾼다.
    각 곡마다 정해진 볼륨이 있다.
    곡을 변경하기 위해서는 현재 볼륨에서 다음 곡 볼륨을 더하거나 빼야 한다.
    0보다 작거나 M보다 크게 볼륨을 변경할 수는 없다.
    
    마지막으로 연주할 수 있는 최대 볼륨을 출력하라.
    마지막 곡을 연주할 수 없는 경우 -1을 리턴한다.

    리스트에 적힌대로 곡을 연주할 수 있다.
    즉 리스트에 적힌대로 + 혹은 -를 하라.

    1 ≤ N ≤ 50
    1 ≤ M ≤ 1,000
    0 ≤ S ≤ M

    현재의 최적해가 분할한 부분사례의 최적해를 포함하고 있는가? => 탑다운 방식으로 정의한다.
    n번째의 최적해 = n - v, n + v

    완전탐색 방법
    1. 모든 +, -의 대한 경우의 수를 구한다.
    2. 모든 경우의 수를 실행하여 최댓값을 구한다.

    결국 각 곡마다 0~ 1000사이에 value만 가질 수 있음으로
    각 음정의 대해 방문 가능 여부를 체크함으로 정답을 도출할 수 있다.
*/
public class Dp7 {
    static BufferedReader bf;
    static BufferedWriter bw;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] nsm = bf.readLine().split(" "); 
        int N = Integer.parseInt(nsm[0]);
        int START = Integer.parseInt(nsm[1]);
        int MAX_VOLUME = Integer.parseInt(nsm[2]);
        int[] list = new int[N+1];
        String[] split = bf.readLine().split(" ");
        list[0] = START;
        for(int i = 1; i <= N; i++){
            list[i] = Integer.parseInt(split[i-1]);
        }
        boolean[][] dp = new boolean[N+1][MAX_VOLUME+1];
        dp[0][START] = true;
        for(int i = 1; i <= N; i++){
            int volume = list[i];
            for(int j = 0; j <= MAX_VOLUME; j++){
                if(dp[i-1][j]){
                    int plus = j + volume;
                    if(plus >= 0 && plus <= MAX_VOLUME){
                        dp[i][plus] = true;
                    }
                    int minus = j - volume; 
                    if(minus >= 0 && minus <= MAX_VOLUME){
                        dp[i][minus] = true;
                    }
                }
            }
        }
        int result = -1;
        for(int i = 0; i <= MAX_VOLUME; i++){
            if(dp[N][i]){
                result = i;
            }
        }

        System.out.println(result);
        bw.flush();
        bw.close();
    }
}


