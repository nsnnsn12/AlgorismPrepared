package sunggyu.backjun.condigTest2.dp;
import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/11060
//점프 점프
/*
    현재 선택된 index는 어디서부터 뛸 수 있는가?
    현재 선택한 index를 기준으로 이전 index를 다 탐색한다.

    28%에서 틀림
    해결 => 도달하지 못 하는 index인 경우 MAX_VALUE로 초기화해야 하는데 하지 못 해서 틀렸던 것
*/
public class Dp2 {
    static BufferedReader bf;
    static BufferedWriter bw;
    static int N;
    static int[] list;
    static int[] dp;
    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(bf.readLine());
        list = new int[N];
        dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        String[] split = bf.readLine().split(" ");
        for(int i = 0; i < N; i++){
            list[i] = Integer.parseInt(split[i]);
        }

        for(int selectIndex = 1; selectIndex < N; selectIndex++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < selectIndex; j++){
                int jumpDistance = j + list[j];
                if(selectIndex <= jumpDistance){
                    min = Math.min(min, dp[j]);
                }
            }

            dp[selectIndex] = min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min + 1;
        }

        int result = dp[N-1] == Integer.MAX_VALUE ? -1 : dp[N-1];
        System.out.println(result);
        bw.flush();
        bw.close();
    }
}


